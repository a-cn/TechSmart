package com.techsmart.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.techsmart.dto.UsuarioDTO;
import com.techsmart.mapper.UsuarioMapper;
import com.techsmart.model.Usuario;
import com.techsmart.repository.UsuarioRepository;

@Service
public class UsuarioService {

	private final UsuarioRepository usuarioRepository;
    private final UsuarioMapper usuarioMapper;

    public UsuarioService(UsuarioRepository usuarioRepository, UsuarioMapper usuarioMapper) {
        this.usuarioRepository = usuarioRepository;
        this.usuarioMapper = usuarioMapper;
    }

    public List<UsuarioDTO> listarUsuarios() {
        List<Usuario> usuarios = usuarioRepository.findAll();
        return usuarios.stream().map(usuarioMapper::toDto).toList();
    }
    
    public Optional<UsuarioDTO> buscarUsuarioPorCpfCnpj(String cpfCnpj) {
        return usuarioRepository.findByCpfCnpj(cpfCnpj)
                .map(usuarioMapper::toDto);
    }
}
