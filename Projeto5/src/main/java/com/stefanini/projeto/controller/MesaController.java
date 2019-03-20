package com.stefanini.projeto.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.stefanini.projeto.exception.TreinaException;
import com.stefanini.projeto.model.Mesa;
import com.stefanini.projeto.resposta.Resposta;
import com.stefanini.projeto.service.MesaService;
/**
 * 
 * @author Romário Macedo Portela<Romário Macedo Portela>
 *
 */
@CrossOrigin
@Controller
@RequestMapping(path="/mesa")
public class MesaController{

	@Autowired
	private MesaService service;

	@RequestMapping(method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<Mesa> findAll() throws TreinaException  {
		return service.findAll();
	}

	@RequestMapping(path="/{id}",method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Mesa getMesa(@PathVariable("id") Long id) throws TreinaException  {
		return service.findById(id);
	}


	@RequestMapping(method=RequestMethod.POST, produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<Resposta> salvar(@RequestBody Mesa mesa) throws TreinaException  {
		return ResponseEntity.ok(service.save(mesa));
	}

	@RequestMapping(path="/{id}",method=RequestMethod.DELETE, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Resposta> remover(@PathVariable Long id) throws TreinaException {
		return  ResponseEntity.ok(service.remove(id));
	}
	
	@RequestMapping(method=RequestMethod.PUT, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Resposta> editar(@RequestBody Mesa mesa) throws TreinaException {
		return ResponseEntity.ok(service.save(mesa));
	}
	
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String, String> handleValidationExceptions(
	  MethodArgumentNotValidException ex) {
	    Map<String, String> errors = new HashMap<>();
	    ex.getBindingResult().getAllErrors().forEach((error) -> {
	        String fieldName = ((FieldError) error).getField();
	        String errorMessage = error.getDefaultMessage();
	        errors.put(fieldName, errorMessage);
	    });
	    return errors;
	}
}