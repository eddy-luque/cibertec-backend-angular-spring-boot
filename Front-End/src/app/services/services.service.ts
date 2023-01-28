import {
  HttpClient,
  HttpHeaders,
} from '@angular/common/http';
import { delay, retry } from 'rxjs/operators';

import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

const api = 'http://localhost:8090/api/v1/';

@Injectable({
  providedIn: 'root',
})
export class ServicesService {
  constructor(private http: HttpClient) {}

  private setHeaders(respType: 'text'| 'blob' | 'json' | 'arraybuffer', contentType?: string): object {
    contentType = !contentType ? 'application/json' : contentType;
    const httpOptions = {
      headers: new HttpHeaders({
        'Access-Control-Allow-Origin': '*',
        'Access-Control-Allow-Headers': 'Content-Type',
        'Access-Control-Allow-Methods': 'GET, POST, OPTIONS, DELETE, PUT',
      }),
      responseType: respType,
    };
    if (contentType) {
      httpOptions.headers.append('Content-Type', contentType);
    }
    return httpOptions;
  }

  public postQuery<T>(
    body: any,
    nameService: string,
    respType?: 'text'| 'blob' | 'json' | 'arraybuffer',
    contentType?: string,
    millSeconds?: number
  ): Observable<T> {
    const url = `${api}${nameService}`;
    if (!respType) {
      respType = 'json';
    }
    const header = this.setHeaders(respType, contentType);

    if (!millSeconds) {
      millSeconds = 200;
    }
    return this.http
      .post<T>(url, body, header)
      .pipe(delay(millSeconds), retry(3));
  }

  public getQuery<T>(
    query: any,
    respType?: 'text'| 'blob' | 'json' | 'arraybuffer',
    contentType?: string,
    millSeconds?: number
  ): Observable<T> {
    query = `${api}${query}`;

    if (!respType) {
      respType = 'json';
    }
    if (!millSeconds) {
      millSeconds = 200;
    }
    const header = this.setHeaders(respType, contentType);
    return this.http.get<T>(query, header).pipe(delay(millSeconds), retry(3));
  }
}
