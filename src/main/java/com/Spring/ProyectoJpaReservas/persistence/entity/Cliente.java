package com.Spring.ProyectoJpaReservas.persistence.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "Clientes")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "Nombre")
    private String name;

    @Column(name = "correo")
    private String email;

    @Column(name = "Contraseña")
    private int password;

    @Column(name = "foto")
    private String picture;

    @OneToMany(mappedBy = "Cliente", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonManagedReference
    private List<Reservas>  reservas;






}
