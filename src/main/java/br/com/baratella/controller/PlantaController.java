package br.com.baratella.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.baratella.entity.Planta;
import br.com.baratella.exception.AplicacaoSpringException;
import br.com.baratella.service.IPlantaService;
import br.com.baratella.service.exception.AplicacaoServiceException;

/**
 * 
 * Classe controladora REST para o tipo planta
 * 
 * @author Anderson
 *
 */
@RestController
public class PlantaController {

	/**
	 * Serviço para o tipo planta
	 */
	IPlantaService plantaService;
	
	/**
	 * Logger da aplicação
	 */
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	/**
	 * 
	 * Método Construtor da Classe
	 */
	public PlantaController(IPlantaService plantaService) {
		super();
		this.plantaService = plantaService;
	}
	
	/**
	 * Método: listarPlantas Propósito: Conrolador REST para o verbo GET, Retorna as
	 * plantas cadastradas
	 * 
	 * @return
	 */
	@RequestMapping(value = "/plantas", method = RequestMethod.GET)
	public ResponseEntity listarPlantas() {
		logger.info("Listando plantas");
		// Acessa o serviço de listar plantas
		List<Planta> listaPlantas;
		try {
			listaPlantas = (List<Planta>) plantaService.listar();
		} catch (AplicacaoServiceException ase) {
			logger.error("Erro {} ao listar plantas", ase.getMessage(), ase );
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		// Cria o objeto de response
		ResponseEntity<List<Planta>> response = new ResponseEntity<List<Planta>>(listaPlantas, HttpStatus.OK);
		return response;
	}

	/**
	 * Método: listarPlantas
	 * Propósito: Conrolador REST para o verbo GET, Retorna
	 * uma planta cadastrada
	 * 
	 * @return
	 */
	@RequestMapping(value = "/planta/{nome}", method = RequestMethod.GET)
	public ResponseEntity buscarPlanta(@PathVariable("nome") String nome) {
		Planta planta = null;
		logger.info("Buscando a planta {}", nome);
		try {
			planta = plantaService.buscar(nome);
		} catch (AplicacaoSpringException ase) {
			logger.error("Erro {} ao buscar uma planta", ase.getMessage(), ase );
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		ResponseEntity<Planta> response = new ResponseEntity<Planta>(planta, HttpStatus.OK);
		return response;
	}

	/**
	 * Método: excluirPlanta
	 * Propósito: Controlador REST para o verbo DELETE, deleta uma planta
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/planta/{id}", method = RequestMethod.DELETE)
	public ResponseEntity excluirPlanta(@PathVariable("id") Long id) {
		logger.info("Deletando a planta com id {}", id);
		try {
			if (id == null ) {
				throw new AplicacaoSpringException("O ID não pode ser null");
			}
			plantaService.excluir(id);
		} catch (AplicacaoSpringException ase) {
			logger.error("Erro {} ao excluir uma planta", ase.getMessage(), ase);
			return new ResponseEntity<>(ase.getMessage(), HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	/**
	 * Método: adicionarPlanta
	 * Propósito: Controlador REST para adiciona uma planta
	 * @param planta
	 * @return
	 */
	@RequestMapping(value = "/planta", method = RequestMethod.POST)
	public ResponseEntity adicionarPlanta(@RequestBody Planta planta) {
		logger.info("Adicionando a planta {}", planta.getNome());
		try {
			
			if (planta.getDataCatalogo() == null ) {
				throw new AplicacaoSpringException("A data de catálogo não pode ser null");
			}
			if (planta.getNome() == null ) {
				throw new AplicacaoSpringException("O Nome não pode ser null");
			}
			if (planta.getNomeCientifico() == null ) {
				throw new AplicacaoSpringException("O Nome Científico não pode ser null");
			}
			
			plantaService.adicionar(planta);
		} catch (AplicacaoSpringException ase) {
			logger.error("Erro {} ao adicionar uma planta", ase.getMessage(), ase );
			return new ResponseEntity<>(ase.getMessage(), HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	/**
	 * Método: adicionarPlanta
	 * Propósito: Controlador REST para adiciona uma planta
	 * @param planta
	 * @return
	 */
	@RequestMapping(value = "/plantas", method = RequestMethod.POST)
	public ResponseEntity adicionarPlantas(@RequestBody Planta... plantas) {
		boolean valoresValidos = true;
		for (Planta planta : plantas) {
			logger.info("Adicionando a plantas {}", planta.getNome());

			if (planta.getDataCatalogo() == null) {
				valoresValidos = false;
			}
			if (planta.getNome() == null) {
				valoresValidos = false;
			}
			if (planta.getNomeCientifico() == null) {
				valoresValidos = false;
			}

		}
		try {
			if (!valoresValidos) {
				throw new AplicacaoSpringException("Valores inválidos");
			}
			plantaService.adicionar(plantas);
		} catch (AplicacaoSpringException ase) {
			logger.error("Erro {} ao adicionar plantas", ase.getMessage(), ase);
			return new ResponseEntity<>(ase.getMessage(), HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
}
