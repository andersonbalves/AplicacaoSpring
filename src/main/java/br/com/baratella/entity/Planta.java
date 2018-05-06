/*
 * 
 */
package br.com.baratella.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Classe de modelo para o tipo PLanta.
 *
 * @author Anderson
 */
@Entity
@Table(name = "planta", schema = "APLICACAO_SPRING")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Planta {

	/** Atributo id. */
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "id_planta")
	Long id;

	/** Atributo nome. */
	@Column(name = "nome_planta")
	String nome;

	/** Atributo nome cientifico. */
	@Column(name = "nome_cientifico_planta")
	String nomeCientifico;

	/** Atributo data nascimento. */
	@Column(name = "data_catalogo_planta")
	Date dataCatalogo;

	/**
	 * Método construtor do tipo planta.
	 */
	public Planta() {
		super();
	}

	/**
	 * Método Construtor da Classe
	 * 
	 * @param nome
	 * @param nomeCientifico
	 * @param dataCatalogo
	 */
	public Planta(String nome, String nomeCientifico, Date dataCatalogo) {
		super();
		this.nome = nome;
		this.nomeCientifico = nomeCientifico;
		this.dataCatalogo = dataCatalogo;
	}

	/**
	 * Método get para o atributo id planta.
	 *
	 * @return id planta
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Método set para o atributo id planta.
	 *
	 * @param idPlanta
	 *            the new id planta
	 */
	public void setId(Long id) {
		this.id = id;
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
	 * Método get para o atributo nome cientifico.
	 *
	 * @return nome cientifico
	 */
	public String getNomeCientifico() {
		return nomeCientifico;
	}

	/**
	 * Método set para o atributo nome cientifico.
	 *
	 * @param nomeCientifico
	 *            the new nome cientifico
	 */
	public void setNomeCientifico(String nomeCientifico) {
		this.nomeCientifico = nomeCientifico;
	}

	/**
	 * Método get para o atributo data catalogo.
	 *
	 * @return data catalogo
	 */
	public Date getDataCatalogo() {
		return dataCatalogo;
	}

	/**
	 * Método set para o atributo data catalogo.
	 *
	 * @param dataCatalogo
	 *            the new data catalogo
	 */
	public void setDataCatalogo(Date dataCatalogo) {
		this.dataCatalogo = dataCatalogo;
	}

}
