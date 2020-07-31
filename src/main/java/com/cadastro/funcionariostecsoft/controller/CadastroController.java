package com.cadastro.funcionariostecsoft.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.cadastro.funcionariostecsoft.model.Cadastro;
import com.cadastro.funcionariostecsoft.repository.CadastroRepository;


@RestController
@RequestMapping("/api")
public class CadastroController {

	
	@Autowired
	CadastroRepository cadastroRepository;
	
	
	@GetMapping("/buscar")
	public List<Cadastro> listarfuncionarios(){
		return cadastroRepository.findAll();
	}
	
	@PostMapping("/adicionarfuncionarios")
	@ResponseStatus(HttpStatus.CREATED)
	public Cadastro adicionarFuncionarios(@RequestBody Cadastro cadastro ) {
			return cadastroRepository.save(cadastro);
			
	}
	
	@PutMapping("/atualizarcadastro/{cadastroId}")
	public ResponseEntity<Cadastro> atualizar(@PathVariable long cadastroId,
			@RequestBody Cadastro cadastro){
		if (!cadastroRepository.existsById(cadastroId)) {
			return ResponseEntity.notFound().build();
		}
		
		cadastro.setCodigo(cadastroId);
		cadastro = cadastroRepository.save(cadastro);
		return ResponseEntity.ok(cadastro);
	}
	
	
	@DeleteMapping("/deletarcadastro/{cadastroId}")
	public ResponseEntity<Void> remover (@PathVariable long cadastroId){
		if(!cadastroRepository.existsById(cadastroId)) {
			return ResponseEntity.notFound().build();
	
		}
			
		cadastroRepository.deleteById(cadastroId);
		return ResponseEntity.noContent().build();
	
	}

}