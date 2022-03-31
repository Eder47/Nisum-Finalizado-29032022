package com.nisum.usuarios.utils;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

@Service
public class Tiempo {

	public static LocalDateTime getLocalDateTime() {
		return LocalDateTime.now();
	}
}
