package com.ReservaComedor.dto;

/**
 * @author Vyacheslav Khaydorov
 * @author Miguel A. Sastre
 * @author Ingrid Dominguez
 */

import javax.persistence.*;


@Entity
@Table(name = "pedirplatos")
public class PedirPlato {
	//Atributos
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;
	
	@JoinColumn(name = "idReserva")
    @ManyToOne
    private Reserva IdReserva;
	@JoinColumn(name = "IdPlato")
    @ManyToOne
    private Plato IdPlato;
	@Column(name = "CantidadPlatos")
	private int CantidadPlatos;
	
	
	public PedirPlato() {}
	
	//Constructor
	public PedirPlato(Reserva idReserva, Plato idPlato, int cantidadPlatos) {
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

	public Plato getIdPlato() {
		return IdPlato;
	}

	public void setIdPlato(Plato idPlato) {
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
		return "PedirPlato [IdPlato=" + IdPlato + ", CantidadPlatos=" + CantidadPlatos + "]";
	}


}
