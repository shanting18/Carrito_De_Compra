package com.Tienda.tienda.carritos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarritoRepository extends JpaRepository<Carrito, Long> {

    List<Carrito> findByClienteUsername(String username);
    long countByClienteId(long clienteId);

    long deleteByClienteId(long clienteId);
}
