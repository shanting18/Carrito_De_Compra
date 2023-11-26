package com.Tienda.tienda.carritos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;


@RestController
@RequestMapping("/carritos")
public class CarritoController {

    private final CarritoService carritoService;

    @Autowired
    public CarritoController(CarritoService carritoService) {
        this.carritoService = carritoService;
    }

    @GetMapping
    public List<Carrito> listaDeCarritoPorCliente() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal instanceof UserDetails) {
            UserDetails userDetails = (UserDetails) principal;
            String username = userDetails.getUsername();
            return carritoService.listaPorCliente(username);
        } else if (principal instanceof String) {
            // Manejar el caso en que el principal es un String (posiblemente el nombre de usuario)
            String username = (String) principal;
            return carritoService.listaPorCliente(username);
        } else {
            // Manejar otros casos según sea necesario
            return Collections.emptyList();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Long> cuentaPorCliente(@PathVariable("id") long id){
        return ResponseEntity.ok(carritoService.obtenerCantidad(id));
    }

    @PostMapping
    public ResponseEntity<Object> agregarProducto(@RequestBody Carrito carrito){
        carritoService.agregarProductoAlCarrito(carrito);
        return ResponseEntity.ok("Producto agregado al carrito: " + carrito.producto.getNombre());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarProducto(@PathVariable("id") long id){

        carritoService.eliminarProducto(id);
        return ResponseEntity.ok("Producto eliminado del carrito con exito");
    }
}
