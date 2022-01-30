/*
 * Class: DadosNutricionais.java
 * Created: 23/01/2022
 * Rights Reserved: Lucas da Silva Novais
 */  

package br.com.project.tabelaNutricional.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import jdk.jfr.Name;
import lombok.Data;




/**
 * @version 1.0
 * @author Lucas da Silva Novais
 */
@Entity
@Table(name = "USUARIO")
@Data
public class Usuario {

    @Id
    @Column(name = "id")
    Integer id;

    @Name("nome")
    String nome;

    @Name("sobrenome")
    String sobrenome;

    @Name("email")
    String email;

    @Name("cpf")
    Long cpf;

    @Name("dt_nascimento")
    Date dtNascimento;

    @Name("senha")
    String senha;

    @Name("cod_perfil")
    Integer codPerfil;

    @Name("dt_ult_login")
    Date dtUltLogin;
    
    @Name("sts_ativo")
    Integer stsAtivo;

    


    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return this.sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getCpf() {
        return this.cpf;
    }

    public void setCpf(Long cpf) {
        this.cpf = cpf;
    }

    public Date getDtNascimento() {
        return this.dtNascimento;
    }

    public void setDtNascimento(Date dtNascimento) {
        this.dtNascimento = dtNascimento;
    }

    public String getSenha() {
        return this.senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Integer getCodPerfil() {
        return this.codPerfil;
    }

    public void setCodPerfil(Integer codPerfil) {
        this.codPerfil = codPerfil;
    }

    public Date getDtUltLogin() {
        return this.dtUltLogin;
    }

    public void setDtUltLogin(Date dtUltLogin) {
        this.dtUltLogin = dtUltLogin;
    }

    public Integer getStsAtivo() {
        return this.stsAtivo;
    }

    public void setStsAtivo(Integer stsAtivo) {
        this.stsAtivo = stsAtivo;
    }

}
