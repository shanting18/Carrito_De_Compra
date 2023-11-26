package com.Tienda.tienda.usuario_Y_Rol.usario;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {


   Optional<Usuario> findByUsername(String username);

    boolean existsByUsername(String username);

}
