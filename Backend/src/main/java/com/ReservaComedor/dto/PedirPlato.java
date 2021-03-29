package com.ReservaComedor.dto;

import javax.persistence.*;

/**
 * @author Vyacheslav Khaydorov
 * @author Miguel A. Sastre
 * @author Ingrid Dominguez
 */


@Entity
@Table(name = "pedirplatos")
public class PedirPlato {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;
	
	//Atributos
	@ManyToOne
	@JoinColumn(name = "idReserva")
    private Reserva IdReserva;
	
	@ManyToOne
	@JoinColumn(name = "IdPlato")
    private Platos IdPlato;
	@Column(name = "CantidadPlatos")
	private int CantidadPlatos;
	
	
	public PedirPlato() {}


	/**
	 * @param id
	 * @param idReserva
	 * @param idPlato
	 * @param cantidadPlatos
	 */
	public PedirPlato(Long id, Reserva idReserva, Platos idPlato, int cantidadPlatos) {
		this.id = id;
		IdReserva = idReserva;
		IdPlato = idPlato;
		CantidadPlatos = cantidadPlatos;
	}


	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}


	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}


	/**
	 * @return the idReserva
	 */
	public Reserva getIdReserva() {
		return IdReserva;
	}


	/**
	 * @param idReserva the idReserva to set
	 */
	public void setIdReserva(Reserva idReserva) {
		IdReserva = idReserva;
	}


	/**
	 * @return the idPlato
	 */
	public Platos getIdPlato() {
		return IdPlato;
	}


	/**
	 * @param idPlato the idPlato to set
	 */
	public void setIdPlato(Platos idPlato) {
		IdPlato = idPlato;
	}


	/**
	 * @return the cantidadPlatos
	 */
	public int getCantidadPlatos() {
		return CantidadPlatos;
	}


	/**
	 * @param cantidadPlatos the cantidadPlatos to set
	 */
	public void setCantidadPlatos(int cantidadPlatos) {
		CantidadPlatos = cantidadPlatos;
	}


	@Override
	public String toString() {
		return "PedirPlato [id=" + id + ", CantidadPlatos=" + CantidadPlatos + "]";
	}

	

}
