import { HttpClientModule } from '@angular/common/http';
import { NgModule } from '@angular/core';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './home/home/home.component';
import { NavbarComponent } from './home/navbar/navbar.component';
import { LoginComponent } from './Login/login/login.component';
import { RegisterComponent } from './Login/register/register.component';
import { ProductoComponent } from './home/modal/producto/producto.component';
import { AdminComponent } from './Admin/admin/admin.component';
import { FooterComponent } from './home/footer/footer.component';
import { GestionPlatosComponent } from './Admin/gestion-platos/gestion-platos.component';
import { GestionReservasComponent } from './Admin/gestion-reservas/gestion-reservas.component';
import { GestionUsuariosComponent } from './Admin/gestion-usuarios/gestion-usuarios.component';
import { CestoComponent } from './home/modal/cesto/cesto.component';
import { DetallesCuentaComponent } from './home/modal/detalles-cuenta/detalles-cuenta.component';
import { ReservasUsuarioComponent } from './home/modal/reservas-usuario/reservas-usuario.component';
import { NotFoundComponent } from './not-found/not-found.component';
import { NgxSpinnerModule } from 'ngx-spinner';
import { GestionBebidasComponent } from './Admin/gestion-bebidas/gestion-bebidas.component';
import { GestionService } from './Admin/service/gestion.service';
import { CrearPlatoComponent } from './Admin/modal/crear-plato/crear-plato.component';
import { CrearBebidaComponent } from './Admin/modal/crear-bebida/crear-bebida.component';
import { DataTablesModule } from 'angular-datatables';
import { ActualizarBebidaComponent } from './Admin/modal/actualizar-bebida/actualizar-bebida.component';
import { ActualizarPlatoComponent } from './Admin/modal/actualizar-plato/actualizar-plato.component';
import { ActualizarUsuarioComponent } from './Admin/modal/actualizar-usuario/actualizar-usuario.component';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    LoginComponent,
    RegisterComponent,
    NavbarComponent,
    ProductoComponent,
    AdminComponent,
    FooterComponent,
    GestionPlatosComponent,
    GestionReservasComponent,
    GestionUsuariosComponent,
    CestoComponent,
    DetallesCuentaComponent,
    ReservasUsuarioComponent,
    NotFoundComponent,
    GestionBebidasComponent,
    CrearPlatoComponent,
    CrearBebidaComponent,
    ActualizarBebidaComponent,
    ActualizarPlatoComponent,
    ActualizarUsuarioComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    NgbModule,
    ReactiveFormsModule,
    NgxSpinnerModule,
    BrowserModule,
    DataTablesModule
  ],
  providers: [GestionService],
  bootstrap: [AppComponent]
})
export class AppModule { }
