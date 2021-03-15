/**
 * Mapeo de la tabla usuario
 */
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
import javax.persistence.ManyToOne;
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
@Table(name="usuario")
public class Usuario {

	//Atributos
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "IdUsuario")
	private int idUsuario;
	@Column(name = "NombreUsuario")
	private String nombreUsuario;	//100 caracteres en la BD
	@Column(name = "Contraseña")
	private String contraseña;		//20 caracteres en la BD
	@Column(name = "Nombre")
	private String nombre;			//50 caracteres en la BD
	@Column(name = "Apellido")
	private String apellido; 		//50 caracteres en la BD
	@Column(name = "FechaNacimiento")
	@Temporal(TemporalType.DATE)	//Atributo de tipo TIME
	private java.util.Date fechaNacimiento;
	private String DNI;				//9 caracteres en la BD
	@Column(name = "Telefono")
	private int telefono;
	
	@ManyToOne
	@JoinColumn(name = "IdRol")	//Conexion a la tabla rol (instanciacion de la clase Rol
								//que corresponde a la clave foranea IdRol en la BD)
	Rol rol;
	
	@OneToMany
	@JoinColumn(name = "IdUsuario")	//Conexion a la clave foranea en la tabla reserva
	private List<Reserva> reserva;

	//Constructores
	/**
	 * 
	 */
	public Usuario() {
	}

	/**
	 * @param idUsuario
	 * @param nombreUsuario
	 * @param contraseña
	 * @param nombre
	 * @param apellido
	 * @param fechaNacimiento
	 * @param DNI
	 * @param telefono
	 * @param rol
	 * @param reserva
	 */
	public Usuario(int idUsuario, String nombreUsuario, String contraseña, String nombre, String apellido,
			Date fechaNacimiento, String DNI, int telefono, Rol rol, List<Reserva> reserva) {
		this.idUsuario = idUsuario;
		this.nombreUsuario = nombreUsuario;
		this.contraseña = contraseña;
		this.nombre = nombre;
		this.apellido = apellido;
		this.fechaNacimiento = fechaNacimiento;
		this.DNI = DNI;
		this.telefono = telefono;
		this.rol = rol;
		this.reserva = reserva;
	}

	//Getters y setters
	/**
	 * @return the idUsuario
	 */
	public int getIdUsuario() {
		return idUsuario;
	}

	/**
	 * @param idUsuario the idUsuario to set
	 */
	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	/**
	 * @return the nombreUsuario
	 */
	public String getNombreUsuario() {
		return nombreUsuario;
	}

	/**
	 * @param nombreUsuario the nombreUsuario to set
	 */
	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	/**
	 * @return the contraseña
	 */
	public String getContraseña() {
		return contraseña;
	}

	/**
	 * @param contraseña the contraseña to set
	 */
	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
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
	 * @return the apellido
	 */
	public String getApellido() {
		return apellido;
	}

	/**
	 * @param apellido the apellido to set
	 */
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	/**
	 * @return the fechaNacimiento
	 */
	public java.util.Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	/**
	 * @param fechaNacimiento the fechaNacimiento to set
	 */
	public void setFechaNacimiento(java.util.Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	/**
	 * @return the dNI
	 */
	public String getDNI() {
		return DNI;
	}

	/**
	 * @param DNI the dNI to set
	 */
	public void setDNI(String DNI) {
		this.DNI = DNI;
	}

	/**
	 * @return the telefono
	 */
	public int getTelefono() {
		return telefono;
	}

	/**
	 * @param telefono the telefono to set
	 */
	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}

	/**
	 * @return the rol
	 */
	public Rol getRol() {
		return rol;
	}

	/**
	 * @param rol the rol to set
	 */
	public void setRol(Rol rol) {
		this.rol = rol;
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
		return "Usuario [idUsuario=" + idUsuario + ", nombreUsuario=" + nombreUsuario + ", contraseña=" + contraseña
				+ ", nombre=" + nombre + ", apellido=" + apellido + ", fechaNacimiento=" + fechaNacimiento + ", DNI="
				+ DNI + ", telefono=" + telefono + ", rol=" + rol + "]";
	}
	
}
