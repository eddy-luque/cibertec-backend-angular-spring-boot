import {
  ActivatedRouteSnapshot,
  CanActivate,
  Router,
  RouterStateSnapshot,
  UrlTree,
} from '@angular/router';

import { Injectable } from '@angular/core';
import { JwtHelperService } from '@auth0/angular-jwt';
import { Observable } from 'rxjs';
import { StateService } from '../services/state.service';

@Injectable({
  providedIn: 'root',
})
export class SecurityGuardGuard implements CanActivate {
  constructor(
    private router: Router,
    private state:StateService
    ) {}

  canActivate(
    route: ActivatedRouteSnapshot,
    state: RouterStateSnapshot,
  ): boolean {
    const helper = new JwtHelperService();
    const token = localStorage.getItem('_token') || '';

    if (token) {
      const decodedToken = helper.decodeToken(token);
      const time = Math.floor(new Date().getTime() / 1000);
      if (time < decodedToken.exp) {
        this.state.isLogIn.emit(true)
        return true;
      }
    }
    this.state.isLogIn.emit(false)
    localStorage.clear();
    this.router.navigate(['/login']);
    return false;
  }
}
