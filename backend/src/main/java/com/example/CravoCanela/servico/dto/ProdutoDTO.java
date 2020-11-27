package com.example.CravoCanela.servico.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProdutoDTO {
    private Long id;
    private String nome;
    private Double valor;
    private byte[] imagemDestaque;
}
