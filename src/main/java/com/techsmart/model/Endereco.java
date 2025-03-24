package com.techsmart.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data 
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Endereco")
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "endereco_id")
    private Integer id;

    @Column(name = "cep", length = 8, nullable = false)
    private String cep;

    @Column(name = "logradouro", length = 150, nullable = false)
    private String logradouro;

    @Column(name = "numero", nullable = false)
    private Integer numero;

    @Column(name = "complemento", length = 100)
    private String complemento;

    @Column(name = "bairro", length = 50, nullable = false)
    private String bairro;

    @Column(name = "cidade", length = 50, nullable = false)
    private String cidade;

    @Column(name = "estado", length = 50, nullable = false)
    private String estado;
}
