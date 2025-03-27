package com.techsmart.model;

/*
Autora: Amanda Caetano Nasser
Data: 27/03/2025
Descrição: Classe PedidoProdutoFinal, de acordo com a tabela do banco de dados
*/

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data 
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Pedido_ProdutoFinal")
public class PedidoProdutoFinal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pedido_produtofinal_id")
    private Integer id;

    @ManyToOne //Relacionamento com a tabela "Pedido"
    @JoinColumn(name = "fk_pedido", nullable = false)
    private Pedido pedido;

    @ManyToOne //Relacionamento com a tabela "ProdutoFinal"
    @JoinColumn(name = "fk_produtofinal", nullable = false)
    private ProdutoFinal produtoFinal;

    @Column(name = "quantidade_item", nullable = false)
    private Integer quantidadeItem;
}