package com.example.cravocanela.servico.impl;


import com.example.cravocanela.dominio.Produto;
import com.example.cravocanela.repositorio.ProdutoRepositorio;
import com.example.cravocanela.servico.ProdutoServico;
import com.example.cravocanela.servico.dto.ProdutoDTO;
import com.example.cravocanela.servico.exception.RegraNegocioException;
import com.example.cravocanela.servico.filtro.ProdutoFiltro;
import com.example.cravocanela.servico.mapper.ProdutoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class ProdutoServicoImpl implements ProdutoServico {

    private final ProdutoRepositorio produtoRepositorio;
    private final ProdutoMapper produtoMapper;

    @Override
    public Page<ProdutoDTO> listar(ProdutoFiltro produtoFiltro, Pageable pageable) {
        produtoFiltro.setStatus(true);
        Page<Produto> listaProdutos = produtoRepositorio.findAll(produtoFiltro.filter(), pageable);

        return listaProdutos.map(produtoMapper::toDto);
    }

    @Override
    public Produto salvar(Produto produto) {
        if(produto.getListaImagens().isEmpty()){
            throw new RegraNegocioException("Lista de imagens vazias");
        }

        return produtoRepositorio.save(produto);
    }

    @Override
    public Produto obterPorId(Long id) {
        return produtoRepositorio.findById(id).orElseThrow(() -> new RegraNegocioException("Produto inexistente"));
    }

    @Override
    public void desabilitar(Long id) {
        Produto produto = produtoRepositorio.findById(id).orElseThrow(() -> new RegraNegocioException("Produto inexistente"));

        produto.setStatus(false);

        produtoRepositorio.save(produto);
    }
}
