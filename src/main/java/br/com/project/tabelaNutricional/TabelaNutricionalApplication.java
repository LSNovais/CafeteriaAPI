/*
 * Class: TabelaNutricionalApplication.java
 * Created: 28/10/2021
 * Rights Reserved: Jaya
 */  

package br.com.project.tabelaNutricional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @version 1.0
 * @author Lucas Novais dos Santos
 */
@SpringBootApplication
public class TabelaNutricionalApplication {

	private static Logger logger = LoggerFactory.getLogger(TabelaNutricionalApplication.class);

	public static void main(String[] args) {
		logger.info("Iniciando a API de tabela nutricional");
		SpringApplication.run(TabelaNutricionalApplication.class, args);
		logger.info("API de tabela nutricional iniciada e pronta para enviar e receber requisições");

	}
	

}
