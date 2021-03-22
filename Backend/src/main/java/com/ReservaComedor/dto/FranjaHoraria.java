package com.ReservaComedor.dto;



import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @author Vyacheslav Khaydorov
 * @author Miguel A. Sastre
 * @author Ingrid Dominguez
 */
@Entity
@Table(name = "franjahoraria")
public class FranjaHoraria {
	
	//Atributos
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	//Busca el ultimo valor e incrementa desde el ID final de la BD
	@Column(name = "IdFranja")
	private int idFranja;
	@Column(name = "CapacidadMax")
	private int capacidadMax; 
	@Column(name = "OcupacionTotal")
	private int ocupacionTotal;
	@Column(name = "FranjaInicio")
	@Temporal(TemporalType.TIME)	//Atributo de tipo DATE
	private java.util.Date franjaInicio;
	@Column(name = "FranjaFin")
	@Temporal(TemporalType.TIME)	//Atributo de tipo DATE
	private java.util.Date franjaFin;
	
	@OneToMany
	@JoinColumn(name = "IdFranja")	//Conexion a la clave foranea en la tabla reserva
	private List<Reserva> reserva;
	
	//Constructores
	/**
	 * 
	 */
	public FranjaHoraria() {
	}

	/**
	 * @param idFranja
	 * @param capacidadMax
	 * @param ocupacionTotal
	 * @param franjaInicio
	 * @param franjaFin
	 * @param reserva
	 */
	public FranjaHoraria(int idFranja, int capacidadMax, int ocupacionTotal, Date franjaInicio, Date franjaFin,
			List<Reserva> reserva) {
		this.idFranja = idFranja;
		this.capacidadMax = capacidadMax;
		this.ocupacionTotal = ocupacionTotal;
		this.franjaInicio = franjaInicio;
		this.franjaFin = franjaFin;
		this.reserva = reserva;
	}

	//Getters y setters
	/**
	 * @return the idFranja
	 */
	public int getIdFranja() {
		return idFranja;
	}

	/**
	 * @param idFranja the idFranja to set
	 */
	public void setIdFranja(int idFranja) {
		this.idFranja = idFranja;
	}

	/**
	 * @return the capacidadMax
	 */
	public int getCapacidadMax() {
		return capacidadMax;
	}

	/**
	 * @param capacidadMax the capacidadMax to set
	 */
	public void setCapacidadMax(int capacidadMax) {
		this.capacidadMax = capacidadMax;
	}

	/**
	 * @return the ocupacionTotal
	 */
	public int getOcupacionTotal() {
		return ocupacionTotal;
	}

	/**
	 * @param ocupacionTotal the ocupacionTotal to set
	 */
	public void setOcupacionTotal(int ocupacionTotal) {
		this.ocupacionTotal = ocupacionTotal;
	}

	/**
	 * @return the franjaInicio
	 */
	public java.util.Date getFranjaInicio() {
		return franjaInicio;
	}

	/**
	 * @param franjaInicio the franjaInicio to set
	 */
	public void setFranjaInicio(java.util.Date franjaInicio) {
		this.franjaInicio = franjaInicio;
	}

	/**
	 * @return the franjaFin
	 */
	public java.util.Date getFranjaFin() {
		return franjaFin;
	}

	/**
	 * @param franjaFin the franjaFin to set
	 */
	public void setFranjaFin(java.util.Date franjaFin) {
		this.franjaFin = franjaFin;
	}

	/**
	 * @return the reserva
	 */
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "Reserva")
	public List<Reserva> getReserva() {
		return reserva;
	}

	/**
	 * @param reserva the reserva to set
	 */
	public void setReserva(List<Reserva> reserva) {
		this.reserva = reserva;
	}

	//toString
	@Override
	public String toString() {
		return "FranjaHoraria [IdFranja=" + idFranja + ", CapacidadMax=" + capacidadMax + ", OcupacionTotal="
				+ ocupacionTotal + ", FranjaInicio=" + franjaInicio + ", FranjaFin=" + franjaFin + "]";
	}
	
	
	
	
	
}
