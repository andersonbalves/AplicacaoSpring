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
import br.com.baratella.util.AplicacaoUtil;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * 
 * Classe controladora REST para o tipo planta
 * 
 * @author Anderson
 *
 */
@RestController
public class PlantaController {

	/** Variável ID para mapeamento de path */
	private static final String PATH_VARIAVEL_ID = "/{id}";

	/** Variável nome para mapeamento de path */
	private static final String PATH_VARIAVEL_NOME = "/{nome}";

	/** mapeamento de path plantas */
	private static final String PATH_PLANTAS = "/plantas";

	/** mapeamento de path planta */
	private static final String PATH_PLANTA = "/planta";

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
	 * Método: listarPlantas
	 * Propósito: Conrolador REST para o verbo GET, Retorna as
	 * plantas cadastradas
	 * 
	 * @return
	 */
	@ApiOperation(
			value="Listar as plantas salvas", 
			response=Planta.class, 
			notes="Esta operação retorna as plantas salvas no sistema.")
	@ApiResponses(value= {
			@ApiResponse(
					code=200, 
					message="Retorna uma lista de plantas salvas",
					response=Planta.class
					),
			@ApiResponse(
					code=404, 
					message="Caso não encontre nenhuma planta, retorna ERRO 404 e uma mensagem de erro",
					response=String.class
					)
 
	})
	@RequestMapping(value = PATH_PLANTAS, method = RequestMethod.GET)
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
	@ApiOperation(
			value="Busca uma planta no sistema", 
			response=Planta.class, 
			notes="Esta operação retorna uma panta salva no sistema, filtrando pelo nome.")
	@ApiResponses(value= {
			@ApiResponse(
					code=200, 
					message="Retorna a planta buscada pelo seu nome",
					response=Planta[].class
					),
			@ApiResponse(
					code=404, 
					message="Caso não encontre a planta, retorna ERRO 404 e uma mensagem de erro",
					response=String.class
					)
 
	})
	@RequestMapping(value = PATH_PLANTA + PATH_VARIAVEL_NOME, method = RequestMethod.GET)
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
	@ApiOperation(
			value="Exclui uma planta no sistema pelo seu id", 
			response=Planta.class, 
			notes="Esta operação exclui uma panta salva no sistema através do id informado.")
	@ApiResponses(value= {
			@ApiResponse(
					code=204, 
					message="Exclui a planta através do id informado"
					),
			@ApiResponse(
					code=404, 
					message="Em caso de falha, retorna ERRO 404 e uma mensagem de erro",
					response=String.class
					)
 
	})
	@RequestMapping(value = PATH_PLANTA + PATH_VARIAVEL_ID, method = RequestMethod.DELETE)
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
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	/**
	 * Método: adicionarPlanta
	 * Propósito: Controlador REST para adiciona uma planta
	 * @param planta
	 * @return
	 */
	@ApiOperation(
			value="Adiciona uma planta no sistema", 
			response=Planta.class, 
			notes="Esta operação inclui uma planta no sistema à partir dos dados informados.")
	@ApiResponses(value= {
			@ApiResponse(
					code=201, 
					message="Insere a planta através dos dados informados"
					),
			@ApiResponse(
					code=400, 
					message="Em caso de falha, retorna ERRO 400 e uma mensagem de erro",
					response=String.class
					)
 
	})
	@RequestMapping(value = PATH_PLANTA, method = RequestMethod.POST)
	public ResponseEntity adicionarPlanta(@RequestBody Planta planta) {
		logger.info("Adicionando a planta {}", planta.getNome());
		try {
			//VALIDA OS CAMPOS ENVIADOS PARA A INSERCAO
			boolean valoresValidos = AplicacaoUtil.validaCamposObrigatorios(planta.getDataCatalogo(),
					planta.getNome(), planta.getNomeCientifico());

			if (valoresValidos) {
				plantaService.adicionar(planta);
			} else {
				throw new AplicacaoSpringException("A planta " + planta.getNome() + " possui valores inválidos");
			}
		} catch (AplicacaoSpringException ase) {
			logger.error("Erro {} ao adicionar uma planta", ase.getMessage(), ase );
			return new ResponseEntity<>(ase.getMessage(), HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	/**
	 * Método: adicionarPlanta
	 * Propósito: Controlador REST para adiciona uma planta
	 * @param planta
	 * @return
	 */
	@ApiOperation(
			value="Adiciona uma lista de plantas no sistema", 
			response=Planta[].class, 
			notes="Esta operação inclui uma lista de plantas no sistema à partir dos dados informados.")
	@ApiResponses(value= {
			@ApiResponse(
					code=201, 
					message="Insere uma lista de plantas através dos dados informados"
					),
			@ApiResponse(
					code=400, 
					message="Em caso de falha, retorna ERRO 400 e uma mensagem de erro",
					response=String.class
					)
 
	})
	@RequestMapping(value = PATH_PLANTAS, method = RequestMethod.POST)
	public ResponseEntity adicionarPlantas(@RequestBody Planta... plantas) {
		try {
			for (Planta planta : plantas) {
				logger.info("Adicionando a planta {}", planta.getNome());
				//VALIDA OS CAMPOS ENVIADOS PARA A INSERCAO
				boolean valoresValidos = AplicacaoUtil.validaCamposObrigatorios(planta.getDataCatalogo(),
						planta.getNome(), planta.getNomeCientifico());

				if (!valoresValidos) {
					throw new AplicacaoSpringException("A planta " + planta.getNome() + " possui valores inválidos");		
				}
			}
			
			plantaService.adicionar(plantas);

		} catch (AplicacaoSpringException ase) {
			logger.error("Erro {} ao adicionar plantas ", ase.getMessage(), ase);
			return new ResponseEntity<>(ase.getMessage(), HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
}
