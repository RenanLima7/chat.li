import { Component, OnInit } from '@angular/core';
import { debounceTime, distinctUntilChanged, Observable, Subject, switchMap } from 'rxjs';
import { HomeService } from '../home.service';
import { User } from '../user';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  users: User[] = [];
  private searchTerms = new Subject<string>();
  constructor(private home: HomeService) { }



  ngOnInit(): void {
    this.getHeroes();
  }

  getHeroes(): void {
    this.home.getUsers()
      .subscribe(users => this.users = users);
  }

  // Push a search term into the observable stream.
  search(term: string): void {
   
  }

}
