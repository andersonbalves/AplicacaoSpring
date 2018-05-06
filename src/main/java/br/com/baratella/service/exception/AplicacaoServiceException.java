package br.com.baratella.service.exception;

import br.com.baratella.exception.AplicacaoSpringException;

/**
 * Exceção para os serviços da aplicação
 * @author Anderson
 *
 */
public class AplicacaoServiceException extends AplicacaoSpringException {

	/** SerialVersionUID  */
	private static final long serialVersionUID = -1680553035850214621L;

	/**
	 * Método Construtor da Classe 
	 * @param message
	 */
	public AplicacaoServiceException(String mensagem) {
		super(mensagem);
	}

}
