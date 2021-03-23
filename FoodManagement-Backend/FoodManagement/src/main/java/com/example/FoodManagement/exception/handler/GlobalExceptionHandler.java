package com.example.FoodManagement.exception.handler;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(FoodManagementException.class)
	public ResponseEntity<CustomErrorResponse> handleException(Exception ex) {

		CustomErrorResponse errors = new CustomErrorResponse();
		errors.setTimestamp(LocalDateTime.now());
		errors.setError(ex.getMessage());
		errors.setStatus(600);

		return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);

	}

}
