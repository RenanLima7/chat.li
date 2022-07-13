import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { debounceTime, distinctUntilChanged, Observable, Subject, switchMap } from 'rxjs';
import { HomeService } from '../home.service';
import { StorageService } from '../storage.service';
import { User } from '../user';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  users: User[] = [];
  private searchTerms = new Subject<string>();

  userName: string = '';
  userAvatar: string = '';
  message: string = ''

  constructor(private storageService: StorageService, private home: HomeService, private router: Router) { }

  ngOnInit(): void {
    if (!this.storageService.get('@user:email')) {
      this.userName = '';
      this.userAvatar = ''
      return;
    }
    
    this.userName = this.storageService.get('@user:email') || '';
    this.userAvatar = 'https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Ftse1.mm.bing.net%2Fth%3Fid%3DOIP.uuLTfEMXFApAiu9mcTRhhgHaHa%26pid%3DApi&f=1'
    this.getHeroes();

  }

  getHeroes(): void {
    this.home.getUsers()
      .subscribe(users => this.users = users);      
  }

  // Push a search term into the observable stream.
  search(term: string): void {
   
  }

  navigateAddAmigos() {
    this.router.navigate(['add-amigos'])
  }

}
