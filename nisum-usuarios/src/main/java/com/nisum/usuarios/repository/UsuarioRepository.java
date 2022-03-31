package com.nisum.usuarios.repository;


import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import com.nisum.usuarioscommons.models.entity.Usuarios;

@RepositoryRestResource(path="usuarios")
public interface UsuarioRepository extends PagingAndSortingRepository<Usuarios, Long>{

	@RestResource(path="buscar-username")
	public Usuarios findByUsername(@Param("nombre") String nombre);
	

}
