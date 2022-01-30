/*
 * Class: DadosNutricionaisRepository.java
 * Created: 23/01/2022
 * Rights Reserved: Lucas da Silva Novais
 */  

package br.com.project.tabelaNutricional.repository;


import br.com.project.tabelaNutricional.model.DadosNutricionais;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


/**
 * @version 1.0
 * @author Lucas Novais dos Santos
 */
@Repository
@EnableJpaRepositories
public interface DadosNutricionaisRepository extends JpaRepository<DadosNutricionais, Long> {
    
    
}