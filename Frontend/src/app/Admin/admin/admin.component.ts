import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

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
    this.router.navigate(["gestionPlatos"]);
  }

  gestionReservas(): void{
    this.router.navigate(["gestionReservas"]);
  }

  gestionUsuarios(): void{
    this.router.navigate(["gestionUsuarios"]);
  }

}
