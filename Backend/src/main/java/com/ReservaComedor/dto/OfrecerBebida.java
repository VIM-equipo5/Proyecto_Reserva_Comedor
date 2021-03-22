/**
 * 
 */
package com.ReservaComedor.dto;

import javax.persistence.*;



/**
 * @author Vyacheslav Khaydorov
 * @author Miguel A. Sastre
 * @author Ingrid Dominguez
 */

@Entity
@Table(name = "ofrecerbebidas")
public class OfrecerBebida {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;
	
	private Long cantidadBebidas;
	
	@ManyToOne
    @JoinColumn(name = "idReserva")
    Reserva reserva;
 
    @ManyToOne
    @JoinColumn(name = "idBebida")
    Bebida bebida;
    
    public OfrecerBebida() {}
    
	/**
	 * @param id
	 * @param cantidadBebidas
	 * @param reserva
	 * @param bebida
	 */
	public OfrecerBebida(Long id, Long cantidadBebidas, Reserva reserva, Bebida bebida) {
		this.id = id;
		this.cantidadBebidas = cantidadBebidas;
		this.reserva = reserva;
		this.bebida = bebida;
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
	 * @return the cantidadBebidas
	 */
	public Long getCantidadBebidas() {
		return cantidadBebidas;
	}

	/**
	 * @param cantidadBebidas the cantidadBebidas to set
	 */
	public void setCantidadBebidas(Long cantidadBebidas) {
		this.cantidadBebidas = cantidadBebidas;
	}

	/**
	 * @return the reserva
	 */
	public Reserva getReserva() {
		return reserva;
	}

	/**
	 * @param reserva the reserva to set
	 */
	public void setReserva(Reserva reserva) {
		this.reserva = reserva;
	}

	/**
	 * @return the bebida
	 */
	public Bebida getBebida() {
		return bebida;
	}

	/**
	 * @param bebida the bebida to set
	 */
	public void setBebida(Bebida bebida) {
		this.bebida = bebida;
	}

	@Override
	public String toString() {
		return "OfrecerBebida [id=" + id + ", cantidadBebidas=" + cantidadBebidas + ", reserva=" + reserva + ", bebida="
				+ bebida + "]";
	}
}
