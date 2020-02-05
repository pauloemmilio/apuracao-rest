package com.paulo.apuracao.controllers;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.paulo.apuracao.models.Quesito;
import com.paulo.apuracao.services.QuesitoService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/quesitos")
public class QuesitoController {

	@Autowired private QuesitoService quesitoService;
	
	@ApiOperation(value="Retorna a lista de quesitos no banco de dados")
	@GetMapping
	public List<Quesito> listar() {
		return quesitoService.listar();
	}
	
	@ApiOperation(value="Recebe os dados de um quesito, realiza o cadastro e retorna a informação")
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Quesito cadastrar(@RequestBody @Valid Quesito quesito) {
		return quesitoService.salvar(quesito);
	}
	
	@ApiOperation(value="Recebe os dados de um quesito, realiza o cadastro e retorna a informação")
	@GetMapping("/{id}")
	public ResponseEntity<Quesito> buscarPorId(@PathVariable Long id) {
		Optional<Quesito> quesito = quesitoService.buscarPorId(id);
		if(!quesito.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(quesito.get());
	}
}
