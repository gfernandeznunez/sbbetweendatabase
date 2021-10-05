package com.example.sbbetweendatabase.listener;


import com.example.sbbetweendatabase.primary.model.InputUsuario;
import com.example.sbbetweendatabase.secondary.model.Usuario;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.ItemProcessListener;

public class UsuarioProcessListener implements ItemProcessListener<InputUsuario, Usuario> {

    private static final Logger LOGGER = LoggerFactory.getLogger(UsuarioProcessListener.class);

    @Override
    public void beforeProcess(InputUsuario usuario) {
        LOGGER.info("Antes del procesamiento");
    }

    @Override
    public void afterProcess(InputUsuario inUsuario, Usuario outUsuario) {
        LOGGER.info("Después del Procesamiento: " + inUsuario + " ---> " + outUsuario);
    }

    @Override
    public void onProcessError(InputUsuario usuario, Exception e) {
        LOGGER.info("onProcessError");
    }
}