package com.example.sbbetweendatabase.listener;

import com.example.sbbetweendatabase.secondary.model.Usuario;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.ItemWriteListener;

import java.util.List;

public class UsuarioWriterListener implements ItemWriteListener<Usuario> {

    private static final Logger LOGGER = LoggerFactory.getLogger(UsuarioWriterListener.class);

    @Override
    public void beforeWrite(List<? extends Usuario> list) {
        LOGGER.info("Antes de la escritura");
    }

    @Override
    public void afterWrite(List<? extends Usuario> list) {
        for (Usuario usuario : list) {
            LOGGER.info("Después de la escritura :" + usuario.toString());
        }
    }

    @Override
    public void onWriteError(Exception e, List<? extends Usuario> list) {
        LOGGER.info("onWriteError");
    }
}
