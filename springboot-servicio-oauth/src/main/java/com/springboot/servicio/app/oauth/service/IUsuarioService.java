package com.springboot.servicio.app.oauth.service;
import com.nisum.usuarioscommons.models.entity.Usuario;

public interface IUsuarioService {
	
	public Usuario findByUsername(String usuario);

}
