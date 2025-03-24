package com.techsmart.controller;

import com.techsmart.dto.TipoUsuarioDTO;
import com.techsmart.model.TipoUsuario;
import com.techsmart.repository.TipoUsuarioRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/tipo-usuario")
public class TipoUsuarioController {

    @Autowired
    private TipoUsuarioRepository tipoUsuarioRepository;

    @GetMapping("/novo")
    public String exibirFormulario(Model model) {
        if (!model.containsAttribute("tipoUsuarioDTO")) {
            model.addAttribute("tipoUsuarioDTO", new TipoUsuarioDTO());
        }
        return "pages/cadastro-tipo-usuario";
    }

    @PostMapping("/salvar")
    public String salvar(@Valid @ModelAttribute("tipoUsuarioDTO") TipoUsuarioDTO dto,
                         BindingResult result,
                         RedirectAttributes redirectAttributes) {

        if (result.hasErrors()) {
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.tipoUsuarioDTO", result);
            redirectAttributes.addFlashAttribute("tipoUsuarioDTO", dto);
            redirectAttributes.addFlashAttribute("msgTipo", "danger");
            redirectAttributes.addFlashAttribute("msgTexto", "Preencha corretamente o campo Descrição.");
            return "redirect:/tipo-usuario/novo";
        }

        TipoUsuario tipo = new TipoUsuario();
        tipo.setDescricao(dto.getDescricao());

        tipoUsuarioRepository.save(tipo);

        redirectAttributes.addFlashAttribute("msgTipo", "success");
        redirectAttributes.addFlashAttribute("msgTexto", "Tipo de usuário salvo com sucesso!");
        return "redirect:/usuarios";
    }

}