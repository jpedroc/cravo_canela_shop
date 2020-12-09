import { Component, Input, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { ProdutoCadastro } from 'src/app/models/ProdutoCadastro';
import { ProdutoCadastroService } from 'src/app/services/produto-cadastro.service';

@Component({
  selector: 'app-produto-detalhes',
  templateUrl: './produto-detalhes.component.html',
  styleUrls: ['./produto-detalhes.component.css']
})
export class ProdutoDetalhesComponent implements OnInit {

  produto: ProdutoCadastro = new ProdutoCadastro();

  constructor(
    private produtoService: ProdutoCadastroService,
    private route: ActivatedRoute
    ) { }

  ngOnInit(): void {
    this.produto = this.route.snapshot.data.ProdutoResolve;
    console.log(this.produto);
  }

  getProduto() {
    this.route.data.subscribe()
  }

  setImagem() {
    return "data:image/png;base64," + this.produto.listaImagens[0].imagem;
  }

}
