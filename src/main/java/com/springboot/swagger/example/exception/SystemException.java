package com.springboot.swagger.example.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class SystemException extends Exception {

	private static final long serialVersionUID = -1368569545307072759L;
	
	
	public SystemException() {
		super();
	}

	public SystemException(String message) {
		super(message);
	}

}
