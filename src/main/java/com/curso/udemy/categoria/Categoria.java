package com.curso.udemy.categoria;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.curso.udemy.produto.Produto;

// SERIALIZABLE -> ESSA CLASSE, OS OBJETOS DELA PODEM SER CONVERTIDOS EM BYTES
// OU SEJA, PARA QUE OS OBJETOS POSSAM SER GRAVADOS EM ARQUIVOS OU TRAFEGAR EM REDE

@Entity
public class Categoria implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String nome;
	
	@OneToMany(mappedBy = "categoria")
	private List<Produto> produtos = new ArrayList<Produto>();

	@Deprecated
	public Categoria() {

	}

	public Categoria(String nome) {
		this.nome = nome;
	}

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}


}
