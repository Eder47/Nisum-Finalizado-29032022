package com.nisum.usuarios.service;

import com.nisum.usuarios.utils.ExcepcionesEmail;
import com.nisum.usuarioscommons.models.entity.Usuarios;


public interface IUsuarioService {
	
	public Usuarios registrarUser(Usuarios usuario);
	
	public void fechaIngreso(Long id);
	

	

}
