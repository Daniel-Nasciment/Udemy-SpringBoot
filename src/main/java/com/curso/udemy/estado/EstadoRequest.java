package com.curso.udemy.estado;

import javax.validation.constraints.NotBlank;

public class EstadoRequest {

	@NotBlank
	private String nome;
	
	public String getNome() {
		return nome;
	}
	
	public Estado toModel() {
		return new Estado(this.nome);
	}
	
}
