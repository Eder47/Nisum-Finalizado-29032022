package com.nisum.usuarios;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@EntityScan({"com.nisum.usuarioscommons.models.entity"})
@SpringBootApplication
public class NisumUsuariosApplication {

	public static void main(String[] args) {
		SpringApplication.run(NisumUsuariosApplication.class, args);
	}

}
