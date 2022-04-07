package com.nisum.usuarios.utils;

import org.springframework.http.HttpStatus;

import lombok.Data;

@Data
public class ExcepcionUsuarioExiste extends RuntimeException {

	private String code;
	private HttpStatus status;
	public ExcepcionUsuarioExiste(String code, HttpStatus status, String message) {
		super(message);
		this.code = code;
		this.status = status;
	}
}
