package com.techsmart.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Pergunta_Seguranca")
public class PerguntaSeguranca {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pergunta_seguranca_id")
    private Integer id;

    @Column(name = "pergunta", length = 200, nullable = false)
    private String pergunta;
}
