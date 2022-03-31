package com.nisum.usuarios.service.Impl;

import java.time.LocalDateTime;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.nisum.usuarios.repository.IUsuarioIngreso;
import com.nisum.usuarios.repository.UsuarioRepository;
import com.nisum.usuarios.service.IUsuarioService;
import com.nisum.usuarios.utils.ExcepcionEmailExiste;
import com.nisum.usuarios.utils.ExcepcionesEmail;
import com.nisum.usuarios.utils.Tiempo;
import com.nisum.usuarios.utils.Validaciones;
import com.nisum.usuarioscommons.models.entity.Usuarios;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UsuariosServiciosImpl implements IUsuarioService {

	@Autowired
	UsuarioRepository usuarioDao;

	@Autowired
	Tiempo tiempo;

	@Autowired
	IUsuarioIngreso iUsuarioIngreso;

	@Autowired
	Validaciones validaciones;

	@Transactional
	public Usuarios registrarUser(Usuarios usuario) {
		Usuarios user = null;
		Usuarios datos = null;
		LocalDateTime fechaCreacion = null;
		boolean email = validaciones.validarEmail(usuario.getEmail());
		Usuarios buscarEmail = iUsuarioIngreso.buscarEmail(usuario.getEmail());

		try {
			user = usuarioDao.findByUsername(usuario.getUsername());
			log.info("Ver si el usuario existe: " + user);
			fechaCreacion = user.getFechaCreacion();
		} catch (Exception e) {
			log.info(e.getMessage());
		}

		if (!email) {
			throw new ExcepcionesEmail("500", HttpStatus.BAD_REQUEST, "El email no es valido");
		}

		if (buscarEmail != null) {
			throw new ExcepcionEmailExiste("500", HttpStatus.INTERNAL_SERVER_ERROR, "El email ya existe en BD");
		}

		try {
			if (user != null) {
				user = usuario;
				user.setFechaModificacion(tiempo.getLocalDateTime());
				user.setFechaCreacion(fechaCreacion);
				usuarioDao.save(user);
				return user;
			} else {
				usuario.setFechaCreacion(tiempo.getLocalDateTime());
				datos = usuarioDao.save(usuario);
			}

		} catch (Exception e) {
			log.info(e.getMessage());
		}
		return datos;
	}

	@Transactional
	public void fechaIngreso(Long id) {
		LocalDateTime fecha = LocalDateTime.now();
		try {
			iUsuarioIngreso.ultimoIngreso(fecha, id);
		} catch (Exception e) {
			log.info(e.getMessage());
		}

	}
}
