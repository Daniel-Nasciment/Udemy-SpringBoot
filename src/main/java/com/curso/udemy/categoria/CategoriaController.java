package com.curso.udemy.categoria;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.curso.udemy.util.IdNotFoundException;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

	@Autowired
	private CategoriaRepository categoriaRepo;

	@Autowired
	private CategoriaService categoriaService;

	@GetMapping("/{id}")
	public ResponseEntity<CategoriaDto> BuscaCategoria(@PathVariable Long id) {

		Optional<Categoria> categoria = categoriaRepo.findById(id);

		categoria.orElseThrow(() -> new IdNotFoundException("Id não localizado"));

		categoriaService.criandoRegraQualquer();

		return ResponseEntity.ok(new CategoriaDto(categoria.get()));
	}

	@PostMapping
	public ResponseEntity<?> criaCategoria(@RequestBody @Valid CategoriaRequest request) {

		Categoria categoria = request.toModel();

		categoriaRepo.save(categoria);

		return ResponseEntity.ok().build();
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> deletarCategoria(@PathVariable Long id) {

		if (categoriaRepo.existsById(id) == false)
			throw new IdNotFoundException("Id não localizado");

		categoriaRepo.deleteById(id);

		return ResponseEntity.ok().build();

	}

	@PutMapping("/{id}")
	public ResponseEntity<?> atualizarCategoria(@PathVariable Long id, @RequestBody @Valid CategoriaRequest request) {

		Optional<Categoria> categoria = categoriaRepo.findById(id);

		categoria.orElseThrow(() -> new IdNotFoundException("Id não localizado"));

		Categoria categoriaAtt = categoriaService.replace(categoria.get(), request);

		categoriaRepo.save(categoriaAtt);

		return ResponseEntity.ok(new CategoriaDto(categoria.get()));

	}

}
