/*
 * 
 */
package br.com.baratella.model;

import java.util.Date;

/**
 * Classe de modelo para o tipo Pessoa
 *
 * @author Anderson
 */
public class PessoaVO {

	/** Atributo nome. */
	String nome = null;

	/** Atributo cpf. */
	String cpf = null;

	/** Atributo data nascimento. */
	Date dataNascimento = null;

	/**
	 * Método construtor de pessoa VO.
	 */
	public PessoaVO() {
		super();
	}
	
	/**
	 * Método Construtor da Classe 
	 * @param nome nome da pessoa
	 * @param cpf cpf da pessoa
	 * @param dataNascimento data de nascimento da pessoa
	 */
	public PessoaVO(String nome, String cpf, Date dataNascimento) {
		super();
		this.nome = nome;
		this.cpf = cpf;
		this.dataNascimento = dataNascimento;
	}



	/**
	 * Método get para o atributo nome.
	 *
	 * @return nome
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * Método set para o atributo nome.
	 *
	 * @param nome
	 *            the new nome
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * Método get para o atributo cpf.
	 *
	 * @return cpf
	 */
	public String getCpf() {
		return cpf;
	}

	/**
	 * Método set para o atributo cpf.
	 *
	 * @param cpf
	 *            the new cpf
	 */
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	/**
	 * Método get para o atributo data nascimento.
	 *
	 * @return data nascimento
	 */
	public Date getDataNascimento() {
		return dataNascimento;
	}

	/**
	 * Método set para o atributo data nascimento.
	 *
	 * @param dataNascimento
	 *            the new data nascimento
	 */
	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

}
