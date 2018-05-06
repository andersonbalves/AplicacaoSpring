/*
 * 
 */
package br.com.baratella.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Classe de modelo para o tipo Pessoa
 *
 * @author Anderson
 */
/**
 * @author Anderson
 *
 */
@Entity
@Table(name = "pessoa", schema = "APLICACAO_SPRING")
public class Pessoa {

	/** Atributo nome. */
	@Column(name = "nome_pessoa")
	String nome;

	/** Atributo cpf. */
	@Id
	@Column(name = "cpf_pessoa")
	String cpf;

	/** Atributo data nascimento. */
	@Column(name = "data_nasc_pessoa")
	Date dataNascimento;

	/**
	 * Método construtor de pessoa VO.
	 */
	public Pessoa() {
		super();
	}

	/**
	 * Método Construtor da Classe
	 * 
	 * @param nome
	 *            nome da pessoa
	 * @param cpf
	 *            cpf da pessoa
	 * @param dataNascimento
	 *            data de nascimento da pessoa
	 */
	public Pessoa(String nome, String cpf, Date dataNascimento) {
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
