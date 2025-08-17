package com.luizvenceslau.PaeseWeb.auth.dto;


import com.luizvenceslau.PaeseWeb.validation.ValidEmail;
import jakarta.validation.constraints.NotNull;
import org.springframework.validation.annotation.Validated;

@Validated
public record LoginRequest(

    @NotNull(message = "Email não pode ser nulo")
    @ValidEmail
    String email,


    @NotNull(message = "Senha não pode ser nula")
    String password) {

}
