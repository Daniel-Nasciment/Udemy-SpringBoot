package com.curso.udemy.categoria;

public class CategoriaRequest {

	private String nome;

	public String getNome() {
		return nome;
	}

	public Categoria toModel() {
		return new Categoria(nome);
	}

}
