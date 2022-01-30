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
@Table(name = "ESTOQUE")
@Data
public class Estoque {

    @Id
    @Column(name = "cod_barras")
    Integer codBarras;

    @Name("nome_produto")
    String nomeProduto;

    @Name("quantidade")
    Integer quantidade;

    @Name("preco")
    float preco;

    @Name("peso")
    float peso;

    @Name("dt_cadastro")
    Date dtCadastro;

    @Name("id_usuario_cadastro")
    String idUsuarioCadastro;





    public Integer getCodBarras() {
        return this.codBarras;
    }

    public void setCodBarras(Integer codBarras) {
        this.codBarras = codBarras;
    }

    public String getNomeProduto() {
        return this.nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public Integer getQuantidade() {
        return this.quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public float getPreco() {
        return this.preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    public float getPeso() {
        return this.peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public Date getDtCadastro() {
        return this.dtCadastro;
    }

    public void setDtCadastro(Date dtCadastro) {
        this.dtCadastro = dtCadastro;
    }

    public String getIdUsuarioCadastro() {
        return this.idUsuarioCadastro;
    }

    public void setIdUsuarioCadastro(String idUsuarioCadastro) {
        this.idUsuarioCadastro = idUsuarioCadastro;
    }

}
