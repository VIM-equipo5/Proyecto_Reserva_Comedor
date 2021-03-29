package com.ReservaComedor.dto;



import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
	
	
	@OneToMany
	@JoinColumn(name = "IdCategoria")
	private List<Platos> platos;
	
	public Categoria() {}

	/**
	 * @param idCategoria
	 * @param nombre
	 * @param descripcion
	 * @param platos
	 */
	public Categoria(int idCategoria, String nombre, String descripcion, List<Platos> platos) {
		super();
		IdCategoria = idCategoria;
		Nombre = nombre;
		Descripcion = descripcion;
		this.platos = platos;
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
	 * @return the nombre
	 */
	public String getNombre() {
		return Nombre;
	}

	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		Nombre = nombre;
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
	 * @return the platos
	 */
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "platos")
	public List<Platos> getPlatos() {
		return platos;
	}

	/**
	 * @param platos the platos to set
	 */
	public void setPlatos(List<Platos> platos) {
		this.platos = platos;
	}

	@Override
	public String toString() {
		return "Categoria [IdCategoria=" + IdCategoria + ", Nombre=" + Nombre + ", Descripcion=" + Descripcion + "]";
	}

	
	
}
