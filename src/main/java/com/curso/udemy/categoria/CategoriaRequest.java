package com.curso.udemy.categoria;

import javax.validation.constraints.NotBlank;

public class CategoriaRequest {

	@NotBlank
	private String nome;

	public String getNome() {
		return nome;
	}

	public String setNome(String nome) {
		return this.nome = nome;
	}
	
	public Categoria toModel() {
		return new Categoria(nome);
	}

}
