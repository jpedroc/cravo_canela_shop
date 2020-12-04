package com.example.cravocanela.servico;

import com.example.cravocanela.dominio.Produto;
import com.example.cravocanela.servico.dto.ProdutoDTO;
import com.example.cravocanela.servico.filtro.ProdutoFiltro;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ProdutoServico {

    Page<ProdutoDTO> listar(ProdutoFiltro questaoFiltro, Pageable pageable);

    Produto salvar(Produto produto);

    Produto obterPorId(Long id);

    void desabilitar(Long id);
}
