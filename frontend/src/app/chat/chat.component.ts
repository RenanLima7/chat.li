import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { StorageService } from '../storage.service';
import { User } from '../user';

@Component({
  selector: 'app-chat',
  templateUrl: './chat.component.html',
  styleUrls: ['./chat.component.css']
})
export class ChatComponent implements OnInit {

  users: User[] = [];
  userName: string = '';
  userAvatar: string = '';
  message: string = '';

  constructor(private storageService: StorageService, private route: ActivatedRoute) { }

  ngOnInit(): void {
    if (!this.storageService.get('@user:email')) {
      this.userName = '';
      this.userAvatar = '';
      return;
    }

    const id = parseInt(this.route.snapshot.paramMap.get('id')!, 10);
    console.log({ id });
    
    this.userName = this.storageService.get('@user:email') || '';
    this.userAvatar = 'https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Ftse1.mm.bing.net%2Fth%3Fid%3DOIP.uuLTfEMXFApAiu9mcTRhhgHaHa%26pid%3DApi&f=1'
  }

  sendMessage() {
    console.log({ message: this.message })
  }

}
