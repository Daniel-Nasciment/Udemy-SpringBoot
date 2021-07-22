package com.curso.udemy.categoria;

import javax.validation.Valid;

import org.springframework.stereotype.Service;

@Service
public class CategoriaService {

	public String criandoRegraQualquer() {

		System.out.println("Camada service em funcionamento");

		return "Criando uma regra...";
	}

	public Categoria replace(Categoria categoria, @Valid CategoriaRequest request) {

		categoria.setNome(request.getNome());

		return categoria;
	}

}
