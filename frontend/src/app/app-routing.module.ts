import { ProdutoFormComponent } from './pages/produto/produto-form/produto-form.component';
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ProdutoListComponent } from './pages/produto/produto-list/produto-list.component';

const routes: Routes = [
  {path: "", component: ProdutoFormComponent},
  {path: "listagem", component: ProdutoListComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
