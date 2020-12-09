package com.example.cravocanela.dominio;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Type;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "IMAGEM_PRODUTO")
public class Imagem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Long id;

    @Column(name = "IMAGEM", nullable = false)
    @Lob
    @Type(type="org.hibernate.type.BinaryType")
    private byte[] imagem;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "ID_PRODUTO")
    private Produto produto;

    @Column(name = "DESTAQUE", nullable = false)
    private Boolean destaque;

}
