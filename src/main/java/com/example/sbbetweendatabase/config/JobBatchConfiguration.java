package com.example.sbbetweendatabase.config;

import com.example.sbbetweendatabase.job.UsuarioProcessor;
import com.example.sbbetweendatabase.job.UsuarioReader;
import com.example.sbbetweendatabase.job.UsuarioWriter;
import com.example.sbbetweendatabase.listener.UsuarioJobExecutionListener;
import com.example.sbbetweendatabase.listener.UsuarioProcessListener;
import com.example.sbbetweendatabase.listener.UsuarioReaderListener;
import com.example.sbbetweendatabase.listener.UsuarioWriterListener;
import com.example.sbbetweendatabase.primary.model.InputUsuario;
import com.example.sbbetweendatabase.secondary.model.Usuario;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.step.tasklet.TaskletStep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableBatchProcessing
public class JobBatchConfiguration {

    @Autowired
    public JobBuilderFactory jobBuilderFactory;

    @Autowired
    public StepBuilderFactory stepBuilderFactory;

    @Bean
    public UsuarioReader reader(){
        return new UsuarioReader();
    }

    @Bean
    public UsuarioProcessor processor(){
        return new UsuarioProcessor();
    }

    @Bean
    public UsuarioWriter writer(){
        return new UsuarioWriter();
    }

    @Bean
    public UsuarioJobExecutionListener jobExecutionListener(){
        return new UsuarioJobExecutionListener();
    }

    @Bean
    public UsuarioReaderListener readerListener() {
        return new UsuarioReaderListener();
    }

    @Bean
    public UsuarioProcessListener UsuarioProcessListener() {
        return new UsuarioProcessListener();
    }

    @Bean
    public UsuarioWriterListener writerListener() {
        return new UsuarioWriterListener();
    }



    @Bean
    public Job job(Step step, UsuarioJobExecutionListener jobExecutionListener){
        Job job = jobBuilderFactory.get("Job01")
                .listener(jobExecutionListener)
                .flow(step)
                .end()
                .build();
        return job;
    }

    @Bean
    public Step step(UsuarioReader reader,
                     UsuarioProcessor processor,
                     UsuarioWriter writer,
                     UsuarioProcessListener usuarioProcessListener
    ){
        TaskletStep step = stepBuilderFactory.get("Step01")
                .listener(usuarioProcessListener)
                .<InputUsuario, Usuario>chunk(100)
                .reader(reader)
                .processor(processor)
                .writer(writer)
                .build();

        return step;
    }
}
