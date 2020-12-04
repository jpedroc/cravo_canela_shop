package com.example.cravocanela.dominio;


import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Blob;

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
    private Blob imagem;

}
