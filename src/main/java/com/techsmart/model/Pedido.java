package com.techsmart.model;

/*
Autora: Amanda Caetano Nasser
Data: 27/03/2025
Descrição: Classe Pedido, de acordo com a tabela do banco de dados
*/

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Data 
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Pedido")
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pedido_id")
    private Integer id;

    @Column(name = "data_hora", nullable = false)
    private LocalDateTime dataHora;

    @ManyToOne //Relacionamento com a tabela "Usuario"
    @JoinColumn(name = "fk_usuario", nullable = false)
    private Usuario usuario;

    @Column(name = "valor_total", nullable = false)
    private Double valorTotal;

    @Column(name = "situacao", length = 50) //Pode ser nulo
    private String situacao;
}