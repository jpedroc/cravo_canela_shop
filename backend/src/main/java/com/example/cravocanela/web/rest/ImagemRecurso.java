package com.example.cravocanela.web.rest;

import com.example.cravocanela.dominio.Imagem;
import com.example.cravocanela.dominio.Produto;
import com.example.cravocanela.servico.ImagemServico;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

@RestController
@RequestMapping("/api/imagens")
@RequiredArgsConstructor
public class ImagemRecurso {

    private final ImagemServico imagemServico;

    @PostMapping
    public ResponseEntity<String> cadastrar(@RequestPart String idProduto, @RequestBody MultipartFile ...imagens) throws URISyntaxException {
        imagemServico.salvar(idProduto, imagens);

        return ResponseEntity.created(new URI("/imagens/")).body("Ok");
    }
}
