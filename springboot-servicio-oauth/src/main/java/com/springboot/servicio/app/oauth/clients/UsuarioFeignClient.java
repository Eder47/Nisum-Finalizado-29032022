package com.springboot.servicio.app.oauth.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.nisum.usuarioscommons.models.entity.Usuario;


@FeignClient(name = "servicios-usuarios")
public interface UsuarioFeignClient {

	@GetMapping("/fecha-ingreso/{id}")
	public void fechaIngreso(@PathVariable Long id);
	
	@GetMapping("/buscar-usuario/{usuario}")
	public Usuario buscarUsuario(@PathVariable String usuario);
	
	

}
