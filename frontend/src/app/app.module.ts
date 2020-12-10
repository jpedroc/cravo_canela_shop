import { BrowserModule } from '@angular/platform-browser';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ProdutoFormComponent } from './pages/produto/produto-form/produto-form.component';
import { CommonModule } from '@angular/common';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { ProdutoListComponent } from './pages/produto/produto-list/produto-list.component';
import { ProdutoDetalhesComponent } from './pages/produto/produto-detalhes/produto-detalhes.component';
import { LayoutComponent } from './components/layout/layout.component';

@NgModule({
  declarations: [
    ProdutoFormComponent,
    AppComponent,
    ProdutoListComponent,
    ProdutoDetalhesComponent,
    LayoutComponent
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    CommonModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule,
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
