package com.curso.udemy.categoria;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
//@WebMvcTest(controllers = CategoriaController.class)
@SpringBootTest // END TO END -> CRIA O CONTEXTO DA APLICAÇÃO
@AutoConfigureMockMvc // END TO END -> SOBE O CONTEXTO DE APLICAÇÃO
public class CategoriaControllerTest {

	@Autowired
	MockMvc mockMvc;

	@Autowired
	private ObjectMapper objectMapper;

//	@MockBean
//	private CategoriaRepository categoriaRepo;

	@Test
	public void buscaPorIdDeveRetornarOk() throws Exception {

		mockMvc.perform(MockMvcRequestBuilders.get("/categorias/1")).andExpect(MockMvcResultMatchers.status().isOk());

	}

	@Test
	public void buscaPorIdDeveRetornarBadRequest() throws Exception {

		long maxValue = Long.MAX_VALUE;

		mockMvc.perform(MockMvcRequestBuilders.get("/categorias/{id}", maxValue))
				.andExpect(MockMvcResultMatchers.status().isBadRequest());

	}

	@Test
	public void deveCriar() throws Exception {
		Categoria categoria = new Categoria(1L, "Teste");

		mockMvc.perform(
				post("/categorias").contentType("application/json").content(objectMapper.writeValueAsString(categoria)))
				.andExpect(status().isOk());
	}

//	@Before
//	public void setupRepo() {
//		Categoria categoria = new Categoria(1L, "Teste");
//
//		when(categoriaRepo.findById(categoria.getId())).thenReturn(Optional.of(categoria));
//	}

}
