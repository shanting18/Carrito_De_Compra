package com.Tienda.tienda.carritos;

import com.Tienda.tienda.productos.Producto;
import com.Tienda.tienda.usuario_Y_Rol.usario.Usuario;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.lang.NonNull;


@Entity(name = "Carrito")
@Table(name = "carritos")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Carrito {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    //para poder obtener el nombre del producto como clave primaria realize este codigo en la base de datos
    //CREATE INDEX idx_nombre ON productos (nombre);

    @ManyToOne(optional = false, cascade = CascadeType.DETACH, fetch = FetchType.EAGER)
    @JoinColumn(name = "producto_nombre", referencedColumnName = "nombre")
    Producto producto;

    @ManyToOne(optional = false, cascade = CascadeType.DETACH, fetch = FetchType.EAGER)
    Usuario cliente;

    @NonNull
    private  int cantidadEnCarrito;

}
