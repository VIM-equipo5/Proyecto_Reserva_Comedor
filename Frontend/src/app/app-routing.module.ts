import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './home/home/home.component';
import { ProductoComponent } from './home/modal/producto/producto.component';
import { LoginComponent } from './Login/login/login.component';
import { RegisterComponent } from './Login/register/register.component';
import { AdminComponent} from './Admin/admin/admin.component';
import { NotFoundComponent } from './not-found/not-found.component';

const routes: Routes = [
  {path:'', pathMatch:'full',redirectTo:'login' },
  {path:'home',component:HomeComponent},
  {path:'login',component:LoginComponent},
  {path:'logup',component:RegisterComponent},
  {path:'modal',component:ProductoComponent},
  {path:'admin',component:AdminComponent},
  {path: '**',component: NotFoundComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
