package com.example.spring_boot_api.models;
import jakarta.persistence.*;
@Entity
@Table(name = "pecientes")
public class Paciente extends Pessoa{

    @Column(name = "cpf", unique = true,length = 11, nullable = false)
    private String cpf;


    public Paciente() {
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}
