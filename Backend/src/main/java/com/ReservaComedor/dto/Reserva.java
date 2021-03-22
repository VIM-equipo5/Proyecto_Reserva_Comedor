package com.ReservaComedor.dto;

import java.util.Date;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;



/**
 * @author Vyacheslav Khaydorov
 * @author Miguel A. Sastre
 * @author Ingrid Dominguez
 */

@Entity
@Table(name="reserva")
public class Reserva {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idReserva;

	private Long cantidadComensales;
	private Double precioTotal;
	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaReserva;
	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaReservada;
	
	@OneToMany
	@JoinColumn(name = "idReserva")
	private List<PedirPlato> pedirPlato;
	
	@ManyToOne
    @JoinColumn(name = "idUsuario")
    Usuario usuario;
 
    @ManyToOne
    @JoinColumn(name = "idFranja")
    FranjaHoraria franjaHoraria;
    
    public Reserva() {}
    
	/**
	 * @param idUsuario
	 * @param cantidadComensales
	 * @param precioTotal
	 * @param fechaReserva
	 * @param fechaReservada
	 * @param pedirPlato
	 * @param usuario
	 * @param franjaHoraria
	 */
	public Reserva(Long idUsuario, Long cantidadComensales, Double precioTotal, Date fechaReserva, Date fechaReservada,
			List<PedirPlato> pedirPlato, Usuario usuario, FranjaHoraria franjaHoraria) {
		this.idReserva = idUsuario;
		this.cantidadComensales = cantidadComensales;
		this.precioTotal = precioTotal;
		this.fechaReserva = fechaReserva;
		this.fechaReservada = fechaReservada;
		this.pedirPlato = pedirPlato;
		this.usuario = usuario;
		this.franjaHoraria = franjaHoraria;
	}

	/**
	 * @return the idUsuario
	 */
	public Long getIdReserva() {
		return idReserva;
	}

	/**
	 * @param idUsuario the idUsuario to set
	 */
	public void setIdReserva(Long idUsuario) {
		this.idReserva = idUsuario;
	}

	/**
	 * @return the cantidadComensales
	 */
	public Long getCantidadComensales() {
		return cantidadComensales;
	}

	/**
	 * @param cantidadComensales the cantidadComensales to set
	 */
	public void setCantidadComensales(Long cantidadComensales) {
		this.cantidadComensales = cantidadComensales;
	}

	/**
	 * @return the precioTotal
	 */
	public Double getPrecioTotal() {
		return precioTotal;
	}

	/**
	 * @param precioTotal the precioTotal to set
	 */
	public void setPrecioTotal(Double precioTotal) {
		this.precioTotal = precioTotal;
	}

	/**
	 * @return the fechaReserva
	 */
	public Date getFechaReserva() {
		return fechaReserva;
	}

	/**
	 * @param fechaReserva the fechaReserva to set
	 */
	public void setFechaReserva(Date fechaReserva) {
		this.fechaReserva = fechaReserva;
	}

	/**
	 * @return the fechaReservada
	 */
	public Date getFechaReservada() {
		return fechaReservada;
	}

	/**
	 * @param fechaReservada the fechaReservada to set
	 */
	public void setFechaReservada(Date fechaReservada) {
		this.fechaReservada = fechaReservada;
	}

	/**
	 * @return the pedirPlato
	 */
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "pedirplatos")
	public List<PedirPlato> getPedirPlato() {
		return pedirPlato;
	}

	/**
	 * @param pedirPlato the pedirPlato to set
	 */
	public void setPedirPlato(List<PedirPlato> pedirPlato) {
		this.pedirPlato = pedirPlato;
	}

	/**
	 * @return the usuario
	 */
	public Usuario getUsuario() {
		return usuario;
	}

	/**
	 * @param usuario the usuario to set
	 */
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	/**
	 * @return the franjaHoraria
	 */
	public FranjaHoraria getFranjaHoraria() {
		return franjaHoraria;
	}

	/**
	 * @param franjaHoraria the franjaHoraria to set
	 */
	public void setFranjaHoraria(FranjaHoraria franjaHoraria) {
		this.franjaHoraria = franjaHoraria;
	}

	@Override
	public String toString() {
		return "Reserva [idUsuario=" + idReserva + ", cantidadComensales=" + cantidadComensales + ", precioTotal="
				+ precioTotal + ", fechaReserva=" + fechaReserva + ", fechaReservada=" + fechaReservada
				+ ", pedirPlato=" + pedirPlato + ", usuario=" + usuario + ", franjaHoraria=" + franjaHoraria + "]";
	}
}
