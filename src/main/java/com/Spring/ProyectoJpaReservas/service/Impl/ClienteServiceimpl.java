package com.Spring.ProyectoJpaReservas.service.Impl;

import com.Spring.ProyectoJpaReservas.persistence.entity.Cliente;
import com.Spring.ProyectoJpaReservas.persistence.repository.ClienteRepository;
import com.Spring.ProyectoJpaReservas.service.IClienteService;
import org.modelmapper.internal.bytebuddy.implementation.bytecode.Throw;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteServiceimpl implements IClienteService {
    private ClienteRepository clienteRepository;

    public ClienteServiceimpl(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }


    @Override
    public List<Cliente> findAll() {
        return clienteRepository.findAll();
    }

    @Override
    public Cliente crear(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    @Override
    public String eliminar(Long id) {
        Optional<Cliente> obtener = findById(id);

        if (obtener.isPresent()){
            Cliente cliente = obtener.get();
            clienteRepository.delete(cliente);
            return "Usuario con "+ id + "Elimando";
        }else {
            return "Error al elimnar el usuario";

        }

    }

    @Override
    public Cliente Actualizar(Cliente cliente, Long id) {
      Optional<Cliente> actualizar = findById(id);
      if (actualizar.isPresent()){
          Cliente obtener = actualizar.get();
          obtener.setEmail(cliente.getEmail());
          obtener.setName(cliente.getName());
          obtener.setPassword(cliente.getPassword());
          obtener.setPicture(cliente.getPicture());
          obtener.setReservas(cliente.getReservas());
          return clienteRepository.save(obtener);
      }
      return cliente;
    }

    @Override
    public Optional<Cliente> findById(Long id) {
        return clienteRepository.findById(id);
    }
}
