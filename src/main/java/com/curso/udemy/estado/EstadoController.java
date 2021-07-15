package com.curso.udemy.estado;

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
@RequestMapping("/estados")
public class EstadoController {

	@Autowired
	private EstadoRepository estadoRepo;

	@GetMapping("/{id}")
	public ResponseEntity<?> buscaEstado(@PathVariable Long id) {

		Optional<Estado> estado = estadoRepo.findById(id);

		if (estado.orElse(null) == null) {
			return ResponseEntity.badRequest().build();
		}

		return ResponseEntity.ok().body(new EstadoDto(estado.get()));

	}

	@PostMapping
	public ResponseEntity<?> criaEstado(@RequestBody @Valid EstadoRequest request) {

		Estado estado = request.toModel();

		estadoRepo.save(estado);

		return ResponseEntity.ok().build();
	}

}
