package com.example.cravocanela.servico.impl;

import com.example.cravocanela.dominio.Imagem;
import com.example.cravocanela.dominio.Produto;
import com.example.cravocanela.repositorio.ImagemRepositorio;
import com.example.cravocanela.servico.ImagemServico;
import com.example.cravocanela.servico.ProdutoServico;
import com.example.cravocanela.servico.exception.RegraNegocioException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.io.IOException;

@Service
@Transactional
@RequiredArgsConstructor
public class ImagemServicoImpl implements ImagemServico {

    private final ImagemRepositorio imagemRepositorio;
    private final ProdutoServico produtoServico;

    @Override
    public Imagem salvar(Imagem imagem) {
        return imagemRepositorio.save(imagem);
    }

    @Override
    public void excluir(Long id) {
        Imagem imagem = imagemRepositorio.findById(id).orElseThrow(() -> new RegraNegocioException("Imagem inexistente"));
        imagemRepositorio.delete(imagem);
    }

    @Override
    public void salvar(String idProduto, MultipartFile[] imagens) {

        if(imagens == null || imagens.length == 0) {
            throw new RegraNegocioException("Lista de imagens vazias");
        }
        Produto produto = produtoServico.obterPorId(Long.valueOf(idProduto));
        Imagem imagemSalva;
        Boolean destaque = true;
        byte[] btImagem;
        for (MultipartFile imagen : imagens) {
            try {
                imagemSalva = new Imagem();
                imagemSalva.setProduto(new Produto());
                imagemSalva.getProduto().setId(produto.getId());
                imagemSalva.setImagem((byte[])imagen.getBytes());
                imagemSalva.setDestaque(destaque);
                destaque = false;

                imagemRepositorio.save(imagemSalva);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
