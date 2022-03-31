package com.nisum.usuarios.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nisum.usuarios.service.IUsuarioService;
import com.nisum.usuarios.utils.ExcepcionesEmail;
import com.nisum.usuarioscommons.models.entity.Usuarios;


@RestController
public class UsuariosController {
	
	@Autowired
	IUsuarioService iUsuarioService;

	@PostMapping("registrar")
	public ResponseEntity<Usuarios> actualizarUsuario(@RequestBody @Valid  Usuarios user) throws ExcepcionesEmail {
		Usuarios registro = iUsuarioService.registrarUser(user);
		return ResponseEntity.status(HttpStatus.OK).body(registro);
		
	}
	
	@GetMapping("/fecha-ingreso/{id}")
	public void fechaIngreso(@PathVariable Long id) {
		 iUsuarioService.fechaIngreso(id);
		
	}

}
