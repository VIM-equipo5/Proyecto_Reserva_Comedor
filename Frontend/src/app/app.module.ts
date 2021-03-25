import { HttpClientModule } from '@angular/common/http';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './home/home/home.component';
import { NavbarComponent } from './home/navbar/navbar.component';
import { LoginComponent } from './Login/login/login.component';
import { RegisterComponent } from './Login/register/register.component';


import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { ProductoComponent } from './home/modal/producto/producto.component';
import { Slider1Component } from './home/slider/slider1/slider1.component';
import { Slider2Component } from './home/slider/slider2/slider2.component';
import { Slider3Component } from './home/slider/slider3/slider3.component';
import { Slider4Component } from './home/slider/slider4/slider4.component';
import { AdminComponent } from './Admin/admin/admin.component';
import { GestionUsuariosComponent } from './Admin/gestion-usuarios/gestion-usuarios.component';
import { GestionPlatosComponent } from './Admin/gestion-platos/gestion-platos.component';
import { GestionReservasComponent } from './Admin/gestion-reservas/gestion-reservas.component';
import { Slider5Component } from './home/slider/slider5/slider5.component';
import { FooterComponent } from './home/footer/footer.component';



@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    LoginComponent,
    RegisterComponent,
    NavbarComponent,
    ProductoComponent,
    Slider1Component,
    Slider2Component,
    Slider3Component,
    Slider4Component,
    AdminComponent,
    GestionUsuariosComponent,
    GestionPlatosComponent,
    GestionReservasComponent,
    Slider5Component
    FooterComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    NgbModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
