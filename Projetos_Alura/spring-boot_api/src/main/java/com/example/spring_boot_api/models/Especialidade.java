package com.example.spring_boot_api.models;

public enum Especialidade {
    PEDIATRIA("Cardiologia"),
    GINECOLOGIA("Ginecologia"),
    NEUROLOGIA("Neurologia"),
    CLÍNICA_MÉDICA("Clínica Médica"),
    CARDIOLOGIA("Cardiologia"),
    ORTOPEDIA("Ortopedia");

    private final String descricao;

    Especialidade(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    public static Especialidade fromDescricao(String descricao) {
        for (Especialidade e : Especialidade.values()){
            if (e.getDescricao().equalsIgnoreCase(descricao)){
                return e;
            }
        }
        throw new IllegalArgumentException("Especialidade inválida: " + descricao);
    }
}
