package com.example.cravocanela.dominio;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "PRODUTO")
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Long id;

    @Column(name = "NOME_PRODUTO", nullable = false)
    private String nomeProduto;

    @Column(name = "DESCRICAO", nullable = false)
    private String descricaoProduto;

    @Column(name = "VALOR", nullable = false)
    private Double valorProduto;

    @OneToMany(mappedBy = "produto")
    private List<Imagem> listaImagens;

    @Column(name = "QUANTIDADE_ESTOQUE", nullable = false)
    private Long quantidadeEstoque;

    @Column(name = "STATUS", nullable = false)
    private Boolean status;

}
