import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ImagemCadastro } from 'src/app/models/ImagemCadastros';
import { ProdutoFiltro } from 'src/app/models/ProdutoFiltro';
import { ProdutoListagem } from 'src/app/models/ProdutoListagem';
import { ProdutoListagemService } from 'src/app/services/produto-listagem.service';
import { Pageable } from 'src/app/util/pageable-request';

@Component({
  selector: 'app-produto-list',
  templateUrl: './produto-list.component.html',
  styleUrls: ['./produto-list.component.css']
})
export class ProdutoListComponent implements OnInit {

  produtos: Pageable<ProdutoListagem>;
  itensPorPagina: number;
  filtro: ProdutoFiltro = new ProdutoFiltro();

  constructor(
    private produtoService: ProdutoListagemService,
    private router: Router
  ) { }

  ngOnInit(): void {
    this.itensPorPagina = 10;
    this.getProdutos(this.filtro, this.produtos);
  }

  getProdutos(filtro: ProdutoFiltro, pageable: Pageable<ProdutoListagem>) {
    this.produtoService.index(filtro, pageable).subscribe(
      response => {
        console.log(response)
        this.produtos = response; 
      },
      erro => {
        alert("Error")
      }
    )
  }

  setImagem(imagem: ImagemCadastro) {
    return "data:image/png;base64," + imagem.imagem;
  }

  verProduto(id: number) {
    this.router.navigate([`detalhe/${id}`]);
  }

}