package com.nisum.usuarios.utils;

import org.springframework.http.HttpStatus;

import lombok.Data;

@Data
public class ExcepcionEmailExiste extends RuntimeException {

	private String code;
	private HttpStatus status;
	public ExcepcionEmailExiste(String code, HttpStatus status, String message) {
		super(message);
		this.code = code;
		this.status = status;
	}
}
