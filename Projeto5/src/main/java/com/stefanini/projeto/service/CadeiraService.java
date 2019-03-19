package com.stefanini.projeto.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stefanini.projeto.exception.TreinaException;
import com.stefanini.projeto.model.Cadeira;
import com.stefanini.projeto.repository.CadeiraRepository;
import com.stefanini.projeto.resposta.RespostaUtil;
import com.stefanini.projeto.resposta.Resposta;


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
		return RespostaUtil.RESPOSTA_SUCESSO_CREATE;
	}

	public Resposta delete(Long id) throws TreinaException {
		repository.deleteById(id);
		return RespostaUtil.RESPOSTA_SUCESSO_DELETE;
	}

	public Optional<Cadeira> findById(Long id) throws TreinaException {
		return repository.findById(id);
	}
}
