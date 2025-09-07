package com.luizvenceslau.PaeseWeb.service.user;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    private final JavaMailSender mailSender;


    public EmailService(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    public void sendEmail(String email, String password ){
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo();
        message.setSubject("teste de envio de e-mail");
        message.setText("Este é um e-mail de teste enviado pelo Spring Boot");
        mailSender.send(message);
    }

}
