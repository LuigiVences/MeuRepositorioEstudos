package com.example.spring_boot_api.web;

import com.example.spring_boot_api.models.Especialidade;
import com.example.spring_boot_api.models.Medico;

import java.util.List;

public record ListMedicoDTO(
        String nome,
        Especialidade especialidade,
        String crm,
        String email) {

    public ListMedicoDTO(Medico medico){this(medico.getNome(), medico.getEspecialidade(),
            medico.getCrm(), medico.getEmail());}

}
