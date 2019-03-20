package com.stefanini.projeto.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

/**
 * 
 * @author Romário Macedo Portela<romariomacedo18@gmail.com>
 *
 */

@Entity
public class Mesa implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "sequenceIdMesa", sequenceName = "sequenceIdMesa", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceIdMesa")
	@Column(name = "idMesa")
	private Long idMesa;
	
	@Column(name = "nome")
	private String nome;
	
	@JsonProperty(access=Access.READ_ONLY)
	@OneToMany(mappedBy = "mesa", cascade = CascadeType.ALL, fetch=FetchType.LAZY)
	private List<Cadeira> cadeiras;

	public Mesa() {
		
	}

	public Mesa(Long id, String nome) {
		super();
		this.idMesa = id;
		this.nome = nome;
	}

	public Long getIdMesa() {
		return idMesa;
	}

	public void setIdMesa(Long id) {
		this.idMesa = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	

	public List<Cadeira> getCadeiras() {
		return cadeiras;
	}

	public void setCadeiras(List<Cadeira> cadeiras) {
		this.cadeiras = cadeiras;
	}

}