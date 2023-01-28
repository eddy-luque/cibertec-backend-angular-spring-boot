import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

import { NzNotificationService } from 'ng-zorro-antd/notification';
import { Router } from '@angular/router';
import { ServicesService } from './services/services.service';
import { StateService } from './services/state.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss'],
})
export class AppComponent implements OnInit {
  isLogin!: boolean;
  title = 'app-prestamo';

  constructor(private state: StateService, private router: Router) {
    this.state.isLogIn.subscribe((state) => {
      if (state) {
        this.isLogin = true;
      }else{
        this.isLogin = false;
      }
    });
  }
  ngOnInit(): void {}

  logout() {
    this.state.isLogIn.emit(false)
    localStorage.clear();
    this.router.navigate(['/login']);
  }
}
