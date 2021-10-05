package com.example.sbbetweendatabase.secondary.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Table(name="destino")
@Entity
public class Usuario{

    @Id
    private Long id;

    @Column(name = "rut")
    private String rut;

    @Column(name = "nombres")
    private String nombres;

    @Column(name = "apellidos")
    private String apellidos;
}