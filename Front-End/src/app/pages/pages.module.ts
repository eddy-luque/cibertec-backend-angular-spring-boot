import { FormsModule, ReactiveFormsModule } from '@angular/forms';

import { CommonModule } from '@angular/common';
import { CreateComponent } from './modal/create.component';
import { ListarComponent } from './listar/listar.component';
import { LoginComponent } from './login/login.component';
import { NgModule } from '@angular/core';
import { NgZorroModule } from '../ng-zorro.module';
import { PagesRoutingModule } from './pages-routing.module';

@NgModule({
  declarations: [
    ListarComponent,
    LoginComponent,
    CreateComponent
  ],
  imports: [
    CommonModule,
    PagesRoutingModule,
    NgZorroModule,
    FormsModule, ReactiveFormsModule
  ]
})
export class PagesModule { }
