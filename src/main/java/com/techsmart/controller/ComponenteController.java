package com.techsmart.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/componente")
public class ComponenteController {

	@GetMapping
	public String carregarPagina(Model model) {
		return "pages/cadastro-componente";
	}
}
