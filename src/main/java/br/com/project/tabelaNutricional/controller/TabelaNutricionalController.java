/*
 * Class: TabelaNutricionalController.java
 * Created: 29/10/2021
 * Created by: Lucas Novais dos Santos
 * Rights Reserved: Jaya
 */  

package br.com.project.tabelaNutricional.controller;

import java.sql.SQLDataException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageConversionException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.project.tabelaNutricional.TabelaNutricionalApplication;
import br.com.project.tabelaNutricional.dto.DadosNutricionaisEstoqueDTO;
import br.com.project.tabelaNutricional.model.DadosNutricionais;
import br.com.project.tabelaNutricional.service.DadosNutricionaisService;
import br.com.project.tabelaNutricional.service.EstoqueService;
import lombok.AllArgsConstructor;


/**
 * @version 1.0
 * @author Lucas Novais dos Santos
 */
@CrossOrigin(origins = "http://localhost:8080/cafeteria/inicio")
@RestController
@AllArgsConstructor
@RequestMapping("/**")
public class TabelaNutricionalController {
    

	private static Logger logger = LoggerFactory.getLogger(TabelaNutricionalController.class);

    
    @Autowired
    private DadosNutricionaisService dadosNutricionaisService;

    @Autowired
    private EstoqueService estoqueService;


    public TabelaNutricionalController(){};
        


    /**
     * API path = "/consult/transactions/{idUsuario}" 
     * Utilizada como GET, coleta o idUsuario {@code Integer} enviada como parametro pelo usu??rio
     * Retorna hist??rico de transa????es do idUsuario recebido
     * @param  idUsuario id do usu??rio recebido por parametro, que ser?? usado para consultar seu historico
     * @return o historico do usu??rio  ResponseEntity.ok(transactionHist);
     * @since 11.0
     */
    @CrossOrigin
    @GetMapping(path = "/tabelanutricional/carregar/produto/{codBarras}")
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> findByCodBarras(@PathVariable Integer codBarras){
        DadosNutricionais dadosNutricionais = new DadosNutricionais();
        try{
            dadosNutricionais = dadosNutricionaisService.findByCodBarras(codBarras);

            if(dadosNutricionais != null){
                return ResponseEntity.ok(dadosNutricionais);
            }else{
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(dadosNutricionais);
            }
            
        }catch(SQLDataException dae){
            logger.info("PessoaController.findByUser - N??o foi encontrada tabela nutricional com o codigo de barras: "+codBarras);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(dadosNutricionais);
        }catch(NoSuchElementException nsee){
            logger.info("PessoaController.findByUser - N??o foi encontrada tabela nutricional com o codigo de barras: "+codBarras);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(dadosNutricionais);
        }catch(NullPointerException npe){
            logger.info("PessoaController.findByUser - N??o foi encontrada tabela nutricional com o codigo de barras: "+codBarras);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(dadosNutricionais);
        }catch(Exception e){
            logger.info("PessoaController.findByUser - N??o foi encontrada tabela nutricional com o codigo de barras: "+codBarras);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(dadosNutricionais);
        }
    }


       /**
     * API path = "/consult/transactions/{idUsuario}" 
     * Utilizada como GET, coleta o idUsuario {@code Integer} enviada como parametro pelo usu??rio
     * Retorna hist??rico de transa????es do idUsuario recebido
     * @param  idUsuario id do usu??rio recebido por parametro, que ser?? usado para consultar seu historico
     * @return o historico do usu??rio  ResponseEntity.ok(transactionHist);
     * @since 11.0
     */
    @CrossOrigin
    @GetMapping(path = "/tabelanutricional/carregar/produtoestoque/{codBarras}")
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> findEstoqueTabelaNutricionalByCodBarras(@PathVariable Integer codBarras){
        DadosNutricionaisEstoqueDTO dadosNutricionaisEstoqueDTO = new DadosNutricionaisEstoqueDTO();
        try{
            dadosNutricionaisEstoqueDTO = dadosNutricionaisService.findEstoqueTabelaNutricionalByCodBarras(codBarras);
            dadosNutricionaisEstoqueDTO.setNomeProduto(estoqueService.findByCodBarras(codBarras).getNomeProduto());


            if(dadosNutricionaisEstoqueDTO != null){
                return ResponseEntity.ok(dadosNutricionaisEstoqueDTO);
            }else{
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(dadosNutricionaisEstoqueDTO);
            }
            
        }catch(SQLDataException dae){
            logger.info("PessoaController.findByUser - N??o foi encontrada tabela nutricional com o codigo de barras: "+codBarras);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(dadosNutricionaisEstoqueDTO);
        }catch(NoSuchElementException nsee){
            logger.info("PessoaController.findByUser - N??o foi encontrada tabela nutricional com o codigo de barras: "+codBarras);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(dadosNutricionaisEstoqueDTO);
        }catch(NullPointerException npe){
            logger.info("PessoaController.findByUser - N??o foi encontrada tabela nutricional com o codigo de barras: "+codBarras);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(dadosNutricionaisEstoqueDTO);
        }catch(Exception e){
            logger.info("PessoaController.findByUser - N??o foi encontrada tabela nutricional com o codigo de barras: "+codBarras);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(dadosNutricionaisEstoqueDTO);
        }
    }
    

    /**
     * API path = "/convert/{idUsuario}/{moedaOrigem}/{valorOrigem}/{moedaDestino}
     * Utilizada como GET, coleta o: 
     *        idUsuario {@code Integer}, moedaOrigem {@code String}, valorOrigem {@code Double}, moedaDestino {@code String}
     * Realiza as devidas convers??es atr??ves dos m??todos que chama, e armazena a convers??o no banco de dados
     * @param  idUsuario id do usu??rio recebido por parametro, que ser?? usado para salvar seu historico
     * @param  moedaOrigem moeda de origem recebida por parametro, que ser?? usada para realizar a convers??o
     * @param  valorOrigem valor de origem recebido por parametro, que ser?? usada para realizar a convers??o
     * @param  moedaDestino moeda de destino recebida por parametro, que ser?? usada para realizar a convers??o
     * @return confirma????o da convers??o e o retorno dos dados salvos no banco de dados
     * @since 11.0
     */
    @PostMapping("/tabelanutricional/salvar/produto")
    public ResponseEntity<?> converterTransactionHist(@RequestBody DadosNutricionais dadosNutricionais) {
        try{
            DadosNutricionais dadosNutricionaisAdded = dadosNutricionaisService.save(dadosNutricionais);

            logger.info("PessoaController.converterTransactionHist - Convers??o realizada com sucesso e gerado historico com sucesso!");
            return ResponseEntity.status(HttpStatus.CREATED).body(dadosNutricionais);

        }catch(DataAccessException dae){
            logger.error("PessoaController.save - Falha ao acessar o banco de dados.", dae);
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(dadosNutricionaisService);
        }catch(NullPointerException npe){
            logger.error("PessoaController.save - Retorno nulo do banco de dados. Cadastro n??o realizado!", npe);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(dadosNutricionaisService);
        }catch(Exception e){
            logger.error("PessoaController.save - Falha no cadastro do usu??rio no banco de dados.", e);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(dadosNutricionaisService);
        }
    }

}