package com.example.cravo_canela.servico.impl;


import com.example.cravo_canela.dominio.Produto;
import com.example.cravo_canela.repositorio.ProdutoRepositorio;
import com.example.cravo_canela.servico.ProdutoServico;
import com.example.cravo_canela.servico.dto.ProdutoDTO;
import com.example.cravo_canela.servico.exception.RegraNegocioException;
import com.example.cravo_canela.servico.mapper.ProdutoMapper;
import lombok.RequiredArgsConstructor;
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
    public List<ProdutoDTO> listar() {
        List<Produto> listaProdutos = produtoRepositorio.findByStatus(1).orElse(new ArrayList<Produto>());

        return produtoMapper.toDto(listaProdutos);
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
