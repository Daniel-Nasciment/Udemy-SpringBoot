package com.curso.udemy.categoria;

import org.springframework.stereotype.Service;

@Service
public class CategoriaService {

	
	public String criandoRegraQualquer() {
		
		System.out.println("Camada service em funcionamento");
		
		return "Criando uma regra...";
	}
	
}
