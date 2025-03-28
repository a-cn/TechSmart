package com.techsmart.dto;

import lombok.Data;

@Data
public class PerguntaSegurancaDTO {
	private String pergunta;
	
	private String respostaUsuario;
	
	public PerguntaSegurancaDTO(String pergunta) {
		this.pergunta = pergunta;
	}
}
