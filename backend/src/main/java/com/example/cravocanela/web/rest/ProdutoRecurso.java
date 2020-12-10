package com.example.cravocanela.web.rest;

import com.example.cravocanela.dominio.Produto;
import com.example.cravocanela.servico.ProdutoServico;
import com.example.cravocanela.servico.dto.ProdutoDTO;
import com.example.cravocanela.servico.filtro.ProdutoFiltro;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;

@RestController
@RequestMapping("/api/produtos")
@RequiredArgsConstructor
public class ProdutoRecurso {
    private final ProdutoServico produtoServico;

    @PostMapping
    public ResponseEntity<Produto> cadastrar(@Valid @RequestBody Produto produto) throws URISyntaxException {
        Produto produtoSalvo = produtoServico.salvar(produto);
        return ResponseEntity.created(new URI("/produtos/" + produtoSalvo.getId())).body(produtoSalvo);
    }

    @PutMapping
    public ResponseEntity<Produto> editar(@Valid @RequestBody Produto produto) {
        Produto produtoEditado = produtoServico.salvar(produto);
        return ResponseEntity.ok().body(produtoEditado);
    }

    @GetMapping
    public ResponseEntity<Page<ProdutoDTO>> listar(@ModelAttribute ProdutoFiltro produtoFiltro, Pageable pageable) {
        Page<ProdutoDTO> produtos = produtoServico.listar(produtoFiltro, pageable);
        return ResponseEntity.ok().body(produtos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Produto> obterPorId(@PathVariable("id") Long id) {
        Produto produto = produtoServico.obterPorId(id);
        return ResponseEntity.ok().body(produto);
    }
}
