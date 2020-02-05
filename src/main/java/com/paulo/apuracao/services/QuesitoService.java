package com.paulo.apuracao.services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.paulo.apuracao.models.Quesito;

@Service
public class QuesitoService {

	@Autowired private QuesitoRepository quesitoRepository;
	
	public List<Quesito> listar(){
		return quesitoRepository.findAll();
	}

	public Quesito salvar(@Valid Quesito quesito) {
		return quesitoRepository.save(quesito);
	}

	public Optional<Quesito> buscarPorId(Long id) {
		return quesitoRepository.findById(id);
	}
}
