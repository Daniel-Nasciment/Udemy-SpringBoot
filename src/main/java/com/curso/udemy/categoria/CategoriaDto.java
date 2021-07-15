package com.curso.udemy.categoria;

import java.util.ArrayList;
import java.util.List;

public class CategoriaDto {

	private String nome;
	private List<?> produtos = new ArrayList<>();

	public CategoriaDto(Categoria categoria) {
		this.nome = categoria.getNome();
		this.produtos = categoria.getProdutos();
	}

	public String getNome() {
		return nome;
	}

	public List<?> getProdutos() {
		return produtos;
	}

}
