package com.Tienda.tienda.usuario_Y_Rol.usario;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class LoginUser {

    @NotBlank
    private String username;
    @NotBlank
    private String password;
}
