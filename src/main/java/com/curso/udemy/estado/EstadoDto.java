package com.curso.udemy.estado;

import java.util.ArrayList;
import java.util.List;

public class EstadoDto {

	private String nome;

	private List<?> cidades = new ArrayList<>();

	
	public EstadoDto(Estado estado) {
		this.nome = estado.getNome();
		this.cidades = estado.getCidades();
	}
	
	public String getNome() {
		return nome;
	}

	public List<?> getCidades() {
		return cidades;
	}

}
