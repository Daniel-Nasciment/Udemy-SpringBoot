package com.curso.udemy.cidade;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.curso.udemy.estado.EstadoRepository;

@RestController
@RequestMapping("/cidades")
public class CidadeController {

	@Autowired
	private CidadeRepository cidadeRepo;
	
	@Autowired
	private EstadoRepository estadoRepo;

	@PostMapping
	public ResponseEntity<?> criaEstado(@RequestBody @Valid CidadeRequest request) {

		Cidade cidade = request.toModel(estadoRepo);
		
		if(cidade.getEstado() == null) {
			return ResponseEntity.badRequest().build();
		}

		cidadeRepo.save(cidade);

		return ResponseEntity.ok().build();
	}

}
