package com.example.cravo_canela.dominio;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

//@Getter
//@Setter
@Entity
@Table(name = "IMAGEM_PRODUTO")
public class Imagem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Long id;

    @Column(name = "IMAGEM", nullable = false)
    @Lob
    private byte[] imagem;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public byte[] getImagem() {
        return imagem;
    }

    public void setImagem(byte[] imagem) {
        this.imagem = imagem;
    }
}
