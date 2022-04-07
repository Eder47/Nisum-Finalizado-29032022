package com.nisum.usuarios.repository;

import java.time.LocalDateTime;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.nisum.usuarioscommons.models.entity.Usuario;

public interface IUsuarioIngreso extends JpaRepository<Usuario, Long>{
	
	@Modifying
	@Query("update Usuario u set u.ultimoIngreso = ?1 where u.id =?2")
	public  void  ultimoIngreso(LocalDateTime fecha, Long id);
	
	@Query("select u from Usuario u where u.email =?1")
	public  Usuario  buscarEmail(String email);
	
	@Query("select u from Usuario u where u.username =?1")
	public Usuario buscarUsuario(@Param("nombre") String nombre);

}
