package com.techsmart.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.techsmart.model.Usuario;

public interface FornecedorRepository extends JpaRepository<Usuario, Integer> {

}
