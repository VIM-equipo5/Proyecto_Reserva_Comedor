package com.ReservaComedor.dto;

import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "platos")
public class Platos {
	//Atributos
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "IdPlato")
	private int IdPlato;
	@Column(name = "nombre")
	private String nombre;
	@Column(name = "Descripcion")
	private String Descripcion;
	@Column(name = "Imagen")
	private String Imagen;
	@Column(name = "PrecioUnitario")
	private double PrecioUnitario;
	@Column(name = "Tipo")
	private String Tipo;
	@Column(name = "IdCategoria")
	private int IdCategoria;
	
	@ManyToOne
    @JoinColumn(name = "idCategoria")
    Categoria categoria;
	
	@OneToMany
	@JoinColumn(name = "idPlato")
	private List<PedirPlato> pedirPlatos;
	
	
	public Platos(){}


	/**
	 * @param idPlato
	 * @param nombre
	 * @param descripcion
	 * @param imagen
	 * @param precioUnitario
	 * @param tipo
	 * @param idCategoria
	 * @param categoria
	 * @param pedirPlatos
	 */
	public Platos(int idPlato, String nombre, String descripcion, String imagen, double precioUnitario, String tipo,
			int idCategoria, Categoria categoria, List<PedirPlato> pedirPlatos) {
		super();
		IdPlato = idPlato;
		this.nombre = nombre;
		Descripcion = descripcion;
		Imagen = imagen;
		PrecioUnitario = precioUnitario;
		Tipo = tipo;
		IdCategoria = idCategoria;
		this.categoria = categoria;
		this.pedirPlatos = pedirPlatos;
	}


	/**
	 * @return the idPlato
	 */
	public int getIdPlato() {
		return IdPlato;
	}


	/**
	 * @param idPlato the idPlato to set
	 */
	public void setIdPlato(int idPlato) {
		IdPlato = idPlato;
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
	 * @return the descripcion
	 */
	public String getDescripcion() {
		return Descripcion;
	}


	/**
	 * @param descripcion the descripcion to set
	 */
	public void setDescripcion(String descripcion) {
		Descripcion = descripcion;
	}


	/**
	 * @return the imagen
	 */
	public String getImagen() {
		return Imagen;
	}


	/**
	 * @param imagen the imagen to set
	 */
	public void setImagen(String imagen) {
		Imagen = imagen;
	}


	/**
	 * @return the precioUnitario
	 */
	public double getPrecioUnitario() {
		return PrecioUnitario;
	}


	/**
	 * @param precioUnitario the precioUnitario to set
	 */
	public void setPrecioUnitario(double precioUnitario) {
		PrecioUnitario = precioUnitario;
	}


	/**
	 * @return the tipo
	 */
	public String getTipo() {
		return Tipo;
	}


	/**
	 * @param tipo the tipo to set
	 */
	public void setTipo(String tipo) {
		Tipo = tipo;
	}


	/**
	 * @return the idCategoria
	 */
	public int getIdCategoria() {
		return IdCategoria;
	}


	/**
	 * @param idCategoria the idCategoria to set
	 */
	public void setIdCategoria(int idCategoria) {
		IdCategoria = idCategoria;
	}


	/**
	 * @return the categoria
	 */
	public Categoria getCategoria() {
		return categoria;
	}


	/**
	 * @param categoria the categoria to set
	 */
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}


	/**
	 * @return the pedirPlatos
	 */
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "pedirplatos")
	public List<PedirPlato> getPedirPlatos() {
		return pedirPlatos;
	}


	/**
	 * @param pedirPlatos the pedirPlatos to set
	 */
	public void setPedirPlatos(List<PedirPlato> pedirPlatos) {
		this.pedirPlatos = pedirPlatos;
	}


	@Override
	public String toString() {
		return "Platos [IdPlato=" + IdPlato + ", nombre=" + nombre + ", Descripcion=" + Descripcion + ", Imagen="
				+ Imagen + ", PrecioUnitario=" + PrecioUnitario + ", Tipo=" + Tipo + ", IdCategoria=" + IdCategoria
				+ ", categoria=" + categoria + ", pedirPlatos=" + pedirPlatos + "]";
	}

}