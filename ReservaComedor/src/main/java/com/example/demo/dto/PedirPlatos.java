package com.example.demo.dto;

import java.sql.Blob;

import javax.persistence.*;

import src.main.java.com.ReservaComedor.dto.JoinColumn;
import src.main.java.com.ReservaComedor.dto.List;
import src.main.java.com.ReservaComedor.dto.OneToMany;
import src.main.java.com.ReservaComedor.dto.Reserva;

@Entity
@Table(name = "pedirplatos")
public class PedirPlatos {
	//Atributos
	@JoinColumn(name = "idReserva")
    @ManyToOne
    private Reserva IdReserva;
	@JoinColumn(name = "IdPlato")
    @ManyToOne
    private Platos IdPlato;
	@Column(name = "CantidadPlatos")
	private int CantidadPlatos;
	
	//Constructor
	public PedirPlatos(com.example.demo.dto.Reserva idReserva, Platos idPlato, int cantidadPlatos) {
		super();
		IdReserva = idReserva;
		IdPlato = idPlato;
		CantidadPlatos = cantidadPlatos;
	}

	//Getters y Setters
	public Reserva getIdReserva() {
		return IdReserva;
	}

	public void setIdReserva(Reserva idReserva) {
		IdReserva = idReserva;
	}

	public Platos getIdPlato() {
		return IdPlato;
	}

	public void setIdPlato(Platos idPlato) {
		IdPlato = idPlato;
	}

	public int getCantidadPlatos() {
		return CantidadPlatos;
	}

	public void setCantidadPlatos(int cantidadPlatos) {
		CantidadPlatos = cantidadPlatos;
	}

	//toString
	@Override
	public String toString() {
		return "PedirPlatos [IdPlato=" + IdPlato + ", CantidadPlatos=" + CantidadPlatos + "]";
	}


}
