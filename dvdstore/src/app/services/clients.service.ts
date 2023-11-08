import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';

export interface Client{
  id?: number;
  email: string;
  name: string
}

@Injectable({
  providedIn: 'root'
})

export class ClientsService {

  constructor(private http: HttpClient) { }

   // Función para obtener los encabezados con el token JWT
   private getHeaders(): HttpHeaders {
    const token = sessionStorage.getItem('token');
    return new HttpHeaders({
      'Authorization': `Bearer ${token}`
    });
  }

getAll(): Observable<Array<Client>>{
  return this.http.get('http://localhost:9000/clients', { headers: this.getHeaders() }) as Observable<Array<Client>>;
}

getById(id: number): Observable<Client>{
return this.http.get(`http://localhost:9000/clients/${id}`, { headers: this.getHeaders() }) as Observable<Client>;
}
}