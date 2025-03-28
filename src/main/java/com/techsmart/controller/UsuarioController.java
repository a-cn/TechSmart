package com.techsmart.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.techsmart.dto.PerguntaSegurancaDTO;
import com.techsmart.dto.UsuarioDTO;
import com.techsmart.mapper.UsuarioMapper;
import com.techsmart.model.Usuario;
import com.techsmart.repository.UsuarioRepository;
import com.techsmart.service.UsuarioService;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {

    private final UsuarioService usuarioService;
    private final UsuarioMapper usuarioMapper;
    
    public UsuarioController(UsuarioService usuarioService, UsuarioMapper usuarioMapper) {
		this.usuarioService = usuarioService;
		this.usuarioMapper = usuarioMapper;
    }
	
    @GetMapping
    public String carregaPagina(Model model) {
    	return "pages/cadastro-usuario";
    }
    
    @GetMapping("/buscar-pergunta-seguranca")
    public String buscarPerguntSegurancaPorLogin(
    	@RequestParam(name = "login") String login, 
    	Model model) {
    	
        PerguntaSegurancaDTO pergunta = usuarioService.buscarPerguntaSegurancaPorLogin(login);

        if (pergunta == null) {
            model.addAttribute("erro", "Usuário não encontrado.");
            return "index";
        }

        model.addAttribute("login", login);
        model.addAttribute("pergunta", pergunta.getPergunta());
        model.addAttribute("mostrarModal", true);

        return "index";
    }

    @PostMapping("/verificar-resposta-pergunta")
    public String verificarRespostaPergunta(
            @RequestParam(name = "resposta") String resposta,
            @RequestParam(name = "login") String login,
            Model model) {

        UsuarioDTO usrDto = this.usuarioMapper.toDto(this.usuarioService.buscarPorLogin(login));

        if (!resposta.equalsIgnoreCase(usrDto.getRespostaSeguranca())) {
            model.addAttribute("erro", "Resposta incorreta!");
            return "index";
        }

        model.addAttribute("login", login);
        return "pages/recuperar-senha";
    }
    
    @PostMapping("/atualizar-senha")
    public String atualizarSenha(
            @RequestParam(name = "login") String login,
            @RequestParam(name = "novaSenha") String novaSenha,
            @RequestParam(name = "confirmarSenha") String confirmarSenha,
            Model model) {

        if (!novaSenha.equals(confirmarSenha)) {
            model.addAttribute("erro", "As senhas não coincidem.");
            model.addAttribute("login", login);
            return "pages/recuperar-senha";
        }

        usuarioService.atualizarSenha(login, novaSenha); // você precisa implementar este método no service

        model.addAttribute("mensagem", "Senha atualizada com sucesso. Faça login com a nova senha.");
        return "index";
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