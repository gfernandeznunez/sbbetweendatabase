package com.example.sbbetweendatabase.primary.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity(name = "usuario")
public class InputUsuario {

    @Id
    private Long id;
    private String rut;
    private String nombres;
    private String apellidos;
}
