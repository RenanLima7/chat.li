import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { API_URL } from '../environments/API_URL'

@Injectable({
  providedIn: 'root'
})

export class LoginService {


  constructor(private http: HttpClient) { }

  login(username: string, password: string) {
    const headers = new HttpHeaders(
      {
        authorization : 'Basic ' + btoa(username + ':' + password)
      }
    );
    return this.http.get<Object>(API_URL, { headers });
  }

}
