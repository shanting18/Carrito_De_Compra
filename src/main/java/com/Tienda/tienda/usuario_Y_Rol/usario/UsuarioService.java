package com.Tienda.tienda.usuario_Y_Rol.usario;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Transactional
public class UsuarioService {
    private final UsuarioRepository usuarioRepository;

    @Autowired
    public UsuarioService( UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public Optional<Usuario> getByUserName(String username){
        return usuarioRepository.findByUsername(username);
    }
    public boolean existByUserName(String userName){
        return usuarioRepository.existsByUsername(userName);
    }

}
