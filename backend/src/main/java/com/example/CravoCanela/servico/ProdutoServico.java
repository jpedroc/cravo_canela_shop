package com.example.CravoCanela.servico;

import com.example.CravoCanela.dominio.Produto;
import com.example.CravoCanela.servico.dto.ProdutoDTO;

import java.util.List;

public interface ProdutoServico {

    List<ProdutoDTO> listar();

    Produto salvar(Produto produto);

    Produto obterPorId(Long id);

    void desabilitar(Long id);
}
