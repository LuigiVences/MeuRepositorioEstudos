package com.luizvenceslau.PaeseWeb.config;

import com.luizvenceslau.PaeseWeb.auditing.ApplicationAuditAware;
import com.luizvenceslau.PaeseWeb.model.entities.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;

@Configuration
public class ApplicationConfig {

    @Bean
    public AuditorAware<User> auditorProvider (){
        return new ApplicationAuditAware();
    }

}
