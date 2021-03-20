package com.ReservaComedor.dto;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


/**
 * @author Vyacheslav Khaydorov
 * @author Miguel A. Sastre
 * @author Ingrid Dominguez
 */



@Entity
@Table(name = "categoria")
public class Categoria {
	//Atributos
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "IdCategoria")
	private int IdCategoria;
	@Column(name = "Nombre")
	private String Nombre;
	@Column(name = "Descripcion")
	private String Descripcion;
	
	public Categoria() {}
	
	//Constructor
	public Categoria(int idCategoria, String nombre, String descripcion) {
		super();
		IdCategoria = idCategoria;
		Nombre = nombre;
		Descripcion = descripcion;
	}

	//Getters y Setters
	public int getIdCategoria() {
		return IdCategoria;
	}

	public void setIdCategoria(int idCategoria) {
		IdCategoria = idCategoria;
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

	//toString
	@Override
	public String toString() {
		return "Categoria [IdCategoria=" + IdCategoria + ", Nombre=" + Nombre + ", Descripcion=" + Descripcion + "]";
	}
}
