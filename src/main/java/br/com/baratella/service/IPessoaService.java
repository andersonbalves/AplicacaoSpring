package br.com.baratella.service;

import java.util.List;

import br.com.baratella.model.PessoaVO;

/**
 * Interface de serviços para o tipo Pessoa
 * 
 * @author Anderson
 *
 */
public interface IPessoaService {

	/**
	 * Método: listarPessoas Propósito: Serviço de listar pessoas
	 * 
	 * @return Lista de pessoas
	 */
	List<PessoaVO> listarPessoas();

	/**
	 * Método: buscarPessoa Propósito: Serviço para buscar uma pessoa
	 * 
	 * @param nome
	 * @return pessoa
	 */
	PessoaVO buscarPessoa(String nome);
}
