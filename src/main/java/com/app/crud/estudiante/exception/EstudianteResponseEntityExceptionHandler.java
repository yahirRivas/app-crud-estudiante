package com.app.crud.estudiante.exception;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.app.crud.estudiante.util.Utilitario;


@RestControllerAdvice
public class EstudianteResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

	@Autowired
	private Utilitario utilitario;

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {

		List<MessageResponse.Field> fieldErrors =  ex.getBindingResult().getFieldErrors().stream()
											.map(x -> MessageResponse.Field.builder()
															.name(x.getField())
															.message(x.getDefaultMessage()).build())
											.collect(Collectors.toList());

		MessageResponse messageError = MessageResponse.builder()
				 .message(fieldErrors)
				 .build();
		  
	    return new ResponseEntity<>(messageError, headers, status);
	}

	@ExceptionHandler(SQLIntegrityConstraintViolationException.class)
	public ResponseEntity<MessageResponse> handleSQLIntegrityConstraintViolationException(SQLIntegrityConstraintViolationException ex,
																		HttpServletRequest request) {
		
			String emailUnique = utilitario.getMessage("app.estudiante.sql.constrains.unique.email.name");
			MessageResponse.MessageResponseBuilder messageError = MessageResponse.builder();
			if(ex.getMessage().contains(emailUnique)) {
				messageError = messageError.message(utilitario.getMessage("app.estudiante.sql.constrains.unique.email.message"));
			} else {
				messageError = messageError.message(ex.getMessage());
			}
			
		 return new ResponseEntity<>(messageError.build(), HttpStatus.BAD_REQUEST);
	 }
	
	
	@Override
	protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		
		 MessageResponse messageError = MessageResponse.builder()
				 .message(ex.getMessage())
				 .build();
		  
	    return new ResponseEntity<>(messageError, new HttpHeaders(), HttpStatus.METHOD_NOT_ALLOWED);
	}
}