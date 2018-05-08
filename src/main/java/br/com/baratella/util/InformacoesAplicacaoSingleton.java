package br.com.baratella.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Anderson
 *
 */
public enum InformacoesAplicacaoSingleton {
	INSTANCE;
	
	private Date horaInicializacao = new Date();

	/**
	 * Método: getDataInicializacao
	 * Propósito: Método get para o atribto dataInicializacao
	 * @return
	 */
	public String getDataInicializacao() {
		return new SimpleDateFormat("dd/MM/yyyy - HH:mm:ss.S").format(horaInicializacao);
	}

}
