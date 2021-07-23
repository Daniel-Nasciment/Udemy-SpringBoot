package com.curso.udemy.util;

import java.util.NoSuchElementException;

public class IdNotFoundException extends NoSuchElementException {

	public IdNotFoundException (String message) {
		super(message);
	}
	
}
