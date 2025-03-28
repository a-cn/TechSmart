package com.techsmart.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.techsmart.dto.LoginDTO;
import com.techsmart.service.UsuarioService;
import com.techsmart.util.HashUtil;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/")
public class LoginController {
	
	private final UsuarioService usuarioService;
	
	public LoginController(UsuarioService usuarioService) {
		this.usuarioService = usuarioService;
	}

	@GetMapping
	public String carregarPagina(Model model) {
	    model.addAttribute("loginDTO", new LoginDTO());
	    return "index";
	}
	
	@PostMapping("/login")
    public String realizarLogin(
    	@Valid @ModelAttribute("loginDTO") LoginDTO loginDTO, 
    	BindingResult result, 
    	Model model) {

        if (result.hasErrors()) {
            model.addAttribute("erro", "Dados inválidos!");
            return "index";
        }
        
        //Aplica criptografia na senha
        loginDTO.setSenha(HashUtil.sha1(loginDTO.getSenha()));

        boolean sucesso = usuarioService.validarLogin(loginDTO.getLogin(), loginDTO.getSenha());

        if (sucesso) {
            return "redirect:/pagina-inicial";
        } else {
            model.addAttribute("erro", "Login ou senha incorretos!");
            return "index"; // Retorna para página de login com erro
        }
    }
}
