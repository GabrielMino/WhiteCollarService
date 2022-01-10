package com.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice()
public class GlobalExceptions {

	@ExceptionHandler(CapacityReached.class)
	public ResponseEntity<ErrorObject> handleCapacityReachedException(CapacityReached ex){
		ErrorObject eObject = new ErrorObject();
		eObject.setStatusCode(HttpStatus.BAD_REQUEST.value());
		eObject.setMessage(ex.getMessage());
		eObject.setTimestamp(System.currentTimeMillis());
		return new ResponseEntity<ErrorObject>(eObject, HttpStatus.BAD_REQUEST);

	}
	
	@ExceptionHandler(ResourceNotFound.class)
	public ResponseEntity<ErrorObject> handleResourceNotFoundException( ResourceNotFound ex){
		ErrorObject eObject = new ErrorObject();
		eObject.setStatusCode(HttpStatus.NOT_FOUND.value());
		eObject.setMessage(ex.getMessage());
		eObject.setTimestamp(System.currentTimeMillis());
		return new ResponseEntity<ErrorObject>(eObject, HttpStatus.NOT_FOUND);

	}



}

/*
@ControllerAdvice()
public class GlobalException{

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ErrorObject>  handleResourceNotFoundException (ResourceNotFoundException ex) {
		ErrorObject eObject = new ErrorObject();
		eObject.setStatusCode(HttpStatus.NOT_FOUND.value());
		eObject.setMessage(ex.getMessage());
		eObject.setTimestamp(System.currentTimeMillis());
		return new ResponseEntity<ErrorObject>(eObject, HttpStatus.NOT_FOUND);

*/