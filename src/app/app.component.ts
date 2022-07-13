import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { StorageService } from './storage.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  userName: string = '';
  userAvatar: string = '';

  constructor (private storageService: StorageService, private router: Router) {}

  ngOnInit() {
    if (this.storageService.get('@chatly:user')) {
      this.userName = '';
      this.userAvatar = ''
      return;
    }

    this.userName = 'Jairo';
    this.userAvatar = 'https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Ftse1.mm.bing.net%2Fth%3Fid%3DOIP.uuLTfEMXFApAiu9mcTRhhgHaHa%26pid%3DApi&f=1'
  }
}
