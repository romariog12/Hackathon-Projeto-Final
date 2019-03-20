package com.stefanini.projeto.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.stefanini.projeto.exception.TreinaException;
import com.stefanini.projeto.model.Mesa;
import com.stefanini.projeto.repository.MesaRepository;
import com.stefanini.projeto.resposta.RespostaUtil;
import com.stefanini.projeto.resposta.Resposta;

/**
 * 
 * @author Romário Macedo Portela <romariomacedo18@gmail.com>
 *
 */

@Service
public class MesaService {

	@Autowired
	private MesaRepository repository;

	public List<Mesa> findAll() throws TreinaException {
		return repository.findAll();
	}

	public Resposta save(Mesa mesa) throws TreinaException {
		if (mesa.getCadeiras().size() < 6) {
			if (mesa.getIdMesa() != null) {
				repository.save(mesa);
				return RespostaUtil.RESPOSTA_SUCESSO_UPDATE;
			}
			if (repository.findByNome(mesa.getNome()) == null) {
				repository.save(mesa);
				return RespostaUtil.RESPOSTA_SUCESSO_CREATE;
			} else {
				return RespostaUtil.RESPOSTA_ERRO_EXISTENTE;
			}
		} else {
			return RespostaUtil.RESPOSTA_ERRO_EXCEDIDO;
		}

	}

	public Resposta remove(Long id) throws TreinaException {
		repository.deleteById(id);
		return RespostaUtil.RESPOSTA_SUCESSO_DELETE;
	}

	public Optional<Mesa> findById(Long id) throws TreinaException {
		Optional<Mesa> mesa = repository.findById(id);
		System.out.println(mesa.get().getNome());
		return repository.findById(id);
	}

}