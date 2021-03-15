/**
 * Mapeo de la tabla rol
 */
package com.ReservaComedor.dto;

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

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @author viach
 *
 */

@Entity
@Table(name = "rol")
public class Rol {

	//Atributos
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "IdRol")
	private int idRol;
	@Column(name = "NombreRol")
	private String nombreRol;
	@Column(name = "Descripcion")
	private String descripcion;
	
	@OneToMany
	@JoinColumn(name = "IdRol")	//Conexion a la clave foranea en la tabla Usuario
	private List<Usuario> usuario;

	//Constructores
	/**
	 * Constructor vacio
	 */
	public Rol() {
		
	}

	/**
	 * @param idRol
	 * @param nombreRol
	 * @param descripcion
	 * @param usuario
	 */
	public Rol(int idRol, String nombreRol, String descripcion, List<Usuario> usuario) {
		this.idRol = idRol;
		this.nombreRol = nombreRol;
		this.descripcion = descripcion;
		this.usuario = usuario;
	}

	//Getters y setters
	/**
	 * @return the idRol
	 */
	public int getIdRol() {
		return idRol;
	}

	/**
	 * @param idRol the idRol to set
	 */
	public void setIdRol(int idRol) {
		this.idRol = idRol;
	}

	/**
	 * @return the nombreRol
	 */
	public String getNombreRol() {
		return nombreRol;
	}

	/**
	 * @param nombreRol the nombreRol to set
	 */
	public void setNombreRol(String nombreRol) {
		this.nombreRol = nombreRol;
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
	 * @return the usuario
	 */
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "Usuario")
	public List<Usuario> getUsuario() {
		return usuario;
	}

	/**
	 * @param usuario the usuario to set
	 */
	public void setUsuario(List<Usuario> usuario) {
		this.usuario = usuario;
	}

	//toString
	@Override
	public String toString() {
		return "Rol [IdRol=" + idRol + ", NombreRol=" + nombreRol + ", Descripcion=" + descripcion + "]";
	}

}
