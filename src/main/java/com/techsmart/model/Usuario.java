package com.techsmart.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data //Gera getter, setters, toString(), equals() e hashCode() sem a necessidade de escrever estes métodos
@NoArgsConstructor //Gera um construtor sem argumentos
@AllArgsConstructor //Gera um construtor com todos os argumentos (atributos da classe)
@Entity //Declara a classe como uma entidade que poderá ser manipulada pelo JPA
@Table(name = "Usuario") //Indica a qual tabela do banco de dados esta classe esta associada
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "usuario_id") //Indica a coluna da tabela que este atributo representa (nome do atributo e nome da coluna podem ser diferentes)
    private Integer id;

    @ManyToOne //Indica um relacionamento com outra tabela, neste caso um relacionamento de Muitos para Um, pois um "TipoUsuario" pode estar atrelado a muitos "Usuario"
    @JoinColumn(name = "fk_tipo_usuario", nullable = false) //Indica a qual coluna este relacionamento deve se basear. Neste caso é a coluna que guarda o ID (fk_tipo_usuario) referenciando a tabela Tipo_Usuario
    private TipoUsuario tipoUsuario;

    @Column(name = "nome", length = 100, nullable = false)
    private String nome;

    @Column(name = "cpf_cnpj", length = 14, nullable = false)
    private String cpfCnpj;

    @Column(name = "data_nascimento", nullable = false)
    private LocalDate dataNascimento;

    @Column(name = "email", length = 50, nullable = false)
    private String email;

    @Column(name = "num_principal", length = 15, nullable = false)
    private String numPrincipal;

    @Column(name = "num_recado", length = 15)
    private String numRecado;

    @ManyToOne
    @JoinColumn(name = "fk_endereco", nullable = false)
    private Endereco endereco;

    @Column(name = "senha", length = 100, nullable = false)
    private String senha;

    @ManyToOne
    @JoinColumn(name = "fk_pergunta_seguranca", nullable = false)
    private PerguntaSeguranca perguntaSeguranca;

    @Column(name = "resposta_seguranca", length = 100, nullable = false)
    private String respostaSeguranca;
}
