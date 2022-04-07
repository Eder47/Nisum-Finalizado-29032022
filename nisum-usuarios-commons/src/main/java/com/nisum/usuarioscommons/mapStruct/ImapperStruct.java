package com.nisum.usuarioscommons.mapStruct;

import org.mapstruct.Mapper;

import com.nisum.usuarioscommons.Dto.UsuarioDto;
import com.nisum.usuarioscommons.models.entity.Usuario;

@Mapper(componentModel = "spring")
public interface ImapperStruct {
	
	Usuario usuarioDtoToUsuarios(UsuarioDto usuarioDto);
	UsuarioDto usuariosToUsuarioDto(Usuario usuarios);

}
