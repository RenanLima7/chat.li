import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, of, tap } from 'rxjs';
import { User } from './user';

@Injectable({
  providedIn: 'root'
})
export class HomeService {

  private heroesUrl = 'https://jsonplaceholder.typicode.com/users';  // URL to web api

  httpOptions = {
    headers: new HttpHeaders({ 'Content-Type': 'application/json' })
  };

  constructor(private http: HttpClient) { }

  getUsers(): Observable<User[]> {
    console.log(this.http.get<User[]>(this.heroesUrl));
    return this.http.get<User[]>(this.heroesUrl)
      .pipe(
        tap(_ => console.log('err')),
      );
  }


  searchUsers(term: string): Observable<User[]> {
    if (!term.trim()) {
      // if not search term, return empty hero array.
      return of([]);
    }


    return this.http.get<User[]>(`${this.heroesUrl}/?search=${term}`).pipe(
      tap(x => x.length ?
        console.log(``) :
        console.log(``)),
    );
  }
}
