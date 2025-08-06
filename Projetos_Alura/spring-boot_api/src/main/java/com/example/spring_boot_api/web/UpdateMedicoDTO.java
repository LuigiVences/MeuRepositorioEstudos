package com.example.spring_boot_api.web;

import com.example.spring_boot_api.models.Especialidade;
import com.example.spring_boot_api.models.Medico;

import java.util.Map;
import java.util.Optional;

public record UpdateMedicoDTO(Long id, String nome, String email, String crm, String especialidade,
                              String logradouro, String bairro, String complemento, String numero,
                              String cep, String cidade, String uf, String telefone) {

    public UpdateMedicoDTO(Medico medico){
        this(medico.getId(), medico.getNome(), medico.getEmail(), medico.getCrm(), medico.getEspecialidade().name(),
                medico.getLogradouro(), medico.getBairro(), medico.getComplemento(), medico.getNumero(),
                medico.getCep(), medico.getCidade(), medico.getUf(), medico.getTelefone());
    }

    public UpdateMedicoDTO(Optional<Medico>medico){
        this(
                medico.map(Medico::getId).orElse(null),
                medico.map(Medico::getNome).orElse(null),
                medico.map(Medico::getEmail).orElse(null),
                medico.map(Medico::getCrm).orElse(null),
                String.valueOf(medico.map(Medico::getEspecialidade).orElse(null)),
                medico.map(Medico::getLogradouro).orElse(null),
                medico.map(Medico::getBairro).orElse(null),
                medico.map(Medico::getComplemento).orElse(null),
                medico.map(Medico::getNumero).orElse(null),
                medico.map(Medico::getCep).orElse(null),
                medico.map(Medico::getCidade).orElse(null),
                medico.map(Medico::getUf).orElse(null),
                medico.map(Medico::getTelefone).orElse(null)
        );
    }

}

