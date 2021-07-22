package com.curso.udemy.categoria;

import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.fasterxml.jackson.databind.ObjectMapper;

//@RunWith(SpringRunner.class)
@WebMvcTest(controllers = CategoriaController.class)
//@SpringBootTest // END TO END -> CRIA O CONTEXTO DA APLICAÇÃO
//@AutoConfigureMockMvc // END TO END -> SOBE O CONTEXTO DE APLICAÇÃO
//@ExtendWith(SpringExtension.class)
public class CategoriaControllerTest {

//	@InjectMocks
//	private CategoriaController categoriaController;

	@Autowired
	MockMvc mockMvc;

	@Autowired
	private ObjectMapper objectMapper;

	@MockBean
	private CategoriaRepository categoriaRepo;

	@MockBean
	private CategoriaService categoriaService;

	@Test
	public void buscaPorIdDeveRetornarOk() throws Exception {

		mockMvc.perform(MockMvcRequestBuilders.get("/categorias/1")).andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON));

		verify(categoriaService, times(1)).criandoRegraQualquer();
	}

	@Test
	public void buscaPorIdDeveRetornarBadRequest() throws Exception {

		long maxValue = Long.MAX_VALUE;

		mockMvc.perform(MockMvcRequestBuilders.get("/categorias/{id}", maxValue))
				.andExpect(MockMvcResultMatchers.status().isBadRequest());

		verify(categoriaService, never()).criandoRegraQualquer();

	}

	@Test
	public void deveCriar() throws Exception {
		CategoriaRequest request = new CategoriaRequest();
		request.setNome("Nova categoira");


		mockMvc.perform(
				post("/categorias").contentType("application/json").content(objectMapper.writeValueAsString(request)))
				.andExpect(status().isOk());

		verify(categoriaService, never()).criandoRegraQualquer();

	}

	@BeforeEach
	public void setupRepo() {
		Categoria categoria = new Categoria(1L, "Teste");

		when(categoriaRepo.findById(categoria.getId())).thenReturn(Optional.of(categoria));

	}

}
