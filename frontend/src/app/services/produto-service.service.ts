import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { ProdutoCadastro } from '../models/ProdutoCadastro';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ProdutoServiceService {

  url = "/api/produtos"

  constructor(private httpClient: HttpClient) { }

  create(produto: ProdutoCadastro): Observable<any> {
    return this.httpClient.post(this.url, produto);
  }
}