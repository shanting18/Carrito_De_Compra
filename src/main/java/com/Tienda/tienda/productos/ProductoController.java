package com.Tienda.tienda.productos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/productos")
public class ProductoController {

    private final ProductoService productoService;
    @Autowired
    public ProductoController(ProductoService productoService) {
        this.productoService = productoService;
    }

    @GetMapping("/lista")
    public List<Producto> ListaDeProductos(){
        return this.productoService.listarProductos();
    }

    @GetMapping("/categoria/{categoria}/{id}")
    public List<Producto> listaProductosRelacionados(@PathVariable("categoria") String categoria, @PathVariable("id") long id){
        return  this.productoService.obtenerProductosRelacionados(categoria, id);

    }

    @PostMapping("/agregar")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Producto> CrearProducto(@RequestBody Producto producto){
        productoService.guardarProducto(producto);
        return ResponseEntity.ok(producto);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<String> editarProducto(@PathVariable("id") long id, @RequestBody Producto productoActualizado){

        Producto productoExistente = productoService.obtenerProductoPorId(id);

        if (productoExistente == null){
            return ResponseEntity.notFound().build();
        }
        productoExistente.setNombre(productoActualizado.getNombre());
        productoExistente.setCategoria(productoActualizado.getCategoria());
        productoExistente.setDescripcion(productoActualizado.getDescripcion());
        productoExistente.setPrecio(productoActualizado.getPrecio());
        productoExistente.setCantidad(productoActualizado.getCantidad());

        productoService.guardarProducto(productoExistente);

        return ResponseEntity.ok("Producto actualizado con exito");
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<String> eliminarProducto(@PathVariable("id") long id){
        productoService.eliminarProductoPorId(id);

        return  ResponseEntity.ok("Producto eliminado con exito");
    }
}
