package com.example.cravo_canela.servico.mapper;

import com.example.cravo_canela.dominio.Produto;
import com.example.cravo_canela.servico.dto.ProdutoDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ProdutoMapper extends EntityMapper<ProdutoDTO, Produto> {

    @Override
    @Mapping(target = "nome", source = "nomeProduto")
    @Mapping(target = "valor", source = "valorProduto")
    @Mapping(target = "imagemDestaque", source = "listaImagens.get(0)", )
    ProdutoDTO toDto(Produto entity);
}
