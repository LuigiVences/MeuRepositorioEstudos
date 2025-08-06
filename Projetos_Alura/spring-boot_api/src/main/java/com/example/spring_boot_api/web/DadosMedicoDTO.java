package com.example.spring_boot_api.web;

import com.example.spring_boot_api.models.Especialidade;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.validation.annotation.Validated;

@Validated
public record DadosMedicoDTO(

        @NotBlank
        String nome,
        @NotBlank
        @Email
        String email,
        @NotBlank
        String crm,
        @NotNull
        Especialidade especialidade,
        @NotBlank
        String logradouro,
        @NotBlank
        String bairro,
        @NotBlank
        String cep,
        String complemento,
        String numero,
        @NotBlank
        String uf,
        @NotBlank
        String cidade,
        @NotNull
        String telefone) {


}
