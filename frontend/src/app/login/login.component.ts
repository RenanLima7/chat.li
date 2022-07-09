import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { LoginService } from '../login.service';
import { StorageService } from '../storage.service';

@Component({
  selector: 'app-root',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {

  email: string = '';
  password: string = '';
  loginFailMessage: string = '';

  constructor(private loginService: LoginService,
    private router: Router,
    private localStorage: StorageService) { }


  login(){
    //this.loginService.login(this.username, this.password).subscribe((user) => {
      //this.localStorage.set('authorization', btoa(this.username + ':' + this.password));
      console.log({ email: this.email, password: this.password })
      this.router.navigate(['/dashboard']);
    //}, (error) => {
     // this.loginFailMessage = 'Usuario ou senha invalidos. Tente novamente';
   // });

  }
}
