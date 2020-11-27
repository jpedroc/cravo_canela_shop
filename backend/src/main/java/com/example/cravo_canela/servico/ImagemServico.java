package com.example.cravo_canela.servico;

import com.example.cravo_canela.dominio.Imagem;

public interface ImagemServico {

    Imagem salvar(Imagem imagem);

    void excluir(Long id);

}
