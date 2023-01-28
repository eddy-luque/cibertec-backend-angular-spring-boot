import {
  HttpEvent,
  HttpHandler,
  HttpInterceptor,
  HttpRequest
} from '@angular/common/http';

import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Router } from '@angular/router';

@Injectable()
export class InterceptorsInterceptor implements HttpInterceptor {

  constructor(
    private route: Router
  ) {}

  intercept(request: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
    const routes = this.route.url.includes('login')
    if(!routes){
      const token = localStorage.getItem('_token') || null;
      if(token){
        request = request.clone({
          setHeaders: {
            Authorization: `Bearer ${token}`
          }
        });
      }
    }
    return next.handle(request);
  }
}
