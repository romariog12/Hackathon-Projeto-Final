package com.stefanini.projeto.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.stefanini.projeto.exception.TreinaException;
import com.stefanini.projeto.model.Mesa;
import com.stefanini.projeto.repository.MesaRepository;
import com.stefanini.projeto.resposta.Resposta;
import com.stefanini.projeto.resposta.RespostaEnum;
import com.stefanini.projeto.resposta.RespostaUtil;

/**
 * 
 * @author Romário Macedo Portela <romariomacedo18@gmail.com>
 *
 */

@Service
public class MesaService {

	@Autowired
	private MesaRepository repository;

	@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
	public List<Mesa> findAll() throws TreinaException {
		return repository.findAll();
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public Resposta save(Mesa mesa) throws TreinaException {

		if (mesa.getIdMesa() != null) {
			repository.save(mesa);
			return RespostaUtil.mensagem(RespostaEnum.UPDATE);
		}
		if (repository.findByNome(mesa.getNome()) == null) {
			repository.save(mesa);
			return RespostaUtil.mensagem(RespostaEnum.SAVE);
		} else {
			return RespostaUtil.mensagem(RespostaEnum.CADASTRO_EXISTENTE);
		}
	}

	public Resposta remove(Long id) throws TreinaException {
		repository.deleteById(id);
		return RespostaUtil.mensagem(RespostaEnum.DELETE);
	}

	public Mesa findById(Long id) throws TreinaException {
		return repository.findById(id).get();
	}

}