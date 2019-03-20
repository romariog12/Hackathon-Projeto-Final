package com.stefanini.projeto.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stefanini.projeto.exception.TreinaException;
import com.stefanini.projeto.model.Cadeira;
import com.stefanini.projeto.repository.CadeiraRepository;
import com.stefanini.projeto.resposta.Resposta;
import com.stefanini.projeto.resposta.RespostaEnum;
import com.stefanini.projeto.resposta.RespostaUtil;


/**
 * 
 * @author Romário Macedo Portela<romariomacedo18@gmail.com>
 *
 */

@Service
public class CadeiraService {

	@Autowired
	CadeiraRepository repository;

	public List<Cadeira> findAll() throws TreinaException {
		return repository.findAll();
	}

	public Resposta save(Cadeira cadeira) throws TreinaException {
		repository.save(cadeira);
		return RespostaUtil.mensagem(RespostaEnum.SAVE);
	}

	public Resposta delete(Long id) throws TreinaException {
		repository.deleteById(id);
		return RespostaUtil.mensagem(RespostaEnum.DELETE);
	}

	public Cadeira findById(Long id) throws TreinaException {
		return repository.findById(id).get();
	}
}
