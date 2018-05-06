package br.com.baratella;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
/**
 * 
 * Classe de configuração do Swagger
 * 
 * @author Anderson
 *
 */
@Configuration
@EnableSwagger2
public class ConfiguracaoSwagger {
	
	/**
	 * Utilizado para ler o arquivo de propriedades
	 */
	@Autowired
    private Environment env;

	/**
	 * Método: detalheApi
	 * Propósito: Detalhar a API para o Swagger
	 * @return
	 */
	@Bean
	public Docket detalheApi() {

		Docket docket = new Docket(DocumentationType.SWAGGER_2);

		docket
			.select()
			.apis(RequestHandlerSelectors.basePackage("br.com.baratella"))
			.paths(PathSelectors.any())
			.build()
			.apiInfo(this.informacoesApi().build());

		return docket;
	}
	
	/**
	 * Método: informacoesApi
	 * Propósito: Construir as informações da aplicação para o Swagger
	 * @return
	 */
	private ApiInfoBuilder informacoesApi() {

		ApiInfoBuilder apiInfoBuilder = new ApiInfoBuilder();

		apiInfoBuilder.title(env.getProperty("aplicacao-spring.config.swagger.title"));
		apiInfoBuilder.description(env.getProperty("aplicacao-spring.config.swagger.description"));
		apiInfoBuilder.version(env.getProperty("aplicacao-spring.config.swagger.version"));
		apiInfoBuilder.termsOfServiceUrl(env.getProperty("aplicacao-spring.config.swagger.terms-of-service-url"));
		apiInfoBuilder.license(env.getProperty("aplicacao-spring.config.swagger.licence"));
		apiInfoBuilder.licenseUrl(env.getProperty("aplicacao-spring.config.swagger.licence-url"));
		apiInfoBuilder.contact(this.contato());

		return apiInfoBuilder;

	}

	/**
	 * Método: contato
	 * Propósito: Informações de contato pada o Swagger
	 * @return
	 */
	private Contact contato() {

		return new Contact(env.getProperty("aplicacao-spring.config.swagger.contact.nome"),
				env.getProperty("aplicacao-spring.config.swagger.contact.url"),
				env.getProperty("aplicacao-spring.config.swagger.contact.email"));
	}
	
	
	
}
