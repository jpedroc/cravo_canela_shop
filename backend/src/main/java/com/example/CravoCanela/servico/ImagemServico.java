package com.example.CravoCanela.servico;

import com.example.CravoCanela.dominio.Imagem;

import java.util.List;

public interface ImagemServico {

    Imagem salvar(Imagem imagem);

    List<Imagem> listar();

    void excluir(Long id);

}
