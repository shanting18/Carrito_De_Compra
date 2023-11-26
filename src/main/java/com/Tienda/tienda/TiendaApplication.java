package com.Tienda.tienda;

import com.Tienda.tienda.usuario_Y_Rol.rol.Rol;
import com.Tienda.tienda.usuario_Y_Rol.rol.Roles;
import com.Tienda.tienda.usuario_Y_Rol.usario.Usuario;
import com.Tienda.tienda.usuario_Y_Rol.usario.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Set;

@SpringBootApplication
public class TiendaApplication {

	public static void main(String[] args) {
		SpringApplication.run(TiendaApplication.class, args);
	}

//	@Autowired
//	PasswordEncoder passwordEncoder;
//
//	@Autowired
//	UsuarioRepository usuarioRepository;
//
//	@Bean
//	CommandLineRunner init() {
//		return args -> {
//
//			Usuario usuario = Usuario.builder()
//					.email("santiago@mail.com")
//					.username("santiago")
//					.password(passwordEncoder.encode("1234"))
//					.roles(Set.of(Rol.builder()
//							.nombre(Roles.valueOf(Roles.ADMIN.name()))
//							.build()))
//					.build();
//			usuarioRepository.save(usuario);
//		};
//	}
}