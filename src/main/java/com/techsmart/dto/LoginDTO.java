package com.techsmart.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class LoginDTO {
	@NotBlank(message = "Informe seu email")
    @Email(message = "Email inválido")
	private String login;
	
	@NotBlank(message = "Informe sua senha")
	private String senha;
}
