package com.nisum.usuarioscommons.models.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "telefono")
@Getter
@Setter
public class Telefono implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(length = 10)
	private Integer number;
	
	private Integer citycode;
	
	private Integer contrycode;
	
	private static final long serialVersionUID = -5408244828426149639L;

}
