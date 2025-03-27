package com.techsmart.model;

/*
Autora: Amanda Caetano Nasser
Data: 27/03/2025
Descrição: Classe ProdutoFinal, de acordo com a tabela do banco de dados
*/

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data 
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "ProdutoFinal")
public class ProdutoFinal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "produtofinal_id")
    private Integer id;

    @ManyToOne //Relacionamento com a tabela "Producao"
    @JoinColumn(name = "fk_producao", nullable = false)
    private Producao producao;

    @Column(name = "nome", length = 50, nullable = false)
    private String nome;

    @Column(name = "descricao", length = 100) //Pode ser nulo
    private String descricao;

    @Column(name = "valor_venda", nullable = false)
    private Double valorVenda;

    @Column(name = "quantidade", nullable = false)
    private Integer quantidade;

    @Column(name = "nivel_minimo", nullable = false)
    private Integer nivelMinimo;

    @Column(name = "nivel_maximo", nullable = false)
    private Integer nivelMaximo;
}