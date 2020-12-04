import { ProdutoServiceService } from './../../../services/produto-service.service';
import { Imagem } from './../../../models/Imagem';
import { ProdutoCadastro } from './../../../models/ProdutoCadastro';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-produto-form',
  templateUrl: './produto-form.component.html',
  styleUrls: ['./produto-form.component.css']
})
export class ProdutoFormComponent implements OnInit {

  produto: ProdutoCadastro;
  url = '';


  constructor( private produtoService: ProdutoServiceService) { }

  ngOnInit(): void {
    this.produto = new ProdutoCadastro();
    this.produto.imagemDestaque = new Imagem();
  }

  novaImagem() {
    console.log(this.produto.listaImagem.length)
    this.produto.listaImagem.push(new Imagem());
  }

  setImagemDestaque(event: any) {
    if (event.target.files && event.target.files[0]) {
      let reader = new FileReader();

      reader.readAsDataURL(event.target.files[0]);
      reader.onload = (event) => {
        this.produto.imagemDestaque.url = event.target.result.toString();
      }

      this.produto.imagemDestaque.imagem = event.target.files.item(0);
    }
  }

  setImagem(event: any, index: number) {
    if (event.target.files && event.target.files[0]) {
      let reader = new FileReader();

      reader.readAsDataURL(event.target.files[0]);
      reader.onload = (event) => {
        this.produto.listaImagem[index].url = event.target.result.toString();
      }

      this.produto.listaImagem[index].imagem = event.target.files.item(0);
    }
  }

  salvar() {
    console.log(this.produto)
    this.produtoService.create(this.produto).subscribe(
      response => {
        console.log("cadastrou " + response);
      },
      erro => {
        console.log(erro);
      }
    )
  }

}
