import { EventEmitter, Injectable, Output } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class StateService {

  constructor() { }

  @Output() isLogIn : EventEmitter<boolean> = new EventEmitter();



}
