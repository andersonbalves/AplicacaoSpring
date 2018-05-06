/*
 * 
 */
package br.com.baratella;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

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
		SpringApplication.run(Application.class, args);
	}
}
