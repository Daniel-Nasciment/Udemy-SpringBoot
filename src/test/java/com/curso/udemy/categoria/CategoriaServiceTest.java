package com.curso.udemy.categoria;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class CategoriaServiceTest {

	@InjectMocks
	private CategoriaService categoriaService;

	@Test
	public void deveConverterObj() {

		Categoria categoria = new Categoria(1L, "Antes");

		CategoriaRequest request = new CategoriaRequest();
		request.setNome("Depois");

		assertEquals(categoria.getNome(), String.valueOf("Antes"));

		categoriaService.replace(categoria, request);

		assertEquals(request.getNome(), String.valueOf("Depois"));
		assertEquals(categoria.getNome(), String.valueOf("Depois"));

	}

	@Test
	public void serviceTest() {
		
		String var = categoriaService.criandoRegraQualquer();
		
		assertEquals(var, "Criando uma regra...");
		
	}
	
}
