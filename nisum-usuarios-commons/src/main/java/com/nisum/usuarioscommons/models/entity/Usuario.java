package com.nisum.usuarioscommons.models.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Email;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name = "usuarios")
@Getter
@Setter
public class Usuario implements Serializable{
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(unique = true, length = 20)
	private String username;
	
	@Column(length = 60)
	private String password;
	private Boolean enabled;
	private String nombre;
	private String apellido;
	
	@Email(message = "El email no es valido", regexp = "(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])")
	private String email;
	
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	@Column(name="fecha_hora_creacion")
	private LocalDateTime fechaCreacion;
	
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	@Column(name="fecha_hora_modificacion")
	private LocalDateTime fechaModificacion;
	
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	@Column(name="ultimo_ingreso")
	private LocalDateTime ultimoIngreso;
	
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "usuarios_roles", 
	joinColumns=@JoinColumn(name = "usuario_id"), inverseJoinColumns = @JoinColumn(name="role_id"),
	uniqueConstraints = {@UniqueConstraint(columnNames = {"usuario_id", "role_id"})})
	private List<Role> roles;
	

	@OneToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "usuario_telefonos", 
	joinColumns=@JoinColumn(name = "usuario_id"), inverseJoinColumns = @JoinColumn(name="telefono_id"),
	uniqueConstraints = {@UniqueConstraint(columnNames = {"usuario_id", "telefono_id"})})
	private List<Telefono> telefono;


	private static final long serialVersionUID = -5408244828426149639L;



}
