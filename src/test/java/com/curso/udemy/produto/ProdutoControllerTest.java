package com.curso.udemy.produto;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.math.BigDecimal;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.curso.udemy.categoria.Categoria;
import com.curso.udemy.categoria.CategoriaRepository;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest(controllers = ProdutoController.class)
public class ProdutoControllerTest {

	@Autowired
	MockMvc mockMvc;

	@Autowired
	private ObjectMapper objectMapper;

	@MockBean
	private ProdutoRepository produtoRepo;

	@MockBean
	private CategoriaRepository categoriaRepo;

	@Test
	public void deveCriarProduto() throws Exception {

		ProdutoRequest request = new ProdutoRequest("Produto", BigDecimal.valueOf(10.0), 1L);

		mockMvc.perform(post("/produtos").contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(request))).andExpect(status().isOk());

	}

	@Test
	public void naoDeveCriarUmProduto() throws Exception {
		ProdutoRequest request = new ProdutoRequest("Produto", BigDecimal.valueOf(10.0), Long.MAX_VALUE);

		mockMvc.perform(post("/produtos").contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(request))).andExpect(status().isBadRequest());

	}

	@BeforeEach
	public void setup() {

		Categoria categoria = new Categoria(1L, "Nova categoria");

		when(categoriaRepo.findById(categoria.getId())).thenReturn(Optional.of(categoria));

	}

}
