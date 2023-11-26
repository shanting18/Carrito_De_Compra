package com.Tienda.tienda.productos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
public class ProductoService {

    private final  ProductoReposytory productoReposytory;
    @Autowired
    public ProductoService(ProductoReposytory productoReposytory) {
        this.productoReposytory = productoReposytory;
    }

    public Producto  guardarProducto(Producto producto){
        this.productoReposytory.save(producto);
        return producto;
    }

    public List<Producto> listarProductos(){
        return this.productoReposytory.findAll();
    }

    public List<Producto> obtenerProductosRelacionados(String categoria, long id){
        List<Producto> listaDeProductos =
                this.productoReposytory.findByCategoriaAndIdNot(categoria,id);
        List<Producto> randomProductos = new ArrayList<>();
        Random random = new Random();
        for(int i = 0; i < 2; i++){
            int randomIndex = random.nextInt(listaDeProductos.size());
            randomProductos.add(listaDeProductos.get(randomIndex));
            listaDeProductos.remove(randomIndex);
        }
        return randomProductos;
    }

    public Producto obtenerProductoPorId(long id){
        Optional<Producto> producto = productoReposytory.findById(id);
        return producto.orElse(null);
    }

    public void eliminarProductoPorId(Long id) {
        productoReposytory.deleteById(id);
    }
}
