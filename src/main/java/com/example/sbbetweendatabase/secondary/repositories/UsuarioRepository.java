package com.example.sbbetweendatabase.secondary.repositories;

import com.example.sbbetweendatabase.secondary.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
