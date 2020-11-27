package com.example.cravo_canela.servico;

import com.example.cravo_canela.dominio.Produto;
import com.example.cravo_canela.servico.dto.ProdutoDTO;
import com.example.cravo_canela.servico.filtro.ProdutoFiltro;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ProdutoServico {

    Page<ProdutoDTO> listar(ProdutoFiltro questaoFiltro, Pageable pageable);

    Produto salvar(Produto produto);

    Produto obterPorId(Long id);

    void desabilitar(Long id);
}
