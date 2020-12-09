import { ResourceService } from './resource.service';
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { ProdutoListagem } from '../models/ProdutoListagem';

@Injectable({
  providedIn: 'root'
})
export class ProdutoListagemService extends ResourceService<ProdutoListagem>{

  constructor(httpClient: HttpClient) { 
    super(httpClient, 'api/produtos')
  }

}
