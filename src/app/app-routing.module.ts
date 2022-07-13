import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { LoginComponent } from './login/login.component';
import { AuthenticatedGuard } from './authenticated.guard';
import { RegisterComponent } from './register/register.component';
import { HomeComponent } from './home/home.component';
import { AddAmigosComponent } from './add-amigos/add-amigos.component';
import { ChatMessageComponent } from './chat-message/chat-message.component';

const routes: Routes = [
  { path: '', redirectTo: '/login', pathMatch: 'full' },
  { path: 'login', component: LoginComponent },
  { path: 'cadastro', component: RegisterComponent },
  { path: 'home', component: HomeComponent, canActivate: [AuthenticatedGuard] },
  { path: 'chat/:id', component: ChatMessageComponent, canActivate: [AuthenticatedGuard] },
  { path: 'add-amigos', component: AddAmigosComponent, canActivate: [AuthenticatedGuard] },
];

@NgModule({
  imports: [ RouterModule.forRoot(routes) ],
  exports: [ RouterModule ]
})
export class AppRoutingModule {}
