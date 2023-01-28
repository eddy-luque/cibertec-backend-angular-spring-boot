import { RouterModule, Routes } from '@angular/router';

import { ListarComponent } from './listar/listar.component';
import { LoginComponent } from './login/login.component';
import { NgModule } from '@angular/core';
import { SecurityGuardGuard } from '../security/security-guard.guard';

const routes: Routes = [
  {
    path: 'login',
    component: LoginComponent,
  },
  {
    path: 'listar',
    component: ListarComponent,
    canActivate:[SecurityGuardGuard]
  },
  {
    path: '**',
    redirectTo: 'listar',
  },
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class PagesRoutingModule {}
