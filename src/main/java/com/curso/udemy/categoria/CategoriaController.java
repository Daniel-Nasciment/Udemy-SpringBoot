package com.curso.udemy.categoria;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

	@Autowired
	private CategoriaRepository categoriaRepo;

	@GetMapping("/{id}")
	public ResponseEntity<CategoriaDto> BuscaCategoria(@PathVariable Long id) {

		System.out.println(categoriaRepo.findById(id));
		
		Optional<Categoria> categoria = categoriaRepo.findById(id);

		if (categoria.orElse(null) == null) {
			return ResponseEntity.badRequest().build();
		}

		return ResponseEntity.ok(new CategoriaDto(categoria.get()));
	}

	@PostMapping
	public ResponseEntity<?> criaCategoria(@RequestBody @Valid CategoriaRequest request) {

		Categoria categoria = request.toModel();

		categoriaRepo.save(categoria);

		return ResponseEntity.ok().build();
	}

}
