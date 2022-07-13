import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { API_URL } from 'src/environments/API_URL';
import { User } from './user';

@Injectable({
  providedIn: 'root'
})
export class RegisterService {

  constructor(private http: HttpClient) { }

  register({ avatar, email, genre, name, password }: any) {
    const data = {
      avatar, email, genre, name, password
    };

    return this.http.post<Object>(API_URL, data);
  }
}
