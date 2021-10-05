package com.example.sbbetweendatabase.primary.dao;

import com.example.sbbetweendatabase.primary.model.InputUsuario;

import java.util.List;

public interface UsuarioDAO {
    List<InputUsuario> findAll();
}
