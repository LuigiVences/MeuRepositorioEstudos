package com.luizvenceslau.PaeseWeb.exception;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

@Component
public class CustomAuthenticationFailureHandler implements AuthenticationFailureHandler {
    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
                                        AuthenticationException exception) throws IOException {

        String errorMessage = "E-mail ou senha inválidos";

        if (exception.getCause() instanceof DisabledException ||
                exception instanceof DisabledException){
            errorMessage = "Conta inativa. Contate o administrador";
        }
        response.sendRedirect("/login?error=" +
                URLEncoder.encode(errorMessage, StandardCharsets.UTF_8));
    }
}
