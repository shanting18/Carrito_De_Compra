package com.Tienda.tienda.productos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductoReposytory extends JpaRepository<Producto, Long> {

    List<Producto> findByCategoriaAndIdNot(String categoria, long Id);

    Producto findByNombre(String nombre);
}
