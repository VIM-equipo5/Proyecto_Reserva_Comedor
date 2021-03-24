import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css'],
})
export class NavbarComponent {

  menuActivo = false;
  id = "layoutSidenav";

  constructor() {}

  ngOnInit(): void {}

  desplegarMenuLateral(): void {
    console.log("hola")

    let boton = document.getElementById(this.id);
    if(!this.menuActivo){
      this.id = "layoutSidenav active";
      boton?.setAttribute("id", this.id);
      this.menuActivo = true;
    } else {
      this.id = "layoutSidenav";
      boton?.setAttribute("id", this.id);
      this.menuActivo = false;
    }
      
    
    
  }
}
