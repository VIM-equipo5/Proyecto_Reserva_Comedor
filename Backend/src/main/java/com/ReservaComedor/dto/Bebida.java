/**
 * 
 */
package com.ReservaComedor.dto;

import java.util.List;
import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @author Vyacheslav Khaydorov
 * @author Miguel A. Sastre
 * @author Ingrid Dominguez
 */

@Entity
@Table(name = "bebidas")
public class Bebida {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idBebida")
	private Long idBebida;
	@Column(name="Nombre")
	private String nombre;
	@Column(name="PrecioUnitario")
	private Double precioUnitario;
	@Column(name="Imagen")
	private String imagen;
	@Column(name="Descripcion")
	private String descripcion;
	
	@OneToMany
	@JoinColumn(name = "idBebida")
	private List<OfrecerBebida> ofrecerBebida;
	
	
	public Bebida() {}
	
	/**
	 * @param idBebida
	 * @param nombre
	 * @param precioUnitario
	 * @param imagen
	 * @param descripcion
	 * @param ofrecerBebida
	 */
	public Bebida(Long idBebida, String nombre, Double precioUnitario, String imagen, String descripcion,
			List<OfrecerBebida> ofrecerBebida) {
		this.idBebida = idBebida;
		this.nombre = nombre;
		this.precioUnitario = precioUnitario;
		this.imagen = imagen;
		this.descripcion = descripcion;
		this.ofrecerBebida = ofrecerBebida;
	}

	/**
	 * @return the idBebida
	 */
	public Long getIdBebida() {
		return idBebida;
	}

	/**
	 * @param idBebida the idBebida to set
	 */
	public void setIdBebida(Long idBebida) {
		this.idBebida = idBebida;
	}

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return the precioUnitario
	 */
	public Double getPrecioUnitario() {
		return precioUnitario;
	}

	/**
	 * @param precioUnitario the precioUnitario to set
	 */
	public void setPrecioUnitario(Double precioUnitario) {
		this.precioUnitario = precioUnitario;
	}

	/**
	 * @return the imagen
	 */
	public String getImagen() {
		return imagen;
	}

	/**
	 * @param imagen the imagen to set
	 */
	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	/**
	 * @return the descripcion
	 */
	public String getDescripcion() {
		return descripcion;
	}

	/**
	 * @param descripcion the descripcion to set
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	/**
	 * @return the ofrecerBebida
	 */
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "ofrecerbebidas")
	public List<OfrecerBebida> getOfrecerBebida() {
		return ofrecerBebida;
	}

	/**
	 * @param ofrecerBebida the ofrecerBebida to set
	 */
	public void setOfrecerBebida(List<OfrecerBebida> ofrecerBebida) {
		this.ofrecerBebida = ofrecerBebida;
	}

	@Override
	public String toString() {
		return "Bebida [idBebida=" + idBebida + ", nombre=" + nombre + ", precioUnitario=" + precioUnitario
				+ ", imagen=" + imagen + ", descripcion=" + descripcion + "]";
	}


}
