package com.techsmart.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class UsuarioDTO {
    @NotBlank(message = "O nome é obrigatório.")
    @Size(max = 100, message = "O nome deve ter no máximo 100 caracteres.")
    private String nome;

    @NotBlank(message = "O CPF ou CNPJ é obrigatório.")
    @Size(min = 11, max = 14, message = "O CPF deve ter 11 dígitos e o CNPJ 14.")
    private String cpfCnpj;

    @NotBlank(message = "O e-mail é obrigatório.")
    @Email(message = "Formato de e-mail inválido.")
    @Size(max = 50, message = "O e-mail deve ter no máximo 50 caracteres.")
    private String email;

    @NotBlank(message = "O telefone principal é obrigatório.")
    @Size(max = 15, message = "O telefone deve ter no máximo 15 caracteres.")
    private String numPrincipal;

    @Size(max = 15, message = "O telefone de recado deve ter no máximo 15 caracteres.")
    private String numRecado;

    @NotNull(message = "O tipo de usuário é obrigatório.")
    private Integer tipoUsuarioId;

    @NotNull(message = "O endereço é obrigatório.")
    private Integer enderecoId;

    @NotBlank(message = "A senha é obrigatória.")
    @Size(min = 6, max = 100, message = "A senha deve ter entre 6 e 100 caracteres.")
    private String senha;

    @NotNull(message = "A pergunta de segurança é obrigatória.")
    private Integer perguntaSegurancaId;

    @NotBlank(message = "A resposta de segurança é obrigatória.")
    @Size(max = 100, message = "A resposta de segurança deve ter no máximo 100 caracteres.")
    private String respostaSeguranca;

    // Campos extras apenas para exibição (não precisam de validação)
    private String tipoUsuarioDescricao;
    private String enderecoResumo;
}
