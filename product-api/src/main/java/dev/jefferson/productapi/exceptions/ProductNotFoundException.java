package dev.jefferson.productapi.exceptions;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import dev.jefferson.shoppingclient.exceptions.CategoryNotFoundException;
import dev.jefferson.shoppingclient.exceptions.ErrorDTO;

public class ProductNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler(ProductNotFoundException.class)
	public ErrorDTO handlerProductNotFoundException(ProductNotFoundException ex) {
		return new ErrorDTO(HttpStatus.NOT_FOUND.value(), ex.getMessage(), new Date());
	}
	
	
	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler(CategoryNotFoundException.class)
	public ErrorDTO handlerCategoryNotFoundException(CategoryNotFoundException ex) {
		return new ErrorDTO(HttpStatus.NOT_FOUND.value(), ex.getMessage(), new Date());
	}
	
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ErrorDTO handlerMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
		StringBuilder sb = new StringBuilder("Valor inválido para o(s) campo(s):");
		
		for(FieldError fieldError : ex.getBindingResult().getFieldErrors()) {
			sb.append("; ");
			sb.append(fieldError.getField());
		}
		
		return new ErrorDTO(HttpStatus.BAD_REQUEST.value(), sb.toString(), new Date());
	}
	

}
