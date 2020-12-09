import { ProdutoFormComponent } from './pages/produto/produto-form/produto-form.component';
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ProdutoListComponent } from './pages/produto/produto-list/produto-list.component';
import { ProdutoDetalhesComponent } from './pages/produto/produto-detalhes/produto-detalhes.component';
import { ProdutoResolver } from './pages/produto/produto-detalhes/produto-resolver';

const routes: Routes = [
  {path: "", component: ProdutoFormComponent},
  {path: "listagem", component: ProdutoListComponent},
  {path: "detalhe/:id", component: ProdutoDetalhesComponent, resolve: {ProdutoResolve: ProdutoResolver}},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
