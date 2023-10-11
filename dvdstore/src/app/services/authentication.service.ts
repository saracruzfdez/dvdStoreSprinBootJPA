import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { BehaviorSubject, Observable } from 'rxjs';

export interface AuthRequest {
  username: string;
  password: string;
}

@Injectable({
  providedIn: 'root'
})

export class AuthenticationService {

  private loggedIn = new BehaviorSubject<boolean>(false);

  isAuthenticated(): Observable<boolean> {
    return this.loggedIn.asObservable()
  }

  constructor(private http: HttpClient) {
    this.loggedIn.next(this.getToken() !== null)
  }
  
  getToken() {
    return sessionStorage.getItem('token');
  }

  authorize(authRequest: AuthRequest): Observable<any> {
    return this.http.post('http://localhost:9000/authorize', authRequest);
  }
}