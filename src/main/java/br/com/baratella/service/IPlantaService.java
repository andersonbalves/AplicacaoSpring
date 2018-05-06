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
	 * Método: listar
	 * Propósito: Serviço de listar
	 * 
	 * @return Lista de pessoas
	 */
	List<?> listar() throws AplicacaoServiceException;

	/**
	 * Método: buscar
	 * Propósito: Serviço para buscar
	 * 
	 * @param nome
	 * @return pessoa
	 */
	Planta buscar(String nome) throws AplicacaoServiceException;
	
	/**
	 * 
	 * Método: excluir
	 * Propósito: Excluir 
	 * @param nome
	 */
	void excluir(Long id) throws AplicacaoServiceException;
	
	/**
	 * Método: adiciona
	 * Propósito: Adicionar
	 * @param pessoa
	 * @return
	 */
	void adicionar(Planta planta) throws AplicacaoServiceException;
	
	/**
	 * Método: adiciona
	 * Propósito: Adicionar
	 * @param pessoa
	 * @return
	 */
	void adicionar(Planta... plantas) throws AplicacaoServiceException;
}
