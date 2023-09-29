import { Injectable } from '@angular/core';
import{HttpClient} from '@angular/common/http';
import { Observable } from 'rxjs';

export interface Dvd{
  id? : number,
  name : string,
  genre : string,
  quantity : number,
  prix : number,
  image_path : string,
}
@Injectable({
  providedIn: 'root'
})

export class DvdsService {

  constructor(private http: HttpClient) {}

  getAll(): Observable<Array<Dvd>> {

    return this.http.get('http://localhost:9000/dvds') as Observable<Array<Dvd>>;
    
  }

}