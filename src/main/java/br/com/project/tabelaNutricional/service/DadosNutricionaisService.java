/*
 * Class: CurrencyService.java
 * Created: 29/10/2021
 * Rights Reserved: Jaya
 */  

package br.com.project.tabelaNutricional.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.SQLDataException;
import java.util.ArrayList;
import java.util.List;

import br.com.project.tabelaNutricional.dto.DadosNutricionaisEstoqueDTO;
import br.com.project.tabelaNutricional.model.DadosNutricionais;
import br.com.project.tabelaNutricional.repository.DadosNutricionaisRepository;
import lombok.AllArgsConstructor;



/**
 * @version 1.0
 * @author Lucas Novais dos Santos
 */
@Service
@AllArgsConstructor
public class DadosNutricionaisService {

    public DadosNutricionaisService(){};

    private static Logger logger = LoggerFactory.getLogger(DadosNutricionaisService.class);



    @Autowired
    private DadosNutricionaisRepository dadosNutricionaisRepository;
    


    
    /**
     * Realiza a consulta no banco das transações realizadas
     * @return Uma lista de todas as consultas realizadas {currencyRepository.findAll()}
     * @since 11.0
     */
    public List<DadosNutricionais> findAll() throws NullPointerException, SQLDataException, DataAccessException, Exception{
        logger.info("CurrencyService.findAll - Consultando conversões");
        return dadosNutricionaisRepository.findAll();
    }


        
    /**
     * Realiza a consulta no banco das transações realizadas
     * @return Uma lista de todas as consultas realizadas {currencyRepository.findAll()}
     * @since 11.0
     */
    public DadosNutricionais findByCodBarras(Integer codBarras) throws NullPointerException, SQLDataException, DataAccessException, Exception{
        logger.info("CurrencyService.findAll - Consultando conversões");
        DadosNutricionais dadosNutricionais = new DadosNutricionais();
        for(DadosNutricionais dadoNutricional : dadosNutricionaisRepository.findAll()){
            if(dadoNutricional.getCodBarras().equals(codBarras)){
                dadosNutricionais = dadoNutricional;
                break;
            }
        }

        return dadosNutricionais;

    }

        
    /**
     * Realiza a consulta no banco das transações realizadas
     * @return Uma lista de todas as consultas realizadas {currencyRepository.findAll()}
     * @since 11.0
     */
    public DadosNutricionaisEstoqueDTO findEstoqueTabelaNutricionalByCodBarras(Integer codBarras) throws NullPointerException, SQLDataException, DataAccessException, Exception{
        logger.info("CurrencyService.findAll - Consultando conversões");
        DadosNutricionais dadosNutricionais = new DadosNutricionais();
        DadosNutricionaisEstoqueDTO dadosNutricionaisEstoqueDTO = new DadosNutricionaisEstoqueDTO();
        for(DadosNutricionais dadoNutricional : dadosNutricionaisRepository.findAll()){
            if(dadoNutricional.getCodBarras().equals(codBarras)){
                dadosNutricionais = dadoNutricional;
                break;
            }
        }

        dadosNutricionaisEstoqueDTO.setCodBarras(codBarras);
        dadosNutricionaisEstoqueDTO.setValorEnergetico(dadosNutricionais.getValorEnergetico());
        dadosNutricionaisEstoqueDTO.setCarboidratos(dadosNutricionais.getCarboidratos());
        dadosNutricionaisEstoqueDTO.setProteinas(dadosNutricionais.getProteinas());
        dadosNutricionaisEstoqueDTO.setGordurasTotais(dadosNutricionais.getGordurasTotais());
        dadosNutricionaisEstoqueDTO.setGordurasSaturadas(dadosNutricionais.getGordurasSaturadas());
        dadosNutricionaisEstoqueDTO.setGordurasTrans(dadosNutricionais.getGordurasTrans());
        dadosNutricionaisEstoqueDTO.setFibraAlimentar(dadosNutricionais.getFibraAlimentar());
        dadosNutricionaisEstoqueDTO.setSodio(dadosNutricionais.getSodio());
        dadosNutricionaisEstoqueDTO.setDataValidade(dadosNutricionais.getDataValidade());
        dadosNutricionaisEstoqueDTO.setDataFabricacao(dadosNutricionais.getDataFabricacao());
        dadosNutricionaisEstoqueDTO.setComentarios(dadosNutricionais.getComentarios());
        dadosNutricionaisEstoqueDTO.setVdValorEnergetico(dadosNutricionais.getVdValorEnergetico());
        dadosNutricionaisEstoqueDTO.setVdCarboidratos(dadosNutricionais.getVdCarboidratos());
        dadosNutricionaisEstoqueDTO.setVdProteinas(dadosNutricionais.getVdProteinas());
        dadosNutricionaisEstoqueDTO.setVdGordurasTotais(dadosNutricionais.getVdGordurasTotais());
        dadosNutricionaisEstoqueDTO.setVdGordurasSaturadas(dadosNutricionais.getVdGordurasSaturadas());
        dadosNutricionaisEstoqueDTO.setVdGordurasTrans(dadosNutricionais.getVdGordurasTrans());
        dadosNutricionaisEstoqueDTO.setVdFibraAlimentar(dadosNutricionais.getVdFibraAlimentar());
        dadosNutricionaisEstoqueDTO.setVdSodio(dadosNutricionais.getVdSodio());

        return dadosNutricionaisEstoqueDTO;

    }



    /**
     * Salva o valor de conversão do usuário
     * @param currency Possui os valores que serão salvos no banco de dados
     * @return Valores de conversão salvos {currencyRepository.save(currency)}
     * @since 11.0
     */
    public DadosNutricionais save(DadosNutricionais dadosNutricionais){
        logger.info("CurrencyService.save - Salvando valor convertido");
        return dadosNutricionaisRepository.save(dadosNutricionais);
    }
    
    
}