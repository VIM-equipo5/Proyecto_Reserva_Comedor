import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import * as jQuery from 'jquery';

@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.css']
})
export class AdminComponent implements OnInit {


  constructor(private router: Router) { }

  ngOnInit(): void {
  }
  
  
  gestionPlatos(): void{
    let gestion = jQuery('#gestion');
    gestion.html("<app-gestion-platos></app-gestion-platos>");
 
  }

  gestionReservas(): void{
    this.router.navigate(["gestionReservas"]);
  }

  gestionUsuarios(): void{
    this.router.navigate(["gestionReservas"]);
  }

}
