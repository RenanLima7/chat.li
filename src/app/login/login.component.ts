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
      console.log('foi');
      
      //this.loginService.login(this.email, this.password).subscribe((user) => {
        //this.localStorage.set('authorization', btoa(this.email + ':' + this.password));
        //console.log({ email: this.email, password: this.password })
        this.localStorage.set('@user:email', this.email);
        this.router.navigate(['/home']);
      //}, (error) => {
        //this.loginFailMessage = 'Usuario ou senha invalidos. Tente novamente';
    //});

    }
}
