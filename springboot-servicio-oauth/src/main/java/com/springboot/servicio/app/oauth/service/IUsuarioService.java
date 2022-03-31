package com.springboot.servicio.app.oauth.service;
import com.nisum.usuarioscommons.models.entity.Usuarios;

public interface IUsuarioService {
	
	public Usuarios findByUsername(String nombre);

}
