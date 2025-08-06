package com.example.spring_boot_api.web;

import com.example.spring_boot_api.models.Medico;
import com.example.spring_boot_api.models.Paciente;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.validation.annotation.Validated;

@Validated
public record DadosEnderecoDTO(@NotNull
                                     Long id,
                               @NotBlank
                                     String logradouro,
                               @NotBlank
                                     String bairro,
                               @NotBlank
                                     String cep,
                               String complemento,
                               @NotBlank
                                     String numero,
                               @NotBlank
                                     String uf,
                               @NotBlank
                                     String cidade) {

    public DadosEnderecoDTO(Medico medico){
        this(medico.getId(), medico.getLogradouro(), medico.getBairro(), medico.getCep(), medico.getComplemento(),
                medico.getNumero(), medico.getUf(), medico.getCidade());
    }

    public DadosEnderecoDTO(Paciente paciente){
        this(paciente.getId(), paciente.getLogradouro(), paciente.getBairro(), paciente.getCep(),
                paciente.getComplemento(), paciente.getNumero(), paciente.getUf(), paciente.getCidade());
    }
}
