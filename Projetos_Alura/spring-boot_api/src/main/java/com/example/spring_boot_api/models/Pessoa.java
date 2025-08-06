package com.example.spring_boot_api.models;

import jakarta.persistence.*;
@MappedSuperclass
public abstract class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;
    @Column(length = 150, nullable = false)
    protected String nome;
    @Column(name = "email", unique = true, length = 100, nullable = false)
    protected String email;
    @Column(length = 120, nullable = false)
    protected String logradouro;
    @Column(length = 100, nullable = false)
    protected String bairro;
    @Column(length = 9, nullable = false)
    protected String cep;
    @Column(length = 100)
    protected String complemento;
    @Column(length = 20)
    protected String numero;
    @Column(length = 2, nullable = false)
    protected String uf;
    @Column(length = 100)
    protected String cidade;
    @Column(length = 11)
    protected String telefone;
    protected boolean ativo = true;

    public Pessoa(Long id, String nome, String email, String logradouro, String bairro, String cep,
                  String complemento, String numero, String uf, String cidade, String telefone,
                  boolean ativo) {

        this.id = id;
        this.nome = nome;
        this.email = email;
        this.logradouro = logradouro;
        this.bairro = bairro;
        this.cep = cep;
        this.complemento = complemento;
        this.numero = numero;
        this.uf = uf;
        this.cidade = cidade;
        this.telefone = telefone;
        this.ativo = ativo;
    }

    public Pessoa() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }
}
