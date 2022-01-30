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
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.project.tabelaNutricional.model.Usuario;
import br.com.project.tabelaNutricional.service.UsuarioService;
import lombok.AllArgsConstructor;


/**
 * @version 1.0
 * @author Lucas Novais dos Santos
 */
@CrossOrigin(origins = "http://localhost:8080/cafeteria/inicio")
@RestController
@AllArgsConstructor
@RequestMapping("/**")
public class LoginController {
    

	private static Logger logger = LoggerFactory.getLogger(TabelaNutricionalController.class);

    
    @Autowired
    private UsuarioService usuarioService;

    public LoginController(){};
        

 

    /**
     * API path = "/consult/transactions/{idUsuario}" 
     * Utilizada como GET, coleta o idUsuario {@code Integer} enviada como parametro pelo usuário
     * Retorna histórico de transações do idUsuario recebido
     * @param  idUsuario id do usuário recebido por parametro, que será usado para consultar seu historico
     * @return o historico do usuário  ResponseEntity.ok(transactionHist);
     * @since 11.0
     */
    @GetMapping(path = "/inicio/login/{cpf}/{senha}")
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> findUser(@PathVariable String cpf, @PathVariable String senha){
        Usuario usuario = new Usuario();
        try{
            usuario = usuarioService.findUser(cpf,senha);

            if(!usuario.getNome().toString().equals(null)){
                return ResponseEntity.ok(usuario);
            }else{
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(usuario);
            }
            
        }catch(SQLDataException dae){
            logger.info("PessoaController.findByUser - Não foi encontrada tabela nutricional com o codigo de barras: "+cpf);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(usuario);
        }catch(NoSuchElementException nsee){
            logger.info("PessoaController.findByUser - Não foi encontrada tabela nutricional com o codigo de barras: "+cpf);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(usuario);
        }catch(NullPointerException npe){
            logger.info("PessoaController.findByUser - Não foi encontrada tabela nutricional com o codigo de barras: "+cpf);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(usuario);
        }catch(Exception e){
            logger.info("PessoaController.findByUser - Não foi encontrada tabela nutricional com o codigo de barras: "+cpf);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(usuario);
        }
    }


    
    /**
     * API path = "/convert/{idUsuario}/{moedaOrigem}/{valorOrigem}/{moedaDestino}
     * Utilizada como GET, coleta o: 
     *        idUsuario {@code Integer}, moedaOrigem {@code String}, valorOrigem {@code Double}, moedaDestino {@code String}
     * Realiza as devidas conversões atráves dos métodos que chama, e armazena a conversão no banco de dados
     * @param  idUsuario id do usuário recebido por parametro, que será usado para salvar seu historico
     * @param  moedaOrigem moeda de origem recebida por parametro, que será usada para realizar a conversão
     * @param  valorOrigem valor de origem recebido por parametro, que será usada para realizar a conversão
     * @param  moedaDestino moeda de destino recebida por parametro, que será usada para realizar a conversão
     * @return confirmação da conversão e o retorno dos dados salvos no banco de dados
     * @since 11.0
     */
    @PostMapping("/inicio/login/cadastrar")
    public ResponseEntity<?> converterTransactionHist(@RequestBody Usuario usuarioApi) {
        try{
            Usuario usuarioAdded = usuarioService.save(usuarioApi);

            logger.info("PessoaController.converterTransactionHist - Conversão realizada com sucesso e gerado historico com sucesso!");
            return ResponseEntity.status(HttpStatus.CREATED).body(usuarioAdded);

        }catch(DataAccessException dae){
            logger.error("PessoaController.save - Falha ao acessar o banco de dados.", dae);
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(usuarioApi);
        }catch(NullPointerException npe){
            logger.error("PessoaController.save - Retorno nulo do banco de dados. Cadastro não realizado!", npe);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(usuarioApi);
        }catch(Exception e){
            logger.error("PessoaController.save - Falha no cadastro do usuário no banco de dados.", e);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(usuarioApi);
        }
    }


}
