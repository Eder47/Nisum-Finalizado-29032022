package com.springboot.servicio.app.oauth.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.nisum.usuarioscommons.models.entity.Usuarios;
import com.springboot.servicio.app.oauth.clients.UsuarioFeignClient;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class UsuarioService implements IUsuarioService, UserDetailsService {

	@Autowired
	UsuarioFeignClient client;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usuarios usuario = client.findByUsername(username);
		if (usuario == null) {
			log.info("Error en el login, No existe usuario '" + username + "' en el sistema");
			throw new UsernameNotFoundException(
					"Error en el login, No existe usuario '" + username + "' en el sistema");
		}
		List<GrantedAuthority> authorities = usuario.getRoles().stream()
				.map(role -> new SimpleGrantedAuthority(role.getNombre()))
				.peek(authority -> log.info("Role: " + authority.getAuthority()))
				.collect(Collectors.toList());
		log.info("Usuario autenticado: "+username);
		client.fechaIngreso(usuario.getId());
		return new User(usuario.getUsername(), usuario.getPassword(), usuario.getEnabled(), true, true, true, authorities);
	}

	@Override
	public Usuarios findByUsername(String username) {
		return client.findByUsername(username);
	}
	
	

}
