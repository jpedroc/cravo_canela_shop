import { Component, OnInit } from '@angular/core';
import { ProdutoCadastroService } from 'src/app/services/produto-cadastro.service';
import { ImagemServiceService } from 'src/app/services/imagem-service.service';
import { ProdutoCadastro } from 'src/app/models/ProdutoCadastro';
import { Imagem } from 'src/app/models/Imagem';

@Component({
  selector: 'app-produto-form',
  templateUrl: './produto-form.component.html',
  styleUrls: ['./produto-form.component.css']
})
export class ProdutoFormComponent implements OnInit {

  produto: ProdutoCadastro;
  formData = new FormData();
  url = '';


  constructor( 
    private produtoService: ProdutoCadastroService,
    private imagemService: ImagemServiceService
    ) { }

  ngOnInit(): void {
    this.produto = new ProdutoCadastro();
  }

  novaImagem() {
    console.log(this.produto.listaImagens.length)
    this.produto.listaImagens.push(new Imagem());
  }

  setImagem(event: any, index: number) {
    if (event.target.files && event.target.files[0]) {
      let reader = new FileReader();

      reader.readAsDataURL(event.target.files[0]);
      reader.onload = (event) => {
        this.produto.listaImagens[index].url = event.target.result.toString();
      }

      this.produto.listaImagens[index].imagem = event.target.files.item(0);

      if(index == 0) {
        this.produto.listaImagens[index].destaque = true;
      }
    }
  }

  salvar() {
    this.formData = new FormData();

    this.produto.listaImagens.map(element => {
      this.formData.append("imagens", element.imagem);
    })

    this.produto.listaImagens = [];
    console.log(this.produto)

    this.produtoService.create(this.produto).subscribe(
      response => {
        this.formData.append('idProduto', response.id.toString());
        this.imagemService.createImagem(this.formData).subscribe(
          response => {
            console.log("Cadastrou");
          },
          erro => {
            console.log(erro);
          }
        );
      },
      erro => {
        console.log(erro);
      }
    )
  }

}
