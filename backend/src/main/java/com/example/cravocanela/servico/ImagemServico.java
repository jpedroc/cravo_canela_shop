package com.example.cravocanela.servico;

import com.example.cravocanela.dominio.Imagem;
import org.springframework.web.multipart.MultipartFile;

public interface ImagemServico {

    Imagem salvar(Imagem imagem);

    void excluir(Long id);

    void salvar(String idProduto, MultipartFile[] imagens);
}
