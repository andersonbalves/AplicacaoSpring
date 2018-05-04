package br.com.baratella.service.factory;

import br.com.baratella.service.IPessoaService;
import br.com.baratella.service.impl.PessoaServiceMockImpl;

/**
 * Fábrica para o serviço Pessoa
 * 
 * @author Anderson
 *
 */
public class PessoaServiceFactory {
	
	/**
	 * Chave para a implementação mock do serviço de pessoa
	 */
	public static final String MOCK_INSTANCE = "MOCK";
	
	/**
	 * Método: getInstance
	 * Propósito: Método da fábrica para retorna a instância default do serviço
	 * @param type
	 * @return
	 */
	public static IPessoaService getPessoaService() {
		return getPessoaService(null);
	}

	/**
	 * Método: getInstance
	 * Propósito: Método da fábrica para retornar uma instância do serviço
	 * @param type
	 * @return
	 */
	public static IPessoaService getPessoaService(String type) {
		if (type == null || type.equals(MOCK_INSTANCE)) {
			return  PessoaServiceMockImpl.getInstance();
		} else {
			//TODO: Implementar recuperação de defaul por arquivo de propriedade
			return  PessoaServiceMockImpl.getInstance();
		}
	}
}
