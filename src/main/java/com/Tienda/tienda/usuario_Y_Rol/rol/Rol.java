package com.Tienda.tienda.usuario_Y_Rol.rol;

import jakarta.persistence.*;
import lombok.*;

@Entity(name = "Rol")
@Table(name = "roles")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Setter
@Getter
public class Rol {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Enumerated(EnumType.STRING)
    private Roles nombre;


}
