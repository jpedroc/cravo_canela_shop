import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class ImagemServiceService {

  url = "/api/imagens"

  constructor(private httpClient: HttpClient) { }

  createImagem(form: FormData) : Observable<any> {
    return this.httpClient.post(this.url, form);
  }
}
