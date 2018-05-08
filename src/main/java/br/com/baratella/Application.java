/*
 * 
 */
package br.com.baratella;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import br.com.baratella.util.InformacoesAplicacaoSingleton;

/**
 * The Class Application.
 */
@SpringBootApplication
@EnableJpaRepositories
public class Application {
	

	/**
	 * Método main para execução do Spring Boot.
	 *
	 * @param args
	 */
	public static void main(String[] args) {
		Logger logger = LoggerFactory.getLogger(Application.class);
		logger.info("A aplicação foi iniciada: " + InformacoesAplicacaoSingleton.INSTANCE.getDataInicializacao());
		SpringApplication.run(Application.class, args);
	}
}
