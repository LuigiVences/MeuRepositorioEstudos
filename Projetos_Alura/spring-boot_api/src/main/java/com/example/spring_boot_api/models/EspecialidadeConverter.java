package com.example.spring_boot_api.models;

import jakarta.persistence.AttributeConverter;

public class EspecialidadeConverter implements AttributeConverter<Especialidade,String> {
    @Override
    public String convertToDatabaseColumn(Especialidade especialidade) {
        return especialidade != null ? especialidade.getDescricao() : null;
    }

    @Override
    public Especialidade convertToEntityAttribute(String descricao) {
        return descricao != null ? Especialidade.fromDescricao(descricao) : null;
    }
}
