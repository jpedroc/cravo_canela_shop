import { Resource } from './Resource.model';
import { Imagem } from './Imagem';
export class ProdutoCadastro extends Resource{
    nomeProduto: string;
    descricaoProduto: string;
    valorProduto: number;
    quantidadeEstoque: number;
    status: boolean = true;
    listaImagens: Imagem[] = [];
}