import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import * as jQuery from 'jquery';

@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.css']
})
export class AdminComponent implements OnInit {

  platos = false;
  reservas = false;
  usuarios = false;

  estados = [false,false,false];

  constructor(private router: Router) { }

  ngOnInit(): void {
  }
  
  negarTodos(): void {
    this.estados = [false,false,false];
  }
  
  mostrar(idx: number): void{
    this.negarTodos();
    this.estados[idx] = true;
  }
}
