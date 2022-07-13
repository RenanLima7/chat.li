import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { DashboardComponent } from './dashboard/dashboard.component';
import { HeroesComponent } from './heroes/heroes.component';
import { HeroDetailComponent } from './hero-detail/hero-detail.component';
import { LoginComponent } from './login/login.component';
import { AuthenticatedGuard } from './authenticated.guard';
import { RegisterComponent } from './register/register.component';
import { HomeComponent } from './home/home.component';
import { ChatComponent } from './chat/chat.component';
import { AddAmigosComponent } from './add-amigos/add-amigos.component';

const routes: Routes = [
  { path: '', redirectTo: '/login', pathMatch: 'full' },
  { path: 'login', component: LoginComponent },
  { path: 'cadastro', component: RegisterComponent },
  { path: 'home', component: HomeComponent, canActivate: [AuthenticatedGuard] },
  { path: 'chat/:id', component: ChatComponent, canActivate: [AuthenticatedGuard] },
  { path: 'add-amigos', component: AddAmigosComponent, canActivate: [AuthenticatedGuard] },
  { path: 'dashboard', component: DashboardComponent, canActivate: [AuthenticatedGuard] },
  { path: 'detail/:id', component: HeroDetailComponent, canActivate: [AuthenticatedGuard] },
  { path: 'heroes', component: HeroesComponent, canActivate: [AuthenticatedGuard] }
];

@NgModule({
  imports: [ RouterModule.forRoot(routes) ],
  exports: [ RouterModule ]
})
export class AppRoutingModule {}
