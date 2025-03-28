package com.techsmart.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.techsmart.model.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Integer>{

}
