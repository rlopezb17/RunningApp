import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { User } from '../interfaces/user';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  private url = "http://localhost:8080/api/auth"


  constructor(private http: HttpClient) { }
  
  
  register(user: User): Observable<User> {
    return this.http.post<User>(`${this.url}/register`, user);
  }
  
  login(email: string, password: string): Observable<User> {
    const credentials = { email, password };
    return this.http.post<User>(`${this.url}/login`, credentials);
  }
  

}
