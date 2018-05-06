package br.com.baratella.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.baratella.entity.Planta;
import br.com.baratella.jpa.PessoaRepository;
import br.com.baratella.service.IPlantaService;

/**
 * Implementação Mock para os serviços de Pessoa
 * 
 * @author Anderson
 *
 */
@Service
public class PlantaServiceJPAImpl implements IPlantaService {

	/** InstÂncia única do serviço */
	private static PlantaServiceJPAImpl pessoaServiceJPA;

	@Autowired
	private PessoaRepository repository;

	/**
	 * Método Construtor da Classe (Private para implementação de Singleton Pattern)
	 */
	public PlantaServiceJPAImpl(PessoaRepository repository) {
		this.repository = repository;
	}

	/**
	 * Método: getInstance Propósito: Retorna uma instância única do serviço de
	 * Pessoa
	 * 
	 * @return
	 */
	public static synchronized IPlantaService getInstance() {
		return null;
	}

	/**
	 * Método: listarPessoas Propósito: Serviço de listar pessoas (Mock)
	 * 
	 * @param pessoa
	 * @return
	 * @see IPlantaService
	 */
	@Override
	public List<Planta> listarPlanta() {
		return repository.findAll();
	}

	/**
	 * Método: listarPessoas Propósito: Serviço para buscar uma pessoa (Mock)
	 * 
	 * @param pessoa
	 * @return
	 * @see IPlantaService
	 */
	@Override
	public Planta buscarPlanta(String nome) {
		return repository.findByNome(nome);
	}

	@Override
	public void excluirPlanta(Long id) {
		repository.deleteById(id);
	}

	@Override
	public void adicionarPlanta(Planta planta) {
		if (!repository.existByNome(planta.getNome())) {
			repository.save(planta);
		}
	}

}
