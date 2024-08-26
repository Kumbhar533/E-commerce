package com.ms.product.service.exception;

import java.util.HashMap;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import jakarta.persistence.EntityNotFoundException;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(ProductPurchaseException.class)
	public ResponseEntity<String> handleCustomerNotFound(final ProductPurchaseException exception) {

		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exception.getMessage());
	}

	@ExceptionHandler(EntityNotFoundException.class)
	public ResponseEntity<String> handleCustomerNotFound(final EntityNotFoundException exception) {

		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exception.getMessage());
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ErrorResponse> handleArgumentException(final MethodArgumentNotValidException ex) {

		var errors = new HashMap<String, String>();

		ex.getBindingResult().getAllErrors().forEach(error -> {
			var fieldError = ((FieldError) error).getField();
			var errorMessage = error.getDefaultMessage();

			errors.put(fieldError, errorMessage);
		});

		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorResponse(errors));

	}

}
