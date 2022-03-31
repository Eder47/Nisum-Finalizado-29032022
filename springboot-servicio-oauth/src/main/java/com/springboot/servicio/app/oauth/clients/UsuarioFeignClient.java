package com.springboot.servicio.app.oauth.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.nisum.usuarioscommons.models.entity.Usuarios;


@FeignClient(name = "servicios-usuarios")
public interface UsuarioFeignClient {
	
	@GetMapping("/usuarios/search/buscar-username")
	public Usuarios findByUsername(@RequestParam String nombre);
	
	@GetMapping("/fecha-ingreso/{id}")
	public void fechaIngreso(@PathVariable Long id);
	
	

}
