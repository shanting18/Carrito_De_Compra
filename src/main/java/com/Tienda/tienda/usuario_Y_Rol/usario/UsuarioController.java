package com.Tienda.tienda.usuario_Y_Rol.usario;

import com.Tienda.tienda.security.jwt.Jwt;
import com.Tienda.tienda.security.jwt.JwtUtils;
import com.Tienda.tienda.usuario_Y_Rol.rol.Rol;
import com.Tienda.tienda.usuario_Y_Rol.rol.Roles;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/auth")
public class UsuarioController {

    private final AuthenticationManager authenticationManager;
    private final PasswordEncoder passwordEncoder;
    private final UsuarioRepository usuarioRepository;
    private final JwtUtils jwtUtils;

    @Autowired
    public UsuarioController(AuthenticationManager authenticationManager, PasswordEncoder passwordEncoder, UsuarioRepository usuarioRepository, JwtUtils jwtUtils) {
        this.authenticationManager = authenticationManager;
        this.passwordEncoder = passwordEncoder;
        this.usuarioRepository = usuarioRepository;
        this.jwtUtils = jwtUtils;
    }

    @PostMapping("/login")
    public Jwt login(@Valid @RequestBody LoginUser loginUser){
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginUser.getUsername(), loginUser.getPassword()));
        Usuario user = (Usuario) usuarioRepository.findByUsername(loginUser.getUsername()).orElseThrow();
        String token=jwtUtils.generateToken(user.getUsername());
        return Jwt.builder()
                .token(token)
                .build();
    }

    @PostMapping("/registrar")
    public ResponseEntity<?> registrar(@Valid @RequestBody CreateUserDTO createUserDTO){

        Set<Rol> roles = createUserDTO.getRoles().stream()
                .map(role -> Rol.builder()
                        .nombre(Roles.valueOf(role))
                        .build())
                .collect(Collectors.toSet());

        Usuario usuario = Usuario.builder()
                .username(createUserDTO.getUsername())
                .password(passwordEncoder.encode(createUserDTO.getPassword()))
                .email(createUserDTO.getEmail())
                .roles(roles)
                .build();

        usuarioRepository.save(usuario);

        return ResponseEntity.ok(usuario);
    }

}

