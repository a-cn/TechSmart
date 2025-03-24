package com.techsmart.repository;

import com.techsmart.model.Usuario;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

	Optional<Usuario> findByCpfCnpj(String cpfCnpj);
}
