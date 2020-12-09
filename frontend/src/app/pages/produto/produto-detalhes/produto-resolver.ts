import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, Resolve, Router } from '@angular/router';
import { Observable, of } from 'rxjs';
import { map, catchError } from 'rxjs/operators';
import { ProdutoCadastro } from 'src/app/models/ProdutoCadastro';
import { ProdutoCadastroService } from 'src/app/services/produto-cadastro.service';

@Injectable({
    providedIn: 'root'
})
export class ProdutoResolver implements Resolve<ProdutoCadastro> {
    idProduto: number;
    constructor(
        private produtoService: ProdutoCadastroService,
        private router: Router,
    ){
    }

    resolve(route: ActivatedRouteSnapshot): Observable<ProdutoCadastro> | Observable<any> {
        this.idProduto = route.params.id;
        
        if(isNaN(+this.idProduto)){
            this.router.navigate(['']);
            return of(null);
        }

        return this.produtoService.show(this.idProduto).pipe(
            map(result => {
                if(result) {
                    return result;
                }
                this.router.navigate(['']);
                return null;
            }),
            catchError(() => {
                this.router.navigate(['']);
                return null;
            })
        )
    }
}