/*
 * 
 */
package br.com.baratella.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

	/**
	 * Repositório JPA
	 */
	private PlantaRepository repository;
	
	/**
	 * Logger da aplicação
	 */
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

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
		logger.info("Buscando todas as plantas no banco de dados");
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
		logger.info("Buscando a planta {} no banco de dados", nome);
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
		logger.info("Excluindo a planta id:{} do banco de dados", Long.toString(id));
		repository.deleteById(id);
	}

	/**
	 * Método: adicionar
	 * Propósito: Serviço para adicionar uma planta.
	 *
	 * @param planta  planta
	 * @return  planta
	 * @see IPlantaService
	 */
	@Override
	public void adicionar(Planta planta) {
		logger.info("Adicionando uma planta ao banco de dados");
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
		boolean temVarias = plantas.length >= 2;
		logger.trace((temVarias ?
				"Adicionando " +  plantas.length + " plantas ao banco de dados" :
				"Adicionando uma planta ao banco de dados"));
		//Executa o serviço de adicionar plantas para cada planta
		for (Planta planta : plantas) {
			adicionar(planta);
		}
	}

}
