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

import br.com.project.tabelaNutricional.model.DadosNutricionais;
import br.com.project.tabelaNutricional.model.Usuario;
import br.com.project.tabelaNutricional.repository.DadosNutricionaisRepository;
import br.com.project.tabelaNutricional.repository.UsuarioRepository;
import lombok.AllArgsConstructor;



/**
 * @version 1.0
 * @author Lucas Novais dos Santos
 */
@Service
@AllArgsConstructor
public class UsuarioService {

    public UsuarioService(){};

    private static Logger logger = LoggerFactory.getLogger(UsuarioService.class);


    @Autowired
    private UsuarioRepository usuarioRepository;

    
    /**
     * Realiza a consulta no banco das transações realizadas
     * @return Uma lista de todas as consultas realizadas {currencyRepository.findAll()}
     * @since 11.0
     */
    public Usuario findUser(String cpf, String senha) throws NullPointerException, SQLDataException, DataAccessException, Exception{
        logger.info("CurrencyService.findAll - Consultando conversões");
        Usuario usuarioRepo = new Usuario();
        for(Usuario usuario : usuarioRepository.findAll()){
            if(usuario.getCpf().toString().equals(cpf.toString()) && usuario.getSenha().toString().equals(senha.toString())){
                usuarioRepo = usuario;
                break;
            }
        }
        return usuarioRepo;
    }

    
    /**
     * Salva o valor de conversão do usuário
     * @param currency Possui os valores que serão salvos no banco de dados
     * @return Valores de conversão salvos {currencyRepository.save(currency)}
     * @since 11.0
     */
    public Usuario save(Usuario usuario){
        logger.info("CurrencyService.save - Salvando valor convertido");
        return usuarioRepository.save(usuario);
    }

}