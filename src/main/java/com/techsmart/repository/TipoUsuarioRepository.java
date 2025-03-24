package com.techsmart.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.techsmart.model.TipoUsuario;

public interface TipoUsuarioRepository extends JpaRepository<TipoUsuario, Integer> {
}
