package com.curso.udemy.cidade;

import java.util.Optional;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.curso.udemy.estado.Estado;
import com.curso.udemy.estado.EstadoRepository;

public class CidadeRequest {

	@NotBlank
	private String nome;

	@NotNull
	private Long estado;

	public String getNome() {
		return nome;
	}

	public Long getEstado() {
		return estado;
	}

	public Cidade toModel(EstadoRepository estadoRepo) {

		Optional<Estado> estado = estadoRepo.findById(this.estado);

		return new Cidade(this.nome, estado.orElse(null));
	}

}
