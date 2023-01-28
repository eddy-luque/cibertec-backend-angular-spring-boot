import { Component, OnInit } from '@angular/core';
import { IPrestamoPost, IUsuarios } from './../../interfaces/interfaces.interface';

import { NzModalRef } from 'ng-zorro-antd/modal';
import { NzNotificationService } from 'ng-zorro-antd/notification';
import { Observable } from 'rxjs';
import { ServicesService } from './../../services/services.service';

@Component({
  selector: 'app-create',
  templateUrl: './create.component.html',
  styleUrls: ['./create.component.scss'],
})
export class CreateComponent implements OnInit {
  usuario!: number;
  monto!: number;
  cuotas!: number;

  usuarios$!: Observable<IUsuarios[]>;

  constructor(
    private service: ServicesService,
    private notification: NzNotificationService,
    private modal: NzModalRef
  ) {}

  ngOnInit(): void {
    this.usuarios$ = this.service.getQuery('user');
  }

  registrar() {
    if (this.usuario && this.monto && this.cuotas) {
      const data:IPrestamoPost = {
        userId : this.usuario,
        cuotas : this.cuotas,
        monto : this.monto
      };
      this.service.postQuery(data,'prestamo/guardar','text').subscribe(response => {
        this.notification.success(
          'Aviso',
          'Se ha registrado el prestamos al cliente',
          {
            nzPlacement: 'top',
          }
        );
        this.modal.destroy()
      },(error) => {
        this.notification.warning(
          'Aviso',
          'Hubo problemas al registrar el prestamo. Intente nuevamente',
          {
            nzPlacement: 'top',
          }
        );
      })

    } else {
      this.notification.error(
        'Aviso',
        'Ingrese todos los datos del formulario requeridos',
        {
          nzPlacement: 'top',
        }
      );
    }
  }
}
