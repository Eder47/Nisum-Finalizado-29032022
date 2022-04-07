package com.nisum.usuarios.service.Impl;

import java.time.LocalDateTime;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.nisum.usuarios.repository.IUsuario;
import com.nisum.usuarios.service.IUsuarioService;
import com.nisum.usuarios.utils.ExcepcionEmailExiste;
import com.nisum.usuarios.utils.ExcepcionUsuarioExiste;
import com.nisum.usuarios.utils.ExcepcionesEmail;
import com.nisum.usuarios.utils.Tiempo;
import com.nisum.usuarios.utils.Validaciones;
import com.nisum.usuarioscommons.models.entity.Usuario;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UsuariosServiciosImpl implements IUsuarioService {

	@Autowired
	Tiempo tiempo;

	@Autowired
	IUsuario iUsuario;

	@Autowired
	Validaciones validaciones;

	@Transactional
	public Usuario registrarUsuario(Usuario usuario) {
		boolean email = validaciones.validarEmail(usuario.getEmail());
		Usuario emailUsuario = iUsuario.buscarEmail(usuario.getEmail());
		Usuario usuarioExiste = iUsuario.buscarUsuario(usuario.getUsername());

		if (usuarioExiste != null) {
			throw new ExcepcionUsuarioExiste("500", HttpStatus.BAD_REQUEST, "El usuario ya existe");
		}

		if (!email) {
			throw new ExcepcionesEmail("500", HttpStatus.BAD_REQUEST, "El email no es valido");
		}

		if (emailUsuario != null) {
			throw new ExcepcionEmailExiste("500", HttpStatus.INTERNAL_SERVER_ERROR, "El email ya existe en BD");
		}

		try {
			usuario.setFechaCreacion(tiempo.getLocalDateTime());
			iUsuario.save(usuario);
		} catch (Exception e) {
			log.info(e.getMessage());
		}
		return usuario;
	}

	@Transactional
	public void fechaIngreso(Long id) {
		LocalDateTime fecha = LocalDateTime.now();
		try {
			iUsuario.ultimoIngreso(fecha, id);
		} catch (Exception e) {
			log.info(e.getMessage());
		}

	}

	@Override
	public Usuario buscarUsuario(String usuario) {
		return iUsuario.buscarUsuario(usuario);
	}
}
