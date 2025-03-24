package com.techsmart.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class TipoUsuarioDTO {

    @NotBlank(message = "Descrição é obrigatória")
    @Size(max = 15, message = "Descrição deve ter no máximo 15 caracteres")
    private String descricao;

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
