package com.curso.udemy.categoria;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CategoriaRequestTest {

	@Test
	public void teste() {

		CategoriaRequest request = new CategoriaRequest();

		Assert.assertEquals(Boolean.TRUE, validarNuloOrVazio(request.setNome("")));
		Assert.assertEquals(Boolean.TRUE, validarNuloOrVazio(request.setNome(null)));

	}

	private Boolean validarNuloOrVazio(String valor) {
		if (valor == null || valor.isEmpty()) {
			return true;
		}
		return false;
	}

}
