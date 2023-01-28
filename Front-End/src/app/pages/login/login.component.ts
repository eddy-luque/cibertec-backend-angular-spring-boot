import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

import { NzNotificationService } from 'ng-zorro-antd/notification';
import { Router } from '@angular/router';
import { ServicesService } from '../../services/services.service';
import { StateService } from 'src/app/services/state.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss'],
})
export class LoginComponent implements OnInit {
  form!: FormGroup;

  constructor(
    private fb: FormBuilder,
    private notification: NzNotificationService,
    private service: ServicesService,
    private route: Router,
    private state:StateService
  ) {
    this.initForm();
  }

  ngOnInit(): void {}

  initForm() {
    this.form = this.fb.group({
      usuario: ['', [Validators.required]],
      password: ['', [Validators.required]],
    });
  }

  iniciar() {
    if (this.form.invalid) {
      this.notification.error(
        'Aviso',
        'Verifique los campos requeridos del formulario',
        {
          nzPlacement: 'top',
        }
      );
    } else {
      const body = {
        email: this.form.get('usuario')?.value,
        password: this.form.get('password')?.value,
      };
      this.service.postQuery(body, 'auth/authenticate').subscribe(
        (response: any) => {
          this.state.isLogIn.emit(true)
          localStorage.setItem('_token', response?.token);
          this.route.navigate(['/listar']);
        },
        (error) => {
          this.notification.error(
            'Aviso',
            'Error al iniciar sesión. Vuelva intenarlo',
            {
              nzPlacement: 'top',
            }
          );
        }
      );
    }
  }
}
