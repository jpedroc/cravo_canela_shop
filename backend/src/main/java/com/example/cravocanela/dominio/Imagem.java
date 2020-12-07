package com.example.cravocanela.dominio;


import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Data
@Builder
@Table(name = "IMAGEM_PRODUTO")
public class Imagem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Long id;

    @Column(name = "IMAGEM", nullable = false)
    @Lob
    private byte[] imagem;

    @ManyToOne
    @JoinColumn(name = "ID_PRODUTO")
    private Produto produto;

}
