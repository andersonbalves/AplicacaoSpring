package br.com.baratella.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.baratella.model.PessoaVO;
import br.com.baratella.service.IPessoaService;
import br.com.baratella.service.factory.PessoaServiceFactory;

@RestController
public class PessoaController {

	IPessoaService pessoaService;

	/**
	 * 
	 * Método Construtor da Classe
	 */
	public PessoaController() {
		super();
		pessoaService = PessoaServiceFactory.getInstance(null);
	}

	/**
	 * Método: listarPessoas
	 * Propósito: Conrolador REST para o verbo GET, Retorna as
	 * pessoas cadastradas
	 * 
	 * @return
	 */
	@RequestMapping(value = "/pessoas", method = RequestMethod.GET)
	public ResponseEntity<List<PessoaVO>> listarPessoas() {
		System.out.println("Controller Listar");
		//Acessa o serviço de listar pessoas
		List<PessoaVO> listaPessoas = pessoaService.listarPessoas();
		//Cria o objeto de response
		ResponseEntity<List<PessoaVO>> response = new ResponseEntity<List<PessoaVO>>(listaPessoas, HttpStatus.OK);
		return response;
	}
	
	/**
	 * Método: listarPessoas Propósito: Conrolador REST para o verbo GET, Retorna uma
	 * pessoa cadastrada
	 * 
	 * @return
	 */
	@RequestMapping(value = "/pessoa/{nome}", method = RequestMethod.GET)
	public ResponseEntity<PessoaVO> buscarPessoa(@PathVariable("nome") String nome) {
		PessoaVO pessoa = pessoaService.buscarPessoa(nome);
		ResponseEntity<PessoaVO> response = new ResponseEntity<PessoaVO>(pessoa, HttpStatus.OK);
		return response;
	}
}
