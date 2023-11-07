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

  //private loggedIn = new BehaviorSubject<boolean>(false);

  is_auth = (): boolean => {
    return this.getToken();
  }

  // isAuthenticated(): Observable<boolean> {
  //   return this.loggedIn.asObservable()
  // }

  constructor(private http: HttpClient) {
    //this.loggedIn.next(this.getToken())
  }

  // Login
  authorize(authRequest: AuthRequest): Observable<any> {
    return this.http.post('http://localhost:9000/authorize', authRequest);
  }

  getToken(): boolean {
    const token = sessionStorage.getItem('token');
    return token !== null;
  }

  setToken = (token: string) => {
    sessionStorage.setItem('token', token);
  }

  getUser = () => {
    const userParse = sessionStorage.getItem("user");
    if(userParse !== null){
      return JSON.parse(userParse);
    }
    return null;
  }

  setUser = (user: any) => {
    const userJSON = JSON.stringify(user);
    sessionStorage.setItem('user', userJSON);
  }

  logout = () => {
    sessionStorage.removeItem("token");
    sessionStorage.removeItem("user");
    
  }




}