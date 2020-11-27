package com.example.cravo_canela.dominio;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

//@Getter
//@Setter
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

    @OneToMany
    @JoinColumn(name = "ID_PRODUTO")
    private List<Imagem> listaImagens;

    @Column(name = "QUANTIDADE_ESTOQUE")
    private Long quantidadeEstoque;

    @Column(name = "STATUS", nullable = false)
    private Boolean status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public String getDescricaoProduto() {
        return descricaoProduto;
    }

    public void setDescricaoProduto(String descricaoProduto) {
        this.descricaoProduto = descricaoProduto;
    }

    public Double getValorProduto() {
        return valorProduto;
    }

    public void setValorProduto(Double valorProduto) {
        this.valorProduto = valorProduto;
    }

    public List<Imagem> getListaImagens() {
        return listaImagens;
    }

    public void setListaImagens(List<Imagem> listaImagens) {
        this.listaImagens = listaImagens;
    }

    public Long getQuantidadeEstoque() {
        return quantidadeEstoque;
    }

    public void setQuantidadeEstoque(Long quantidadeEstoque) {
        this.quantidadeEstoque = quantidadeEstoque;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
}
