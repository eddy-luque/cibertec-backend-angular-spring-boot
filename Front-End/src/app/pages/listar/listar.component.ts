import { Component, OnInit } from '@angular/core';

import { CreateComponent } from '../modal/create.component';
import { IPrestamos } from './../../interfaces/interfaces.interface';
import { JwtHelperService } from '@auth0/angular-jwt';
import { NzModalService } from 'ng-zorro-antd/modal';
import { Observable } from 'rxjs';
import { ServicesService } from './../../services/services.service';

@Component({
  selector: 'app-listar',
  templateUrl: './listar.component.html',
  styleUrls: ['./listar.component.scss'],
})
export class ListarComponent implements OnInit {
  prestamos$: Observable<IPrestamos[]> | undefined;
  helper =  new JwtHelperService();
  profile!:string

  constructor(
    private service:ServicesService,
    private modalService: NzModalService
  ) {

    this.prestamos$ = this.service.getQuery<IPrestamos[]>('prestamo')
  }

  ngOnInit(): void {
    const token = localStorage.getItem('_token') || '';
    const decodedToken = this.helper.decodeToken(token);
    this.profile = decodedToken.profile
    console.log('decodedToken...' + decodedToken.profile)
  }

  prestamo(){
    this.modalService.create({
      nzTitle: 'Registrar Prestamo',
      nzContent:CreateComponent,
      nzFooter:null
    });
  }
}
