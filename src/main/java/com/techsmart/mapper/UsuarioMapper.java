package com.techsmart.mapper;

import org.springframework.stereotype.Component;

import com.techsmart.dto.UsuarioDTO;
import com.techsmart.model.Usuario;

@Component
public class UsuarioMapper {
	
	public UsuarioDTO toDto(Usuario usuario) {
        UsuarioDTO dto = new UsuarioDTO();
        dto.setNome(usuario.getNome());
        dto.setCpfCnpj(usuario.getCpfCnpj());
        dto.setEmail(usuario.getEmail());
        dto.setNumPrincipal(usuario.getNumPrincipal());
        dto.setNumRecado(usuario.getNumRecado());

        if (usuario.getTipoUsuario() != null) {
            dto.setTipoUsuarioDescricao(usuario.getTipoUsuario().getDescricao());
        }

        if (usuario.getEndereco() != null) {
            String enderecoResumo = usuario.getEndereco().getLogradouro()
                    + ", " + usuario.getEndereco().getNumero();
            dto.setEnderecoResumo(enderecoResumo);
        }
        
        dto.setRespostaSeguranca(usuario.getRespostaSeguranca());

        return dto;
    }

    // opcional: método inverso
    public Usuario toEntity(UsuarioDTO dto) {
        Usuario usuario = new Usuario();
        usuario.setNome(dto.getNome());
        usuario.setCpfCnpj(dto.getCpfCnpj());
        usuario.setEmail(dto.getEmail());
        usuario.setNumPrincipal(dto.getNumPrincipal());
        return usuario;
    }
}
