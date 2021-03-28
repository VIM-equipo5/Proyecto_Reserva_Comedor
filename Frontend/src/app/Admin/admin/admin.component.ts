import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import * as jQuery from 'jquery';

@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.css']
})
export class AdminComponent implements OnInit {

  main!: HTMLDivElement;
  mySidebar!: HTMLDivElement;
  openNav!: HTMLButtonElement;
  estados = [false,false,false,false];

  constructor(private router: Router) {
    
  }

  ngOnInit(): void {
    this.main = document.getElementById("main") as HTMLDivElement;
    this.mySidebar = document.getElementById("mySidebar") as HTMLDivElement;
    this.openNav = document.getElementById("openNav") as HTMLButtonElement;
  }
  
  negarTodos(): void {
    this.estados = [false,false,false,false];
  }
  
  mostrar(idx: number): void{
    this.negarTodos();
    this.estados[idx] = true;
  }

  w3_close() {
    this.main.style.marginLeft = "0%";
    this.mySidebar.style.display = "none";
    this.openNav.style.display = "inline-block";
  }

  w3_open() {
    this.main.style.marginLeft = "25%";
    this.mySidebar.style.width = "25%";
    this.mySidebar.style.display = "block";
    this.openNav.style.display = "none";
  }
  
  logout(){
    window.sessionStorage.removeItem("user");
    this.router.navigate(["/"]);
  }
}
