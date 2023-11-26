package com.Tienda.tienda.carritos;

import com.Tienda.tienda.productos.ProductoReposytory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarritoService {

    private  final CarritoRepository carritoRepository;
    private final ProductoReposytory productoReposytory;
    private final List<String> productosEnCarrito = new ArrayList<>();


    @Autowired
    public CarritoService(CarritoRepository carritoRepository, ProductoReposytory productoReposytory) {
        this.carritoRepository = carritoRepository;
        this.productoReposytory = productoReposytory;
    }

    public List<Carrito> listaPorCliente(String username){
    return this.carritoRepository.findByClienteUsername(username);
    }

    public long LimpiarCarrito(long clienteId){
    return this.carritoRepository.deleteByClienteId(clienteId);
    }

    public void eliminarProducto(long id){
    this.carritoRepository.deleteById(id);
    }

    public void agregarProductoAlCarrito(Carrito carrito){
        carrito.producto = productoReposytory.findByNombre(carrito.producto.getNombre());
        carritoRepository.save(carrito);

        if (carrito.producto != null) {
            añadirProductoAlCarrito(carrito.producto.getNombre());
        }
    }
    public void añadirProductoAlCarrito(String nombreProducto) {
        productosEnCarrito.add(nombreProducto);
    }


    public long obtenerCantidad(long clienteId){
        return this.carritoRepository.countByClienteId(clienteId);
    }
}
