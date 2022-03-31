package com.nisum.usuarios.utils;

import org.springframework.http.HttpStatus;

import lombok.Data;

@Data
public class ExcepcionesEmail extends RuntimeException{
	
    private String code;
    private HttpStatus status;
	public ExcepcionesEmail(String code, HttpStatus status, String message) {
		super(message);
        this.code = code;
        this.status = status;
	}

}
