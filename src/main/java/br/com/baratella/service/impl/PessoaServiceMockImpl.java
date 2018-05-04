package br.com.baratella.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.com.baratella.model.PessoaVO;
import br.com.baratella.service.IPessoaService;

/**
 * Implementação Mock para os serviços de Pessoa
 * 
 * @author Anderson
 *
 */
public class PessoaServiceMockImpl implements IPessoaService {

	private static PessoaServiceMockImpl pessoaServiceMock;

	/**
	 * Método Construtor da Classe (Private para implementação de Singleton Pattern)
	 */
	private PessoaServiceMockImpl() {

	}

	/**
	 * Método: getInstance
	 * Propósito: Retorna uma instância única do serviço de Pessoa
	 * @return
	 */
	public static synchronized IPessoaService getInstance() {
		return (pessoaServiceMock == null ? pessoaServiceMock = new PessoaServiceMockImpl() : pessoaServiceMock);
	}

	/**
	 * Método: listarPessoas Propósito: Serviço de listar pessoas (Mock)
	 * 
	 * @param pessoa
	 * @return
	 * @see IPessoaService
	 */
	@Override
	public List<PessoaVO> listarPessoas() {
		List<PessoaVO> listaPessoas = new ArrayList<>();

		PessoaVO newPessoa = new PessoaVO("Anderson Baratella Alves", "35741144861", new Date(1988, 9, 27));
		listaPessoas.add(newPessoa);
		newPessoa = new PessoaVO("Jair Dias Alves", "11111111111", new Date(1960, 1, 10));
		listaPessoas.add(newPessoa);

		return listaPessoas;
	}

	/**
	 * Método: listarPessoas Propósito: Serviço para buscar uma pessoa (Mock)
	 * 
	 * @param pessoa
	 * @return
	 * @see IPessoaService
	 */
	@Override
	public PessoaVO buscarPessoa(String cpf) {

		PessoaVO newPessoa = new PessoaVO("Anderson Baratella Alves", "35741144861", new Date(1988, 9, 27));

		return newPessoa;
	}

	@Override
	public void excluirPessoa(String cpf) {
		// TODO Auto-generated method stub

	}

	@Override
	public PessoaVO adicionarPessoa(PessoaVO pessoa) {
		// TODO Auto-generated method stub
		return null;
	}

}
