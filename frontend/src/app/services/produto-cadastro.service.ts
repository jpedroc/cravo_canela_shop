import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { ProdutoCadastro } from '../models/ProdutoCadastro';
import { ResourceService } from './resource.service';

@Injectable({
  providedIn: 'root'
})
export class ProdutoCadastroService extends ResourceService<ProdutoCadastro>{

  constructor(httpCliente: HttpClient) {
    super(httpCliente, 'api/produtos/')
  }
}
