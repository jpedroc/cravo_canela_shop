package com.example.cravocanela.servico.impl;

import com.example.cravocanela.dominio.Imagem;
import com.example.cravocanela.repositorio.ImagemRepositorio;
import com.example.cravocanela.servico.ImagemServico;
import com.example.cravocanela.servico.exception.RegraNegocioException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class ImagemServicoImpl implements ImagemServico {

    private final ImagemRepositorio imagemRepositorio;

    @Override
    public Imagem salvar(Imagem imagem) {
        return imagemRepositorio.save(imagem);
    }

    @Override
    public void excluir(Long id) {
        Imagem imagem = imagemRepositorio.findById(id).orElseThrow(() -> new RegraNegocioException("Imagem inexistente"));
        imagemRepositorio.delete(imagem);
    }
}
