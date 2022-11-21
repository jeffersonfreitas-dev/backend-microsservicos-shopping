package dev.jefferson.shoppingapi.exceptions;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import dev.jefferson.shoppingclient.exceptions.ErrorDTO;
import dev.jefferson.shoppingclient.exceptions.ProductNotFoundException;
import dev.jefferson.shoppingclient.exceptions.UserNotFoundException;

@RestControllerAdvice
public class ShoppingControllerAdvice {
	
	
	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler(UserNotFoundException.class)
	public ErrorDTO handleUserNotFoundException(UserNotFoundException ex) {
		return new ErrorDTO(HttpStatus.NOT_FOUND.value(), ex.getMessage(), new Date());
	}
	
	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler(ProductNotFoundException.class)
	public ErrorDTO handleProductNotFoundException(ProductNotFoundException ex) {
		return new ErrorDTO(HttpStatus.NOT_FOUND.value(), ex.getMessage(), new Date());
	}

}
