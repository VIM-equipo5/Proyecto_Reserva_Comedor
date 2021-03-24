import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './home/home/home.component';
import { ModalProductoComponent } from './home/Modal/modal-producto/modal-producto.component';
import { NavbarComponent } from './home/navbar/navbar.component';
import { LoginComponent } from './Login/login/login.component';
import { RegisterComponent } from './Login/register/register.component';
import { Slider1Component } from './home/slider/slider1/slider1.component';
import { Slider2Component } from './home/slider/slider2/slider2.component';
import { Slider3Component } from './home/slider/slider3/slider3.component';
import { Slider4Component } from './home/slider/slider4/slider4.component';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    LoginComponent,
    RegisterComponent,
    NavbarComponent,
    ModalProductoComponent,
    Slider1Component,
    Slider2Component,
    Slider3Component,
    Slider4Component
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
