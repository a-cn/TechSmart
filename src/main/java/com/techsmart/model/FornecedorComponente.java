package com.techsmart.model;

/*
Autora: Amanda Caetano Nasser
Data: 27/03/2025
Descrição: Classe FornecedorComponente, de acordo com a tabela do banco de dados
*/

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data 
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Fornecedor_Componente")
public class FornecedorComponente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "fornecedor_componente_id")
    private Integer id;

    @ManyToOne //Relacionamento com a tabela "Fornecedor"
    @JoinColumn(name = "fk_fornecedor", nullable = false)
    private Fornecedor fornecedor;

    @ManyToOne //Relacionamento com a tabela "Componente"
    @JoinColumn(name = "fk_componente", nullable = false)
    private Componente componente;

    @Column(name = "custo_componente") //Pode ser nulo
    private Double custoComponente;
}