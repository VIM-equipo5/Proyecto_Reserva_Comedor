package com.ReservaComedor.dto;

import java.util.List;

import javax.persistence.*;

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
	private String IdCategoria;
	
	@OneToMany
	@JoinColumn(name = "IdCategoria")	//Conexion a la clave foranea en la tabla Usuario
	private List<Categoria> categoria;
	
	public Platos(){}
	
	//Constructor
	public Platos(int idPlato, String nombre, String descripcion, String imagen, double precioUnitario, String tipo,
			String idCategoria) {
		super();
		IdPlato = idPlato;
		this.nombre = nombre;
		Descripcion = descripcion;
		Imagen = imagen;
		PrecioUnitario = precioUnitario;
		Tipo = tipo;
		IdCategoria = idCategoria;
	}

	//Getters y Setters
	public int getIdPlato() {
		return IdPlato;
	}

	public void setIdPlato(int idPlato) {
		IdPlato = idPlato;
	}

	public String getnombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return Descripcion;
	}

	public void setDescripcion(String descripcion) {
		Descripcion = descripcion;
	}

	public String getImagen() {
		return Imagen;
	}

	public void setImagen(String imagen) {
		Imagen = imagen;
	}

	public double getPrecioUnitario() {
		return PrecioUnitario;
	}

	public void setPrecioUnitario(double precioUnitario) {
		PrecioUnitario = precioUnitario;
	}

	public String getTipo() {
		return Tipo;
	}

	public void setTipo(String tipo) {
		Tipo = tipo;
	}

	public String getIdCategoria() {
		return IdCategoria;
	}

	public void setIdCategoria(String idCategoria) {
		IdCategoria = idCategoria;
	}

	public List<Categoria> getCategoria() {
		return categoria;
	}

	public void setCategoria(List<Categoria> categoria) {
		this.categoria = categoria;
	}

	//toString
	@Override
	public String toString() {
		return "Platos [IdPlato=" + IdPlato + ", Nombre=" + nombre + ", Descripcion=" + Descripcion + ", Imagen="
				+ Imagen + ", PrecioUnitario=" + PrecioUnitario + ", Tipo=" + Tipo + ", IdCategoria=" + IdCategoria
				+ "]";
	}
	
	

}