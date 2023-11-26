package com.Tienda.tienda.productos;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "Producto")
@Table(name = "productos")
@AllArgsConstructor
@NoArgsConstructor
@Setter @Getter
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank
    private String nombre;

    @NotNull
    private Double precio;

    @NotNull
    private  int cantidad;

    @NotBlank
    private String descripcion;

    @NotBlank
    private  String categoria;

}
