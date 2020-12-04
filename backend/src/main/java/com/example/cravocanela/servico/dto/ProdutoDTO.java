package com.example.cravocanela.servico.dto;

import com.example.cravocanela.dominio.Imagem;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
@Builder
public class ProdutoDTO {
    private Long id;
    private String nome;
    private Double valor;
    private Imagem imagemDestaque;
}
