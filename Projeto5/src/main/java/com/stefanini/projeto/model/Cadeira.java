package com.stefanini.projeto.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;


/**
 * 
 * @author Romário Macedo Portela<romariomacedo18@gmail.com>
 *
 */

@Entity
public class Cadeira implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "sequenceIdCadeira", sequenceName = "sequenceIdCadeira", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceIdCadeira")
	@Column(name = "idCadeira")
	private Long idCadeira;

	@Column(name = "nome")
	private String nome;

	@ManyToOne
	@JsonProperty(access = Access.WRITE_ONLY)
	@JoinColumn(name = "idMesa", referencedColumnName = "idMesa")
	private Mesa mesa;

	public Mesa getMesa() {
		return mesa;
	}

	public void setMesa(Mesa mesa) {
		this.mesa = mesa;
	}

	public Cadeira() {

	}

	public Cadeira(Long idCadeira, String nome, Mesa mesa) {
		super();
		this.idCadeira = idCadeira;
		this.nome = nome;
		this.mesa = mesa;
	}

	public Cadeira(String nome) {
		super();
		this.nome = nome;
	}

	public Long getIdCadeira() {
		return idCadeira;
	}

	public void setIdCadeira(Long id) {
		this.idCadeira = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}