import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

export interface AuthRequest {
  username: string;
  password: string;
}

@Injectable({
  providedIn: 'root'
})
export class AthenticationService {

  constructor(private http: HttpClient) { }

  authorize(newAuthRequest: AuthRequest): Observable<any> {
    return this.http.post('http://localhost:9000/authorize', newAuthRequest);
  }
}