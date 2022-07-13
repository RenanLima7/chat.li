import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Subject } from 'rxjs';
import { HomeService } from '../home.service';
import { StorageService } from '../storage.service';
import { User } from '../user';

@Component({
  selector: 'app-add-amigos',
  templateUrl: './add-amigos.component.html',
  styleUrls: ['./add-amigos.component.css']
})
export class AddAmigosComponent implements OnInit {

  users: User[] = [];
  userName: string = '';
  userAvatar: string = '';

  constructor(private home: HomeService, private storageService: StorageService, private router: Router) { }

  ngOnInit(): void {
    if (!this.storageService.get('@user:email')) {
      this.userName = '';
      this.userAvatar = ''
      return;
    }

    //this.getHeroes();
    
    this.userName = this.storageService.get('@user:email') || '';
    this.userAvatar = 'https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Ftse1.mm.bing.net%2Fth%3Fid%3DOIP.uuLTfEMXFApAiu9mcTRhhgHaHa%26pid%3DApi&f=1'
  
  }

  getHeroes(): void {    
    this.home.getUsers()
      .subscribe(users => this.users = users);
  }

  search(term: string): void {
   
  }

  navigateAddAmigos() {
    this.router.navigate(['add-amigos'])
  }

}
