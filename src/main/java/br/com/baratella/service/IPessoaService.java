package br.com.baratella.service;

import java.util.List;

import br.com.baratella.exceptions.AplicacaoServiceException;
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
	List<PessoaVO> listarPessoas() throws AplicacaoServiceException;

	/**
	 * Método: buscarPessoa Propósito: Serviço para buscar uma pessoa
	 * 
	 * @param nome
	 * @return pessoa
	 */
	PessoaVO buscarPessoa(String cpf) throws AplicacaoServiceException;
	
	/**
	 * 
	 * Método: excluirPessoa
	 * Propósito: Excluir uma pessoa
	 * @param nome
	 */
	void excluirPessoa(String cpf) throws AplicacaoServiceException;
	
	/**
	 * Método: adicionarPEssoa
	 * Propósito: Adicionar uma pessoa
	 * @param pessoa
	 * @return
	 */
	PessoaVO adicionarPessoa(PessoaVO pessoa) throws AplicacaoServiceException;
}
