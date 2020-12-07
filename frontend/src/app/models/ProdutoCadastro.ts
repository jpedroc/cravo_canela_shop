import { Imagem } from './Imagem';
export class ProdutoCadastro {
    id: number;
    nomeProduto: string;
    descricaoProduto: string;
    valorProduto: number;
    quantidadeEstoque: number;
    status: boolean = true;
    listaImagem: Imagem[] = [];
}