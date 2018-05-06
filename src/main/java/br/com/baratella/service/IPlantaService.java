package br.com.baratella.service;

import java.util.List;

import br.com.baratella.entity.Planta;
import br.com.baratella.service.exception.AplicacaoServiceException;

/**
 * Interface de serviços para o tipo Pessoa
 * 
 * @author Anderson
 *
 */
public interface IPlantaService {

	/**
	 * Método: listarPessoas Propósito: Serviço de listar pessoas
	 * 
	 * @return Lista de pessoas
	 */
	List<Planta> listarPlanta() throws AplicacaoServiceException;

	/**
	 * Método: buscarPessoa Propósito: Serviço para buscar uma pessoa
	 * 
	 * @param nome
	 * @return pessoa
	 */
	Planta buscarPlanta(String nome) throws AplicacaoServiceException;
	
	/**
	 * 
	 * Método: excluirPessoa
	 * Propósito: Excluir uma pessoa
	 * @param nome
	 */
	void excluirPlanta(Long id) throws AplicacaoServiceException;
	
	/**
	 * Método: adicionarPEssoa
	 * Propósito: Adicionar uma pessoa
	 * @param pessoa
	 * @return
	 */
	void adicionarPlanta(Planta planta) throws AplicacaoServiceException;
}
