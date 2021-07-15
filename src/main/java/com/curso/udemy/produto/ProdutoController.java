package com.curso.udemy.produto;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.curso.udemy.categoria.CategoriaRepository;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

	@Autowired
	private CategoriaRepository categoriaRepo;

	@Autowired
	private ProdutoRepository produtoRepo;

	@PostMapping
	public ResponseEntity<?> criaProduto(@RequestBody @Valid ProdutoRequest request) {

		Produto produto = request.toModel(categoriaRepo);
		
		if(produto.getCategoria() == null) {
			return ResponseEntity.badRequest().build();
		}

		produtoRepo.save(produto);

		return ResponseEntity.ok().build();
	}

}
