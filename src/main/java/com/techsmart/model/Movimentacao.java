package com.techsmart.model;

/*
Autora: Amanda Caetano Nasser
Data: 27/03/2025
Descrição: Classe Movimentacao, de acordo com a tabela do banco de dados
*/

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@Data 
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Movimentacao")
public class Movimentacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "movimentacao_id")
    private Integer id;

    @Column(name = "data_hora", nullable = false)
    private LocalDate dataHora;

    @Column(name = "tipo_movimentacao", length = 50, nullable = false)
    private String tipoMovimentacao;

    @ManyToOne //Relacionamento com a tabela "Pedido"
    @JoinColumn(name = "fk_pedido") //Pode ser nulo
    private Pedido pedido;

    @ManyToOne //Relacionamento com a tabela "ProdutoFinal"
    @JoinColumn(name = "fk_produtofinal", nullable = false)
    private ProdutoFinal produtoFinal;

    @Column(name = "quantidade", nullable = false)
    private Integer quantidade;
}