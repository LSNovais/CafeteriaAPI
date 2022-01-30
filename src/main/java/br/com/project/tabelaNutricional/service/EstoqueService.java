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
import br.com.project.tabelaNutricional.model.Estoque;
import br.com.project.tabelaNutricional.repository.DadosNutricionaisRepository;
import br.com.project.tabelaNutricional.repository.EstoqueRepository;
import lombok.AllArgsConstructor;



/**
 * @version 1.0
 * @author Lucas Novais dos Santos
 */
@Service
@AllArgsConstructor
public class EstoqueService {

    public EstoqueService(){};

    private static Logger logger = LoggerFactory.getLogger(EstoqueService.class);



    @Autowired
    private EstoqueRepository estoqueRepository;


    
    /**
     * Realiza a consulta no banco das transações realizadas
     * @return Uma lista de todas as consultas realizadas {currencyRepository.findAll()}
     * @since 11.0
     */
    public List<Estoque> findAll() throws NullPointerException, SQLDataException, DataAccessException, Exception{
        logger.info("CurrencyService.findAll - Consultando conversões");
        return estoqueRepository.findAll();
    }

     

    /**
     * Realiza a consulta no banco das transações realizadas
     * @return Uma lista de todas as consultas realizadas {currencyRepository.findAll()}
     * @since 11.0
     */
    public Estoque findByCodBarras(Integer codBarras) throws NullPointerException, SQLDataException, DataAccessException, Exception{
        logger.info("CurrencyService.findAll - Consultando conversões");
        Estoque estoques = new Estoque();
        DadosNutricionaisEstoqueDTO estoqueDTO = new DadosNutricionaisEstoqueDTO();
        for(Estoque estoque : estoqueRepository.findAll()){
            if(estoque.getCodBarras().equals(codBarras)){
                estoques = estoque;
                break;
            }
        }

        estoqueDTO.setCodBarras(estoques.getCodBarras());
        estoqueDTO.setNomeProduto(estoques.getNomeProduto());

        return estoques;

    }


    /**
     * Salva o valor de conversão do usuário
     * @param currency Possui os valores que serão salvos no banco de dados
     * @return Valores de conversão salvos {currencyRepository.save(currency)}
     * @since 11.0
     */
    public Estoque save(Estoque estoque){
        logger.info("CurrencyService.save - Salvando valor convertido");
        return estoqueRepository.save(estoque);
    }
    
    
}