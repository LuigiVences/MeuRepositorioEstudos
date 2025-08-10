package com.luizvenceslau.PaeseWeb.config;

import com.luizvenceslau.PaeseWeb.auditing.ApplicationAuditAware;
import com.luizvenceslau.PaeseWeb.model.entities.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@Configuration
@EnableJpaAuditing(auditorAwareRef = "auditorAware")
public class ApplicationConfig {

    @Bean
    public AuditorAware<User> auditorAware (){
        return new ApplicationAuditAware();
    }

}
