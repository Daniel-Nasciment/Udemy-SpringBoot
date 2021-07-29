package com.curso.udemy.categoria;

import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
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

	@Test
	public void deveDeletar() throws Exception {
		mockMvc.perform(delete("/categorias/1")).andExpect(status().isOk());

		verify(categoriaRepo, times(1)).deleteById(1L);

	}

	@Test
	public void naoDeveDeletar() throws Exception {
		when(categoriaRepo.existsById(1L)).thenReturn(Boolean.FALSE);

		mockMvc.perform(delete("/categorias/1")).andExpect(status().isBadRequest());

		verify(categoriaRepo, times(0)).deleteById(1L);

	}

	@Test
	public void deveAtualizar() throws Exception {

		CategoriaRequest request = new CategoriaRequest();
		request.setNome("Testado");
		
		 mockMvc.perform(
				put("/categorias/1").contentType("application/json").content(objectMapper.writeValueAsString(request)))
				.andExpect(status().isOk());

	}
	

	@Test
	public void naoDeveAtualizar() throws Exception {

		long maxValue = Long.MAX_VALUE;

		CategoriaRequest request = new CategoriaRequest();
		request.setNome("Testado");
		
		 mockMvc.perform(
				put("/categorias/{id}", maxValue).contentType("application/json").content(objectMapper.writeValueAsString(request)))
				.andExpect(status().isBadRequest());

	}
	
	
	@BeforeEach
	public void setupRepo() {
		Categoria categoria = new Categoria(1L, "Teste");
		
		Categoria categoriaAtt = new Categoria(categoria.getId(), "Testado");
		
		CategoriaRequest request = new CategoriaRequest();
		request.setNome("Testado");

		when(categoriaRepo.findById(categoria.getId())).thenReturn(Optional.of(categoria));

		when(categoriaRepo.existsById(categoria.getId())).thenReturn(Boolean.TRUE);

		when(categoriaService.replace(categoria, request)).thenReturn(categoria);
		
		when(categoriaRepo.save(categoriaAtt)).thenReturn(categoriaAtt);
	}

}
