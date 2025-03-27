package com.techsmart.model;

/*
Autora: Amanda Caetano Nasser
Data: 27/03/2025
Descrição: Classe EtapaProducao, de acordo com a tabela do banco de dados
*/

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data 
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Etapa_Producao")
public class EtapaProducao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "etapa_producao_id")
    private Integer id;

    @ManyToOne //Relacionamento com a tabela "Producao"
    @JoinColumn(name = "fk_producao", nullable = false)
    private Producao producao;

    @Column(name = "ordem", nullable = false)
    private Integer ordem;

    @Column(name = "nome", length = 50, nullable = false)
    private String nome;

    @ManyToOne //Relacionamento com a tabela "Componente"
    @JoinColumn(name = "fk_componente", nullable = false)
    private Componente componente;
}