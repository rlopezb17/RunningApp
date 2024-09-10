import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Country } from '../interfaces/country';

@Injectable({
  providedIn: 'root'
})
export class GetsService {

  private url = "http://localhost:8080/api/get"

  constructor(private http: HttpClient) { }


  getAllCountries(): Observable<Country[]> {
    return this.http.get<Country[]>(`${this.url}/countries`);
  }

}
