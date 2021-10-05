package com.example.sbbetweendatabase.job;

import com.example.sbbetweendatabase.primary.model.InputUsuario;
import com.example.sbbetweendatabase.secondary.model.Usuario;
import org.springframework.batch.item.ItemProcessor;

public class UsuarioProcessor implements ItemProcessor<InputUsuario, Usuario> {

    @Override
    public Usuario process(InputUsuario usuario) throws Exception {
        Usuario outUsuario = new Usuario();

        outUsuario.setId(usuario.getId());
        outUsuario.setRut(usuario.getRut());
        outUsuario.setNombres(usuario.getNombres());
        outUsuario.setApellidos(usuario.getApellidos());

        System.out.println("Hola "+outUsuario.getNombres());

        return outUsuario;
    }
}
