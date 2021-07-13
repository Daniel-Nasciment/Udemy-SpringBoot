package com.curso.udemy.categoria;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

	@Autowired
	private CategoriaRepository categoriaRepo;
	
	
	@PostMapping
	public ResponseEntity<?> criaCategoria(@RequestBody CategoriaRequest request) {
		
		Categoria categoria = request.toModel();
		
		categoriaRepo.save(categoria);
		
		return ResponseEntity.ok().build();
	}


	
}
