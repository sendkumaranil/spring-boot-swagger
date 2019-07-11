package com.springboot.swagger.example.exception.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.springboot.swagger.example.exception.MyResponse;
import com.springboot.swagger.example.exception.ResourceNotFoundException;
import com.springboot.swagger.example.exception.SystemException;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(value=SystemException.class)
	public ResponseEntity<MyResponse> handleSystemException(SystemException exp, WebRequest request){
		MyResponse errResponse=new MyResponse();
		errResponse.setErrorcode(500);
		errResponse.setErrormessage("Internal Server Error Occurred::"+exp.getMessage());
		
		return new ResponseEntity<MyResponse>(errResponse,HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(value=ResourceNotFoundException.class)
	public ResponseEntity<MyResponse> handleResourceNotFoundException(ResourceNotFoundException exp,WebRequest request){
		MyResponse errResponse=new MyResponse();
		errResponse.setErrorcode(404);
		errResponse.setErrormessage("Resource Not Found::"+exp.getMessage());
		
		return new ResponseEntity<MyResponse>(errResponse,HttpStatus.NOT_FOUND);
	}
}
