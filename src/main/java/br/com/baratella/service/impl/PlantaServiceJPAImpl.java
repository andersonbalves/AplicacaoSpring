/*
 * 
 */
package br.com.baratella.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.baratella.entity.Planta;
import br.com.baratella.jpa.PlantaRepository;
import br.com.baratella.service.IPlantaService;
import br.com.baratella.service.exception.AplicacaoServiceException;

/**
 * Implementação para os serviços de Planta
 * 
 * @author Anderson
 *
 */
@Service
public class PlantaServiceJPAImpl implements IPlantaService {

	private PlantaRepository repository;

	/**
	 * Método Construtor da Classe
	 */
	public PlantaServiceJPAImpl(PlantaRepository repository) {
		this.repository = repository;
	}

	/**
	 * Método: listar
	 * Propósito: Serviço de listar plantas
	 * 
	 * @param planta
	 * @return
	 * @see IPlantaService
	 */
	@Override
	public List<Planta> listar() {
		return repository.findAll();
	}

	/**
	 * Método: listar
	 * Propósito: Serviço para buscar uma planta.
	 *
	 * @param nome  nome
	 * @return  planta
	 * @see IPlantaService
	 */
	@Override
	public Planta buscar(String nome) {
		return repository.findByNome(nome);
	}

	/**
	 * Método: excluir
	 * Propósito: Serviço para excluir uma planta.
	 *
	 * @param id  id
	 * @return  planta
	 * @see IPlantaService
	 */
	@Override
	public void excluir(Long id) {
		repository.deleteById(id);
	}

	/**
	 * Método: adicionar Propósito: Serviço para adicionar uma planta.
	 *
	 * @param planta  planta
	 * @return  planta
	 * @see IPlantaService
	 */
	@Override
	public void adicionar(Planta planta) {
		if (!repository.existByNome(planta.getNome())) {
			repository.save(planta);
		}
	}

	/**
	 * Método: adicionar
	 * Propósito: Serviço para adicionar plantas.
	 *
	 * @param planta  planta
	 * @return  planta
	 * @see IPlantaService
	 */
	@Override
	public void adicionar(Planta... plantas) throws AplicacaoServiceException {
		for (Planta planta : plantas) {
			adicionar(planta);
		}
	}

}
