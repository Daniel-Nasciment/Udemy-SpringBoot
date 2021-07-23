package com.curso.udemy.util;

import java.time.LocalDateTime;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class IdNotFoundExceptionHandler {

	private final Logger logger = LoggerFactory.getLogger(IdNotFoundExceptionHandler.class);

	@ExceptionHandler(IdNotFoundException.class)
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	public IdNotFoundDetails verifyId(HttpServletRequest req, IdNotFoundException ex) {

		logger.error("Id não encontrado.");
		
		return new IdNotFoundDetails(
				ex.getMessage(),
				HttpStatus.BAD_REQUEST.value(),
				req.getRequestURI(),
				LocalDateTime.now()
				);
		
	}

}
