package com.Spring.ProyectoJpaReservas.persistence.repository;

import com.Spring.ProyectoJpaReservas.persistence.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente,Long> {
}
