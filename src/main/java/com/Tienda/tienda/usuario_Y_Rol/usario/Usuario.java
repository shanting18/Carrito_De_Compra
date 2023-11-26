package com.Tienda.tienda.usuario_Y_Rol.usario;

import com.Tienda.tienda.usuario_Y_Rol.rol.Rol;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Set;

@Entity(name = "Usuario")
@Table(name = "usuarios")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Setter
@Getter
public class Usuario  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank
    @Size(max = 30)
    private String username;

    @NotBlank
    private String password;

    @NotBlank
    @Email
    @Size(max = 80)
    private  String email;

    // set no permite terner elementos duplicados
    @ManyToMany(fetch = FetchType.EAGER, targetEntity = Rol.class, cascade = CascadeType.PERSIST)
    @JoinTable(name = "usuario_rol", joinColumns = @JoinColumn(name = "Usuario_id"), inverseJoinColumns = @JoinColumn(name = "Rol_id"))
    private Set<Rol> roles;

}
