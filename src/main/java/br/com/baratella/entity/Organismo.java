package br.com.baratella.entity;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Classe abstrata par o tipo Organismo
 * 
 * @author Anderson
 *
 */
public abstract class Organismo {

	/**
	 * Logger da aplicação
	 */
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	/**
	 * Método Construtor da Classe 
	 */
	public Organismo() {
		super();
		logarCriacao();
	}
	
	/**
	 * Método: logarCadastro
	 * Propósito: Método Gancho (Hook Method) deve ser implementado e logar a criação do objeto
	 */
	protected abstract void logarCriacao();

	/**
	 * Método: getLogger
	 * Propósito: Retorna o logger da aplicação
	 * @return
	 */
	protected Logger getLogger() {
		return logger;
	}
	
	
}
