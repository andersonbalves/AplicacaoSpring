package br.com.baratella.exception;

/**
 * Classe base de exceções para a aplicação
 * @author Anderson
 *
 */
public class AplicacaoSpringException extends Exception {
	
	/** SerialVersionUID	 */
	private static final long serialVersionUID = -8345135427452570433L;

	/**
	 * Método Construtor da Classe 
	 * @param message
	 */
	public AplicacaoSpringException(String mensagem) {
		super(mensagem);
	}
}
