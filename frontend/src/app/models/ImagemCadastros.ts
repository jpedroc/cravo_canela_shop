import { Resource } from './Resource.model';
export class ImagemCadastro extends Resource{
    imagem: File
    idProduto: number;
    destaque: boolean = false;
}