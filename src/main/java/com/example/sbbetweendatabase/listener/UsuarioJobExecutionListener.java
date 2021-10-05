package com.example.sbbetweendatabase.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;

public class UsuarioJobExecutionListener implements JobExecutionListener{

    private static final Logger LOGGER = LoggerFactory.getLogger(UsuarioJobExecutionListener.class);

    @Override
    public void beforeJob(JobExecution jobExecution) {
        LOGGER.info("Antes del JOB");
    }

    @Override
    public void afterJob(JobExecution jobExecution) {
        LOGGER.info("Después del JOB: " + jobExecution.getStatus());
    }
}

