package com.curso.udemy.categoria;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

	
	@GetMapping
	public String Teste() {
		return "Testado e funcionando!";
	}

	
}
