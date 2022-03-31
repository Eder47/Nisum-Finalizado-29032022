package com.nisum.usuarios.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class Validaciones {

	public boolean validarEmail(String email) {
		boolean estado = false;
		Pattern pattern = Pattern.compile(
				"^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");

		Matcher mather = pattern.matcher(email);

		try {
			if (mather.find() == true) {
				estado = true;
			}
		} catch (Exception e) {
			log.info(e.getMessage());
		}
		return estado;
	}

}
