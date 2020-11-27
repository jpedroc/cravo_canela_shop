package com.example.cravo_canela.servico.dto;

import lombok.Getter;
import lombok.Setter;


public class ProdutoDTO {
    private Long id;
    private String nome;
    private Double valor;
    private byte[] imagemDestaque;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public byte[] getImagemDestaque() {
        return imagemDestaque;
    }

    public void setImagemDestaque(byte[] imagemDestaque) {
        this.imagemDestaque = imagemDestaque;
    }
}
