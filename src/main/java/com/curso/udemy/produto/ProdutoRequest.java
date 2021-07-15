package com.curso.udemy.produto;

import java.math.BigDecimal;
import java.util.Optional;

import com.curso.udemy.categoria.Categoria;
import com.curso.udemy.categoria.CategoriaRepository;

public class ProdutoRequest {

	private String nome;

	private BigDecimal preco;

	private Long categoria;

	public String getNome() {
		return nome;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public Long getCategoria() {
		return categoria;
	}

	public Produto toModel(CategoriaRepository categoriaRepo) {

		Optional<Categoria> categoria = categoriaRepo.findById(this.categoria);
		
		return new Produto(this.nome, this.preco, categoria.orElse(null));
	}

}
