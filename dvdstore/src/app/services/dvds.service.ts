import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';

export interface Dvd {
  id?: number;
  name: string;
  genre: string;
  quantity: number;
  prix: number;
  image_path: string;
}

@Injectable({
  providedIn: 'root'
})
export class DvdsService {

  constructor(private http: HttpClient) { }



    // Función para obtener los encabezados con el token JWT
    private getHeaders(): HttpHeaders {
      const token = sessionStorage.getItem('token');
      return new HttpHeaders({
        'Authorization': `Bearer ${token}`
      });
    }



  getAll(): Observable<Array<Dvd>> {
    return this.http.get('http://localhost:9000/dvds') as Observable<Array<Dvd>>;
  }

  getById(id: number): Observable<Dvd> {
    return this.http.get(`http://localhost:9000/dvds/${id}`, { headers: this.getHeaders() }) as Observable<Dvd>;
  }


  deleteById(id: number): Observable<Dvd> {
    return this.http.delete(`http://localhost:9000/dvds/delete/${id}`, { headers: this.getHeaders() }) as Observable<Dvd>;
  }

  // Agregar o actualizar un DVD
  addOrUpdate(dvd: Dvd): Observable<Dvd> {
    if (dvd.id) {
      // Si el DVD tiene un ID, se considera una actualización
      return this.update(dvd);
    } else {
      // Si el DVD no tiene un ID, se considera una creación
      return this.add(dvd);
    }
  }

  // Agregar un nuevo DVD
  private add(newDvd: Dvd): Observable<Dvd> {
    // Realiza una solicitud HTTP POST para agregar el nuevo DVD
    return this.http.post('http://localhost:9000/dvds', newDvd, { headers: this.getHeaders() }) as Observable<Dvd>;
  }

  // Actualizar un DVD existente
  private update(dvd: Dvd): Observable<Dvd> {
    // Realiza una solicitud HTTP PUT para actualizar el DVD
    return this.http.put(`http://localhost:9000/dvds/update/${dvd.id}`, dvd, { headers: this.getHeaders() }) as Observable<Dvd>;
  }
}