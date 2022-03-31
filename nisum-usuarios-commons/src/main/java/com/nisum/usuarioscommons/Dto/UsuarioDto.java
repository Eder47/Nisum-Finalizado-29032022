package com.nisum.usuarioscommons.Dto;

import java.time.LocalDateTime;
import java.util.List;


import com.nisum.usuarioscommons.models.entity.Role;
import com.nisum.usuarioscommons.models.entity.Telefono;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioDto {
	private Long id;
	private String username;
	private String password;
	private Boolean enabled;
	private String nombre;
	private String apellido;
	private String email;
	private LocalDateTime fechaCreacion;
	private LocalDateTime fechaModificacion;
	private LocalDateTime ultimoIngreso;
	private List<Role> roles;
	private List<Telefono> telefono;


}

