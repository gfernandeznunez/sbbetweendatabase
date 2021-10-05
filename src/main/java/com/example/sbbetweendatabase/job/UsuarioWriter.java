package com.example.sbbetweendatabase.job;

import com.example.sbbetweendatabase.secondary.repositories.UsuarioRepository;
import com.example.sbbetweendatabase.secondary.model.Usuario;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class UsuarioWriter implements ItemWriter<Usuario> {

    @Autowired
    private UsuarioRepository repoUsuario;

    @Override
    public void write(List<? extends Usuario> list) throws Exception {
        repoUsuario.saveAll(list);
    }
}
