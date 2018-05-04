package br.com.baratella.controller;

import java.util.List;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.baratella.exceptions.AplicacaoServiceException;
import br.com.baratella.model.PessoaVO;
import br.com.baratella.service.IPessoaService;
import br.com.baratella.service.factory.PessoaServiceFactory;

/**
 * 
 * Classe controladora REST para o tipo pessoa
 * 
 * @author Anderson
 *
 */
@RestController
public class PessoaController {

	/**
	 * Serviço para o tipo pessoa
	 */
	IPessoaService pessoaService;
	
	/**
	 * Logger da aplicação
	 */
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	/**
	 * 
	 * Método Construtor da Classe
	 */
	public PessoaController() {
		super();
	}
	
	@PostConstruct
	private void inicializar() {
		pessoaService = PessoaServiceFactory.getPessoaService();
	}

	/**
	 * Método: listarPessoas Propósito: Conrolador REST para o verbo GET, Retorna as
	 * pessoas cadastradas
	 * 
	 * @return
	 */
	@RequestMapping(value = "/pessoas", method = RequestMethod.GET)
	public ResponseEntity<List<PessoaVO>> listarPessoas() {
		logger.info("Listando pessoas");
		// Acessa o serviço de listar pessoas
		List<PessoaVO> listaPessoas;
		try {
			listaPessoas = pessoaService.listarPessoas();
		} catch (AplicacaoServiceException ase) {
			logger.error("Erro {} ao listar pessoas", ase.getMessage(), ase );
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		// Cria o objeto de response
		ResponseEntity<List<PessoaVO>> response = new ResponseEntity<List<PessoaVO>>(listaPessoas, HttpStatus.OK);
		return response;
	}

	/**
	 * Método: listarPessoas
	 * Propósito: Conrolador REST para o verbo GET, Retorna
	 * uma pessoa cadastrada
	 * 
	 * @return
	 */
	@RequestMapping(value = "/pessoa/{cpf}", method = RequestMethod.GET)
	public ResponseEntity<PessoaVO> buscarPessoa(@PathVariable("cpf") String cpf) {
		PessoaVO pessoa = null;
		logger.info("Buscando a pessoa com cpf {}", cpf);
		try {
			pessoa = pessoaService.buscarPessoa(cpf);
		} catch (AplicacaoServiceException ase) {
			logger.error("Erro {} ao buscar uma pessoa", ase.getMessage(), ase );
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		ResponseEntity<PessoaVO> response = new ResponseEntity<PessoaVO>(pessoa, HttpStatus.OK);
		return response;
	}

	/**
	 * Método: excluirPessoa
	 * Propósito: Controlador REST para o verbo DELETE, deleta uma pessoa
	 * @param cpf
	 * @return
	 */
	@RequestMapping(value = "/pessoa/{cpf}", method = RequestMethod.DELETE)
	public ResponseEntity<?> excluirPessoa(@PathVariable("cpf") String cpf) {
		logger.info("Deletando a pessoa com cpf {}", cpf);
		try {
			pessoaService.excluirPessoa(cpf);
		} catch (AplicacaoServiceException ase) {
			logger.error("Erro {} ao excluir uma pessoa", ase.getMessage(), ase);
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	/**
	 * Método: adicionarPessoa
	 * Propósito: Controlador REST para adiciona uma pessoa
	 * @param pessoa
	 * @return
	 */
	@RequestMapping(value = "/pessoa", method = RequestMethod.POST)
	public ResponseEntity<PessoaVO> adicionarPessoa(@RequestBody PessoaVO pessoa) {
		logger.info("Adicionando a pessoa {}", pessoa.getNome());
		try {
			pessoaService.adicionarPessoa(pessoa);
		} catch (AplicacaoServiceException ase) {
			logger.error("Erro {} ao adicionar uma pessoa", ase.getMessage(), ase );
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
}
