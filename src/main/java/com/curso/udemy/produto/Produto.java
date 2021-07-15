package com.curso.udemy.produto;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.curso.udemy.categoria.Categoria;

@Entity
public class Produto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String nome;

	private BigDecimal preco;

	@ManyToOne
	private Categoria categoria;

	@Deprecated
	public Produto() {

	}

	public Produto(String nome, BigDecimal preco, Categoria categoria) {
		this.nome = nome;
		this.preco = preco;
		this.categoria = categoria;
	}
	
	public Long getId() {
		return id;
	}
	
	public String getNome() {
		return nome;
	}
	
	public BigDecimal getPreco() {
		return preco;
	}
	
	public Categoria getCategoria() {
		return categoria;
	}

}
