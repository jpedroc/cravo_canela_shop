import { Resource } from './Resource.model';
import { ImagemCadastro } from './ImagemCadastros';
export class ProdutoListagem extends Resource{
    nome: string;
    valor: number;
    imagemDestaque: ImagemCadastro;
}