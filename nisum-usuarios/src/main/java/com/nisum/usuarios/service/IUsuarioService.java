package com.nisum.usuarios.service;

import com.nisum.usuarioscommons.models.entity.Usuario;


public interface IUsuarioService {
	
	public Usuario registrarUsuario(Usuario usuario);
	
	public void fechaIngreso(Long id);
	
	public Usuario buscarUsuario(String usuario);
	

	

}
