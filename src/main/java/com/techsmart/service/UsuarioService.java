package com.techsmart.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.techsmart.dto.PerguntaSegurancaDTO;
import com.techsmart.dto.UsuarioDTO;
import com.techsmart.mapper.UsuarioMapper;
import com.techsmart.model.PerguntaSeguranca;
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

    public boolean validarLogin(String login, String senha) {
        Optional<Usuario> usuarioOpt = usuarioRepository.findByEmail(login);
        return usuarioOpt.isPresent() && usuarioOpt.get().getSenha().equals(senha);
    }
    
    public List<UsuarioDTO> listarUsuarios() {
        List<Usuario> usuarios = usuarioRepository.findAll();
        return usuarios.stream().map(usuarioMapper::toDto).toList();
    }
    
    public Optional<UsuarioDTO> buscarUsuarioPorCpfCnpj(String cpfCnpj) {
        return usuarioRepository.findByCpfCnpj(cpfCnpj)
                .map(usuarioMapper::toDto);
    }
    
    public PerguntaSegurancaDTO buscarPerguntaSegurancaPorLogin(String login){
    	return usuarioRepository.buscarPerguntaPorLogin(login).orElse(null);
    }

	public Usuario buscarPorLogin(String login) {
		return this.usuarioRepository.findByEmail(login).orElse(null);
	}
	
	public void atualizarSenha(String login, String novaSenha) {
	    Usuario usuario = usuarioRepository.findByEmail(login)
	        .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

	    usuario.setSenha(novaSenha);
	    usuarioRepository.save(usuario);
	}

}
