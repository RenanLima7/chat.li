import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { StorageService } from '../storage.service';

interface Message {
  id_to: number;
  id_from: number;
  content: string;
}

@Component({
  selector: 'app-chat-message',
  templateUrl: './chat-message.component.html',
  styleUrls: ['./chat-message.component.css']
})
export class ChatMessageComponent implements OnInit {

  userName: string = '';
  userAvatar: string = '';
  message: string = '';
  messages: Message[] = [];
  id: number = 0;
  
    constructor(private storageService: StorageService, private route: ActivatedRoute) { }
  
    ngOnInit(): void {
      if (!this.storageService.get('@user:email')) {
        this.userName = '';
        this.userAvatar = '';
        return;
      }
  
      this.id = parseInt(this.route.snapshot.paramMap.get('id')!, 10);
      
      this.userName = this.storageService.get('@user:email') || '';
      this.userAvatar = 'https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Ftse1.mm.bing.net%2Fth%3Fid%3DOIP.uuLTfEMXFApAiu9mcTRhhgHaHa%26pid%3DApi&f=1'
    }
  
    sendMessage() {
     this.messages.push({
       content: this.message,
       id_from: this.id,
       id_to: 900
     })
     this.message = '';
    }

    showFrom(message: Message): boolean {
      if(message.id_from === this.id) {
        console.log(message.id_from);
        return true;
      }
      
      return false;
    }
  }
