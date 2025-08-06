package com.example.spring_boot_api.web;

import com.example.spring_boot_api.models.Pessoa;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.validation.annotation.Validated;

@Validated
public record UpdatePessoaDTO(
        @NotNull
        Long id,
        @NotBlank
        String nome,
        @NotBlank
        String logradouro,
        @NotBlank
        String bairro,
        @NotBlank
        String cidade,
        @NotBlank
        String cep,
        String complemento,
        String numero,
        @NotBlank
        String uf) {

    public UpdatePessoaDTO(Pessoa pessoa){
        this(pessoa.getId(), pessoa.getNome(), pessoa.getLogradouro(), pessoa.getBairro(),
                pessoa.getCidade(), pessoa.getCep(), pessoa.getComplemento(), pessoa.getNumero(),
                pessoa.getUf());
    }
}
