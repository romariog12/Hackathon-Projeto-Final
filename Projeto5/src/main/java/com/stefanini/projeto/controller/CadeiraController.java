package com.stefanini.projeto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.stefanini.projeto.exception.TreinaException;
import com.stefanini.projeto.model.Cadeira;
import com.stefanini.projeto.resposta.Resposta;
import com.stefanini.projeto.service.CadeiraService;

/**
 * 
 * @author Romário Macedo Portela<romariomacedo18@gmail.com>
 *
 */

@CrossOrigin
@Controller
@RequestMapping(path="/mesa/cadeira")
public class CadeiraController{

	@Autowired
	CadeiraService service;	    
	
	@RequestMapping(method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Cadeira>> findAll() throws TreinaException {
		return  new ResponseEntity<>(service.findAll(),HttpStatus.OK);
	}

	@RequestMapping(method=RequestMethod.POST, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Resposta> salvar(@RequestBody Cadeira cadeira) throws TreinaException {
		return new ResponseEntity<>(service.save(cadeira), HttpStatus.CREATED);
	}
	
	@RequestMapping(method=RequestMethod.PUT, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Resposta> editar(@RequestBody Cadeira cadeira) throws TreinaException {
		return new ResponseEntity<>(service.save(cadeira), HttpStatus.CREATED);
	}

	@RequestMapping(path="/{id}",method=RequestMethod.DELETE, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Resposta> remover(@PathVariable Long id) throws TreinaException {
		return new ResponseEntity<>(service.delete(id),HttpStatus.OK);
	}
	
}
