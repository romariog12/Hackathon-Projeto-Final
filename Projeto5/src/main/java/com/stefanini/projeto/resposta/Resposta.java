package com.stefanini.projeto.resposta;

import java.io.Serializable;
/**
 * 
 * @author Romário Macedo Portela<romariomacedo18@gmail.com>
 *
 */
public class Resposta implements Serializable {

	private static final long serialVersionUID = 1L;
	private String mensagem;
	private int codigo;

	public String getMensagem() {
		return mensagem;
	}

	public Resposta() {

	}

	public Resposta(String mensagem, int codigo) {
		this.mensagem = mensagem;
		this.codigo = codigo;
	}

	public int getCodigo() {
		return codigo;
	}
}
