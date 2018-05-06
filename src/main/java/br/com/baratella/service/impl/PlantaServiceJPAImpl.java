/*
 * 
 */
package br.com.baratella.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.baratella.entity.Planta;
import br.com.baratella.jpa.PlantaRepository;
import br.com.baratella.service.IPlantaService;

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
	 * Método: listarPlantas Propósito: Serviço de listar plantas
	 * 
	 * @param planta
	 * @return
	 * @see IPlantaService
	 */
	@Override
	public List<Planta> listarPlanta() {
		return repository.findAll();
	}

	/**
	 * Método: listarPlantas Propósito: Serviço para buscar uma planta.
	 *
	 * @param nome  nome
	 * @return  planta
	 * @see IPlantaService
	 */
	@Override
	public Planta buscarPlanta(String nome) {
		return repository.findByNome(nome);
	}

	/**
	 * Método: excluirPlanta Propósito: Serviço para excluir uma planta.
	 *
	 * @param id  id
	 * @return  planta
	 * @see IPlantaService
	 */
	@Override
	public void excluirPlanta(Long id) {
		repository.deleteById(id);
	}

	/**
	 * Método: adicionarPlanta Propósito: Serviço para adicionar uma planta.
	 *
	 * @param planta  planta
	 * @return  planta
	 * @see IPlantaService
	 */
	@Override
	public void adicionarPlanta(Planta planta) {
		if (!repository.existByNome(planta.getNome())) {
			repository.save(planta);
		}
	}

}
