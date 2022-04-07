package com.nisum.usuarios.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.nisum.usuarios.Dto.ErrorDto;
import com.nisum.usuarios.utils.ExcepcionEmailExiste;
import com.nisum.usuarios.utils.ExcepcionUsuarioExiste;
import com.nisum.usuarios.utils.ExcepcionesEmail;


@RestControllerAdvice
public class ControllerAdvice {

    @ExceptionHandler(value = ExcepcionesEmail.class)
    public ResponseEntity<ErrorDto> businessExceptionHandler(ExcepcionesEmail ex){
    	ErrorDto error = ErrorDto.builder().code(ex.getCode()).message(ex.getMessage()).build();
        return new ResponseEntity<>(error, ex.getStatus());
    }
    
    @ExceptionHandler(value = ExcepcionEmailExiste.class)
    public ResponseEntity<ErrorDto> excepcionEmailExiste(ExcepcionEmailExiste ex){
    	ErrorDto error = ErrorDto.builder().code(ex.getCode()).message(ex.getMessage()).build();
        return new ResponseEntity<>(error, ex.getStatus());
    }
    
    @ExceptionHandler(value = ExcepcionUsuarioExiste.class)
    public ResponseEntity<ErrorDto> excepcionUsuarioExiste(ExcepcionUsuarioExiste ex){
    	ErrorDto error = ErrorDto.builder().code(ex.getCode()).message(ex.getMessage()).build();
        return new ResponseEntity<>(error, ex.getStatus());
    }


}
