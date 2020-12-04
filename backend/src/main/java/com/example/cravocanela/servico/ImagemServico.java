package com.example.cravocanela.servico;

import com.example.cravocanela.dominio.Imagem;

public interface ImagemServico {

    Imagem salvar(Imagem imagem);

    void excluir(Long id);

}
