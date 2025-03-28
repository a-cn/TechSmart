package com.techsmart.repository;

import com.techsmart.dto.PerguntaSegurancaDTO;
import com.techsmart.model.PerguntaSeguranca;
import com.techsmart.model.Usuario;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
 
	Optional<Usuario> findByCpfCnpj(String cpfCnpj);
	Optional<Usuario> findByEmail(String email);
	
	@Query("""
			SELECT new com.techsmart.dto.PerguntaSegurancaDTO(
				ps.pergunta
			)
			FROM
				Usuario u
				JOIN u.perguntaSeguranca ps
			WHERE
				u.email = :login
			""")
	Optional<PerguntaSegurancaDTO> buscarPerguntaPorLogin(@Param("login") String login);
}
