package com.example.sbbetweendatabase.listener;

import com.example.sbbetweendatabase.primary.model.InputUsuario;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.batch.core.ItemReadListener;

public class UsuarioReaderListener implements ItemReadListener<InputUsuario> {

    private static final Logger LOGGER = LoggerFactory.getLogger(UsuarioReaderListener.class);

    @Override
    public void beforeRead() {
        LOGGER.info("Antes de Lectura");
    }

    @Override
    public void afterRead(InputUsuario usuario) {
        LOGGER.info("Después de la lectura: " + usuario.toString());
    }

    @Override
    public void onReadError(Exception e) {
        LOGGER.info("onReadError");
    }
}
