package com.nisum.usuarioscommons.mapStruct;

import org.mapstruct.Mapper;

import com.nisum.usuarioscommons.Dto.UsuarioDto;
import com.nisum.usuarioscommons.models.entity.Usuarios;

@Mapper(componentModel = "spring")
public interface ImapperStruct {
	
	Usuarios usuarioDtoToUsuarios(UsuarioDto usuarioDto);
	UsuarioDto usuariosToUsuarioDto(Usuarios usuarios);

}
