package com.techsmart.model;

/*
Autora: Amanda Caetano Nasser
Data: 27/03/2025
Descrição: Classe Feedback, de acordo com a tabela do banco de dados
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
@Table(name = "Feedback")
public class Feedback {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "feedback_id")
    private Integer id;

    @Column(name = "data_hora", nullable = false)
    private LocalDateTime dataHora;

    @ManyToOne //Relacionamento com a tabela "Pedido"
    @JoinColumn(name = "fk_pedido", nullable = false)
    private Pedido pedido;

    @Column(name = "avaliacao", nullable = false)
    private Integer avaliacao;

    @Column(name = "observacao", length = 100) //Pode ser nulo
    private String observacao;
}