import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
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

getAll(): Observable<Array<Client>>{
  return this.http.get('http://localhost:9000/clients') as Observable<Array<Client>>;
}

getById(id: number): Observable<Client>{
return this.http.get(`http://localhost:9000/clients/${id}`) as Observable<Client>;
}
}