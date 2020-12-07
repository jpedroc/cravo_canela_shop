package com.example.cravocanela.servico.mapper;

import com.example.cravocanela.dominio.Produto;
import com.example.cravocanela.servico.dto.ProdutoDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {})
public interface ProdutoMapper extends EntityMapper<ProdutoDTO, Produto> {

    @Override
    @Mapping(target = "nome", source = "nomeProduto")
    @Mapping(target = "valor", source = "valorProduto")
    @Mapping(target = "imagemDestaque", expression = "java(entity.getListaImagens().get(0))")
    ProdutoDTO toDto(Produto entity);
}
