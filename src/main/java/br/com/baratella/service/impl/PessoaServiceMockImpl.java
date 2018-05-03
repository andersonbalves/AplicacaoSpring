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
	public PessoaVO buscarPessoa(String nome) {

		PessoaVO newPessoa = new PessoaVO("Anderson Baratella Alves", "35741144861", new Date(1988, 9, 27));

		return newPessoa;
	}

}
