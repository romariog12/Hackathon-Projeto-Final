package com.stefanini.projeto.resposta;

import org.springframework.http.HttpStatus;
/**
 * 
 * @author Romário Macedo Portela<romariomacedo18@gmail.com>
 *
 */
public class RespostaUtil {

	private static final String SUCCESS_CREATE = "Cadasstro realizado com sucesso!";
	private static final String SUCCESS_UPDATE = "Dados atualizados com sucesso!";
	private static final String ERROR_CREATE_EXISTENTE = "Cadastro existente";
	private static final String ERROR_CREATE_EXCEDIDO = "Quantidade de cadeiras excedida!";
	private static final String SUCCESS_DELETE = "Registro removido com sucesso!";
	
	public static final Resposta RESPOSTA_SUCESSO_CREATE = 	new Resposta(SUCCESS_CREATE, HttpStatus.CREATED.value()); 
	public static final Resposta RESPOSTA_SUCESSO_UPDATE = 	new Resposta(SUCCESS_UPDATE, HttpStatus.CREATED.value()); 
	public static final Resposta RESPOSTA_SUCESSO_DELETE = 	new Resposta(SUCCESS_DELETE, HttpStatus.OK.value()); 
	public static final Resposta RESPOSTA_ERRO_EXCEDIDO = 	new Resposta(ERROR_CREATE_EXCEDIDO,HttpStatus.NON_AUTHORITATIVE_INFORMATION.value());
	public static final Resposta RESPOSTA_ERRO_EXISTENTE = 	new Resposta(ERROR_CREATE_EXISTENTE, HttpStatus.NON_AUTHORITATIVE_INFORMATION.value());
}
