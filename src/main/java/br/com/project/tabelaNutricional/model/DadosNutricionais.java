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
@Table(name = "DADOSNUTRICIONAIS")
@Data
public class DadosNutricionais {
    

    @Id
    @Column(name = "cod_barras")
    Integer codBarras;

    @Name("valor_energetico")
    Integer valorEnergetico;

    @Name("carboidratos")
    Integer carboidratos;

    @Name("proteinas")
    Integer proteinas;

    @Name("gorduras_totais")
    Integer gordurasTotais;

    @Name("gorduras_saturadas")
    Integer gordurasSaturadas;

    @Name("gorduras_trans")
    Integer gordurasTrans;
    
    @Name("fibra_alimentar")
    Integer fibraAlimentar;

    @Name("sodio")
    Integer sodio;

    @Name("data_validade")
    Date dataValidade;

    @Name("data_fabricacao")
    Date dataFabricacao;

    @Name("comentarios")
    String comentarios;

    //vd -> Valores Diarios
    @Name("vd_valor_energetico")
    Integer vdValorEnergetico;

    @Name("vd_carboidratos")
    Integer vdCarboidratos;

    @Name("vd_proteinas")
    Integer vdProteinas;

    @Name("vd_gorduras_totais")
    Integer vdGordurasTotais;

    @Name("vd_gorduras_saturadas")
    Integer vdGordurasSaturadas;

    @Name("vd_gorduras_trans")
    Integer vdGordurasTrans;
    
    @Name("vd_fibra_alimentar")
    Integer vdFibraAlimentar;

    @Name("vd_sodio")
    Integer vdSodio;


    public Integer getCodBarras() {
        return this.codBarras;
    }

    public void setCodBarras(Integer codBarras) {
        this.codBarras = codBarras;
    }

    public Integer getValorEnergetico() {
        return this.valorEnergetico;
    }

    public void setValorEnergetico(Integer valorEnergetico) {
        this.valorEnergetico = valorEnergetico;
    }

    public Integer getCarboidratos() {
        return this.carboidratos;
    }

    public void setCarboidratos(Integer carboidratos) {
        this.carboidratos = carboidratos;
    }

    public Integer getProteinas() {
        return this.proteinas;
    }

    public void setProteinas(Integer proteinas) {
        this.proteinas = proteinas;
    }

    public Integer getGordurasTotais() {
        return this.gordurasTotais;
    }

    public void setGordurasTotais(Integer gordurasTotais) {
        this.gordurasTotais = gordurasTotais;
    }

    public Integer getGordurasSaturadas() {
        return this.gordurasSaturadas;
    }

    public void setGordurasSaturadas(Integer gordurasSaturadas) {
        this.gordurasSaturadas = gordurasSaturadas;
    }

    public Integer getGordurasTrans() {
        return this.gordurasTrans;
    }

    public void setGordurasTrans(Integer gordurasTrans) {
        this.gordurasTrans = gordurasTrans;
    }

    public Integer getFibraAlimentar() {
        return this.fibraAlimentar;
    }

    public void setFibraAlimentar(Integer fibraAlimentar) {
        this.fibraAlimentar = fibraAlimentar;
    }

    public Integer getSodio() {
        return this.sodio;
    }

    public void setSodio(Integer sodio) {
        this.sodio = sodio;
    }

    public Date getDataValidade() {
        return this.dataValidade;
    }

    public void setDataValidade(Date dataValidade) {
        this.dataValidade = dataValidade;
    }

    public Date getDataFabricacao() {
        return this.dataFabricacao;
    }

    public void setDataFabricacao(Date dataFabricacao) {
        this.dataFabricacao = dataFabricacao;
    }

    public String getComentarios() {
        return this.comentarios;
    }

    public void setComentarios(String comentarios) {
        this.comentarios = comentarios;
    }

    public Integer getVdValorEnergetico() {
        return this.vdValorEnergetico;
    }

    public void setVdValorEnergetico(Integer vdValorEnergetico) {
        this.vdValorEnergetico = vdValorEnergetico;
    }

    public Integer getVdCarboidratos() {
        return this.vdCarboidratos;
    }

    public void setVdCarboidratos(Integer vdCarboidratos) {
        this.vdCarboidratos = vdCarboidratos;
    }

    public Integer getVdProteinas() {
        return this.vdProteinas;
    }

    public void setVdProteinas(Integer vdProteinas) {
        this.vdProteinas = vdProteinas;
    }

    public Integer getVdGordurasTotais() {
        return this.vdGordurasTotais;
    }

    public void setVdGordurasTotais(Integer vdGordurasTotais) {
        this.vdGordurasTotais = vdGordurasTotais;
    }

    public Integer getVdGordurasSaturadas() {
        return this.vdGordurasSaturadas;
    }

    public void setVdGordurasSaturadas(Integer vdGordurasSaturadas) {
        this.vdGordurasSaturadas = vdGordurasSaturadas;
    }

    public Integer getVdGordurasTrans() {
        return this.vdGordurasTrans;
    }

    public void setVdGordurasTrans(Integer vdGordurasTrans) {
        this.vdGordurasTrans = vdGordurasTrans;
    }

    public Integer getVdFibraAlimentar() {
        return this.vdFibraAlimentar;
    }

    public void setVdFibraAlimentar(Integer vdFibraAlimentar) {
        this.vdFibraAlimentar = vdFibraAlimentar;
    }

    public Integer getVdSodio() {
        return this.vdSodio;
    }

    public void setVdSodio(Integer vdSodio) {
        this.vdSodio = vdSodio;
    }


}