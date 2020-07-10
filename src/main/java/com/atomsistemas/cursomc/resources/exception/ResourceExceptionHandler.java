package com.atomsistemas.cursomc.resources.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.atomsistemas.cursomc.services.execptions.ObjectNotFoundExecption;

@ControllerAdvice
public class ResourceExceptionHandler {
  
	@ExceptionHandler(ObjectNotFoundExecption.class)
	public ResponseEntity<StandardError> objectNotFound(ObjectNotFoundExecption e, HttpServletRequest request){
		
		 StandardError err = new StandardError(HttpStatus.NOT_FOUND.value(), e.getMessage(), System.currentTimeMillis());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);
	}
}
