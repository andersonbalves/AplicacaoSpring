package br.com.baratella.util;

import org.springframework.util.ObjectUtils;

/**
 * Classe Utilitaria para a aplicação
 * 
 * @author Anderson
 *
 */
public class AplicacaoUtil {

	/**
	 * Método: validaCamposObrigatorios
	 * Propósito: Valida se os campos enviados estão preenchidos
	 * @param objects
	 * @return
	 */
	public static boolean validaCamposObrigatorios(Object... objects) {
		//Itera sobre uma coleção de objetos verificando se todos os itens estão valorados
		for (Object object : objects) {
			if (ObjectUtils.isEmpty(object)) {
				return false;
			}
		}
		return true;
	}
}
