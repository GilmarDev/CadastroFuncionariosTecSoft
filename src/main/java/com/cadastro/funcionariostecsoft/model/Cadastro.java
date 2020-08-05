package com.cadastro.funcionariostecsoft.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;



@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "funcionarios")
public class Cadastro {

	
	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long codigo; 
	
	@Column(name = "nome")
	private String nome;
	
	@Column(name = "idade")
	private int idade;
	
	@Column(name = "cargo")
	private String cargo;
	
	
	@Column(name = "endereco")
	private String endereco;
	
	@Column(name ="telefone")
	private String telefone;
	
	@Column(name = "email")
	private String email;

	
}

	



	
	
	
	

	

	


