package com.example.sbbetweendatabase.job;

import com.example.sbbetweendatabase.primary.dao.JpaUsuarioDAO;
import com.example.sbbetweendatabase.primary.model.InputUsuario;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.annotation.BeforeStep;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Iterator;

@Component
public class UsuarioReader implements ItemReader<InputUsuario> {

    @Autowired
    private JpaUsuarioDAO usuarioDAO;

    private Iterator<InputUsuario> usuarioIterator;

    @BeforeStep
    public void before(StepExecution stepExecution) {
        usuarioIterator = usuarioDAO.findAll().iterator();
    }

    @Override
    public InputUsuario read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {

        if(usuarioIterator != null && usuarioIterator.hasNext()){
            return usuarioIterator.next();
        } else{
            return null;
        }
    }
}
