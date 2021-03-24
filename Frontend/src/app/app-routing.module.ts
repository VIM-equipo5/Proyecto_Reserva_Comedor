import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './home/home/home.component';
import { LoginComponent } from './Login/login/login.component';
import { RegisterComponent } from './Login/register/register.component';

const routes: Routes = [
  {path:'', pathMatch:'full',redirectTo:'login' },
  {path:'home',component:HomeComponent},
  {path:'login',component:LoginComponent},
  {path:'logup',component:RegisterComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
