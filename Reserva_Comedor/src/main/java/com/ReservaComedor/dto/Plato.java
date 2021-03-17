package com.ReservaComedor.dto;

import java.sql.Blob;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "platos")
public class Plato {
	//Atributos
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "IdPlato")
	private int IdPlato;
	@Column(name = "Nombre")
	private String Nombre;
	@Column(name = "Descripcion")
	private String Descripcion;
	@Column(name = "Imagen")
	private Blob Imagen;
	@Column(name = "PrecioUnitario")
	private double PrecioUnitario;
	@Column(name = "Tipo")
	private String Tipo;
	@Column(name = "IdCategoria")
	private String IdCategoria;
	
	@OneToMany
	@JoinColumn(name = "IdCategoria")	//Conexion a la clave foranea en la tabla Usuario
	private List<Categoria> categoria;
	
	public Plato(){}
	
	//Constructor
	public Plato(int idPlato, String nombre, String descripcion, Blob imagen, double precioUnitario, String tipo,
			String idCategoria) {
		super();
		IdPlato = idPlato;
		Nombre = nombre;
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

	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		Nombre = nombre;
	}

	public String getDescripcion() {
		return Descripcion;
	}

	public void setDescripcion(String descripcion) {
		Descripcion = descripcion;
	}

	public Blob getImagen() {
		return Imagen;
	}

	public void setImagen(Blob imagen) {
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
		return "Platos [IdPlato=" + IdPlato + ", Nombre=" + Nombre + ", Descripcion=" + Descripcion + ", Imagen="
				+ Imagen + ", PrecioUnitario=" + PrecioUnitario + ", Tipo=" + Tipo + ", IdCategoria=" + IdCategoria
				+ "]";
	}
	
	

}