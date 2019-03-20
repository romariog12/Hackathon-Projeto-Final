package com.stefanini.projeto.resposta;

import org.springframework.http.HttpStatus;

import com.stefanini.projeto.exception.TreinaException;

/**
 * 
 * @author Romário Macedo Portela<romariomacedo18@gmail.com>
 *
 */
public class RespostaUtil {

	private static final String SUCCESS_CREATE = "Cadasstro realizado com sucesso!";
	private static final String SUCCESS_UPDATE = "Dados atualizados com sucesso!";
	private static final String ERROR_CREATE_EXISTENTE = "Cadastro existente";
	private static final String SUCCESS_DELETE = "Registro removido com sucesso!";

	public static Resposta mensagem(RespostaEnum e) throws TreinaException {
		switch (e.getValue()) {
		case 1:
			return new Resposta(SUCCESS_CREATE, HttpStatus.CREATED.value());
		case 2:
			return new Resposta(SUCCESS_UPDATE, HttpStatus.CREATED.value());
		case 3:
			return new Resposta(SUCCESS_DELETE, HttpStatus.OK.value());
		case 4:
			return new Resposta(ERROR_CREATE_EXISTENTE, HttpStatus.NON_AUTHORITATIVE_INFORMATION.value());

		}
		throw new TreinaException("Erro ao tentar processar sua solicitação");
	}

}
