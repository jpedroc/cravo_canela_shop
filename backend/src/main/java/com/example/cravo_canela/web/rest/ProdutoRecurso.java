package com.example.cravo_canela.web.rest;

import com.example.cravo_canela.dominio.Produto;
import com.example.cravo_canela.servico.ProdutoServico;
import com.example.cravo_canela.servico.dto.ProdutoDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("/api/produtos")
@RequiredArgsConstructor
public class ProdutoRecurso {
    private final ProdutoServico produtoServico;

    @PostMapping
    public ResponseEntity<Produto> cadastrar(@Valid @RequestBody Produto produto) throws URISyntaxException {
        Produto produtoSalvo = produtoServico.salvar(produto);
        return ResponseEntity.created(new URI("/produtos/" + produto.getId())).body(produto);
    }

    @PutMapping
    public ResponseEntity<Produto> editar(@Valid @RequestBody Produto produto) {
        Produto produtoEditado = produtoServico.salvar(produto);
        return ResponseEntity.ok().body(produto);
    }

//    @GetMapping
//    public ResponseEntity<List<ProdutoDTO>> listarAtivos() {
//
//    }
}
