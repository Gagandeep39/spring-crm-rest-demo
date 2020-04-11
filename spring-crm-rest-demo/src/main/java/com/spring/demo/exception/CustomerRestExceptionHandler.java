/**
 * Gagandeep
 * 11:33:11 am
 * 11-Apr-2020
 */
package com.spring.demo.exception;

import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.spring.demo.entity.CustomErrorResponse;

/**
 * Error Handler class
 */
@ControllerAdvice
public class CustomerRestExceptionHandler {
	
	/**
	 * Handles customer not dound exceptoion
	 * @return ResponseEntity<CustomErrorResponse>
	 */
	@ExceptionHandler
	public ResponseEntity<CustomErrorResponse> handleCustomerNotFound(CustomerNotFoundException exception) {
		CustomErrorResponse response = new CustomErrorResponse();
		response.setMessage(exception.getMessage());
		response.setTimestamp(System.currentTimeMillis());
		response.setStatus(HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
	}
	
	/**
	 * Handles all form of Exception
	 * @return ResponseEntity<CustomErrorResponse>
	 */
	@ExceptionHandler
	public ResponseEntity<CustomErrorResponse> handleAllException(Exception exception) {
		CustomErrorResponse response = new CustomErrorResponse();
		response.setMessage(exception.getMessage());
		response.setTimestamp(System.currentTimeMillis());
		response.setStatus(HttpStatus.BAD_REQUEST.value());
		return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
	}

}
