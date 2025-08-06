package com.example.spring_boot_api.models;
import com.example.spring_boot_api.web.DadosMedicoDTO;
import com.example.spring_boot_api.web.UpdateMedicoDTO;
import com.example.spring_boot_api.web.UpdatePessoaDTO;
import jakarta.persistence.*;

@Entity
@Table(name = "medicos")
public class Medico extends Pessoa {

    @Column(name = "crm", unique = true,length = 6, nullable = false)
    private String crm;
    @Enumerated(EnumType.STRING)
    @Convert(converter = EspecialidadeConverter.class)
    @Column(length = 100, nullable = false)
    private Especialidade especialidade;

    public Medico() {
    }

    public Medico(Long id, String nome, String email, String logradouro, String bairro, String cep,
                  String complemento, String numero, String uf, String cidade, String telefone,
                  boolean ativo, String crm, Especialidade especialidade) {
        super(id, nome, email, logradouro, bairro, cep, complemento, numero, uf, cidade, telefone, ativo);
        this.crm = crm;
        this.especialidade = especialidade;
    }

    public String getCrm() {
        return crm;
    }

    public void setCrm(String crm) {
        this.crm = crm;
    }

    public Especialidade getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(Especialidade especialidade) {
        this.especialidade = especialidade;
    }

    public Medico(DadosMedicoDTO dadosMedicoDTO){
        setNome(dadosMedicoDTO.nome());
        setEmail(dadosMedicoDTO.email());
        setCrm(dadosMedicoDTO.crm());
        setEspecialidade(dadosMedicoDTO.especialidade());
        setLogradouro(dadosMedicoDTO.logradouro());
        setBairro(dadosMedicoDTO.bairro());
        setCidade(dadosMedicoDTO.cidade());
        setCep(dadosMedicoDTO.cep());
        setUf(dadosMedicoDTO.uf());
        setNumero(dadosMedicoDTO.numero());
        setComplemento(dadosMedicoDTO.complemento());
        setTelefone(dadosMedicoDTO.telefone());
    }


    public void atualizaInformacoes(UpdatePessoaDTO updatePessoaDTO) {
        this.nome = updatePessoaDTO.nome();
        this.logradouro = updatePessoaDTO.logradouro();
        this.bairro = updatePessoaDTO.bairro();
        this.complemento = updatePessoaDTO.complemento();
        this.numero = updatePessoaDTO.numero();
        this.cidade = updatePessoaDTO.cidade();
        this.cep = updatePessoaDTO.cep();
        this.uf = updatePessoaDTO.uf();
    }

    public void desativarMedico() {

        this.ativo = false;
    }

}
