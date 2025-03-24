package com.techsmart.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.techsmart.dto.UsuarioDTO;
import com.techsmart.model.Usuario;
import com.techsmart.repository.UsuarioRepository;
import com.techsmart.service.UsuarioService;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {

    private final UsuarioService usuarioService;
    
    public UsuarioController(UsuarioService usuarioService) {
		this.usuarioService = usuarioService;
    }
	
    @GetMapping
    public String carregaPagina(Model model) {
    	return "pages/cadastro-usuario";
    }
    
    /*
    @GetMapping
    public String listarUsuarios(Model model) {
        List<UsuarioDTO> usuariosDTO = usuarioService.listarUsuarios();
        model.addAttribute("usuarios", usuariosDTO);
        return "pages/lista-usuario";
    }
    
    @GetMapping("/{cpfCnpj}")
    public String detalharUsuario(@PathVariable("cpfCnpj") String cpfCnpj, Model model) {
        Optional<UsuarioDTO> usuarioDTO = usuarioService.buscarUsuarioPorCpfCnpj(cpfCnpj);
        if (usuarioDTO.isEmpty()) {
            return "redirect:/usuarios";
        }
        model.addAttribute("usuarioDTO", usuarioDTO.get());
        return "pages/detalhe-usuario";
    }
    */
}