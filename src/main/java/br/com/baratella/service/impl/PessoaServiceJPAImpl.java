package br.com.baratella.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.baratella.entity.Pessoa;
import br.com.baratella.jpa.PessoaRepository;
import br.com.baratella.service.IPessoaService;

/**
 * Implementação Mock para os serviços de Pessoa
 * 
 * @author Anderson
 *
 */
@Service
public class PessoaServiceJPAImpl implements IPessoaService {

	/** InstÂncia única do serviço */
	private static PessoaServiceJPAImpl pessoaServiceJPA;

	@Autowired
	private PessoaRepository repository;

	/**
	 * Método Construtor da Classe (Private para implementação de Singleton Pattern)
	 */
	public PessoaServiceJPAImpl(PessoaRepository repository) {
		this.repository = repository;
	}

	/**
	 * Método: getInstance Propósito: Retorna uma instância única do serviço de
	 * Pessoa
	 * 
	 * @return
	 */
	public static synchronized IPessoaService getInstance() {
		return null;
	}

	/**
	 * Método: listarPessoas Propósito: Serviço de listar pessoas (Mock)
	 * 
	 * @param pessoa
	 * @return
	 * @see IPessoaService
	 */
	@Override
	public List<Pessoa> listarPessoas() {
		return repository.findAll();
	}

	/**
	 * Método: listarPessoas Propósito: Serviço para buscar uma pessoa (Mock)
	 * 
	 * @param pessoa
	 * @return
	 * @see IPessoaService
	 */
	@Override
	public Pessoa buscarPessoa(String cpf) {
		return repository.getOne(cpf);
	}

	@Override
	public void excluirPessoa(String cpf) {
		repository.deleteById(cpf);
	}

	@Override
	public void adicionarPessoa(Pessoa pessoa) {
		if (!repository.existsById(pessoa.getCpf())) {
			repository.save(pessoa);
		}
	}

}
