/*
 * Class: CorsConfiguration.java
 * Created: 06/12/2021
 * Created by: Lucas da Silva Novais
 * Rights Reserved: PlusFriends
 */  

package br.com.project.tabelaNutricional.cors;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


/**
 * @version 1.0
 * @author Lucas da Silva Novais
 */
@Configuration
public class CorsConfiguration{


    
    /**
     * Utilizada para dar as permissões para acessar as APIs
     * @param  registry dados de permissão da aplicação
     * @since 11.0
     */
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer(){
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                    .allowedOrigins("http://localhost:8080")
                    .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS", "HEAD", "TRACE", "CONNECT")
                    .allowedHeaders("*");
            }
        }; 
    }
}