package br.com.baratella.service.factory;

import br.com.baratella.service.IPessoaService;
import br.com.baratella.service.impl.PessoaServiceMockImpl;

/**
 * Fábrica para o serviço
 * 
 * @author Anderson
 *
 */
public class PessoaServiceFactory {
	
	
	/**
	 * 
	 * Método Construtor da Classe
	 */
	public PessoaServiceFactory() {
	}
	
	/**
	 * Método: getInstance
	 * Propósito: Método da fábrica para retornar uma instância do serviço
	 * @param type
	 * @return
	 */
	public static IPessoaService getInstance(String type) {
		if (type == null || type.equals("MOCK")) {
			return  new PessoaServiceMockImpl();
		} else {
			return  new PessoaServiceMockImpl();
		}
	}
}
