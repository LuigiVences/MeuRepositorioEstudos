package com.luizvenceslau.PaeseWeb.login.dto;


import com.luizvenceslau.PaeseWeb.validation.ValidEmail;
import javax.validation.constraints.NotBlank;

@Validated
public record LoginRequest(
    @NotBlank(message = "Email não pode estar em branco")
    @NotNull(message = "Email não pode ser nulo")
    @ValidEmail
    String email,

    @NotBlank(message = "Senha não pode estar em branco") 
    @NotNull(message = "Senha não pode ser nula")
    String password) {

}
