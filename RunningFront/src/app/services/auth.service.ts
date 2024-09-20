import { HttpClient, HttpHeaders } from '@angular/common/http';
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
  
  getUserById(id: number): Observable<User> {
    return this.http.get<User>(`${this.url}/getUser/${id}`);
  }

  updateUser(id: number, user: User): Observable<User> {
    return this.http.put<User>(`${this.url}/updateUser/${id}`, user);
  }

  getAuthenticatedUser(): Observable<number> {
    const headers = new HttpHeaders({
      'Content-Type': 'application/json',
      'Authorization': `Bearer ${localStorage.getItem('token')}`
    });

    return this.http.get<number>(`${this.url}/user-id`, { headers });
  }

}
