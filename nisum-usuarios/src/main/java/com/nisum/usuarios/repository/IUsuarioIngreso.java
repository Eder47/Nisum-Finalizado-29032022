package com.nisum.usuarios.repository;

import java.time.LocalDateTime;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.nisum.usuarioscommons.models.entity.Usuarios;

public interface IUsuarioIngreso extends JpaRepository<Usuarios, Long>{
	
	@Modifying
	@Query("update Usuarios u set u.ultimoIngreso = ?1 where u.id =?2")
	public  void  ultimoIngreso(LocalDateTime fecha, Long id);
	
	@Query("select u from Usuarios u where u.email =?1")
	public  Usuarios  buscarEmail(String email);

}
