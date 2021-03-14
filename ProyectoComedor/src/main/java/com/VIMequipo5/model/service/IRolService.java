/**
 * Interfaz Rol service
 */
package com.VIMequipo5.model.service;

import java.util.List;

import com.VIMequipo5.model.dto.Rol;

/**
 * @author viach
 *
 */
public interface IRolService {

	//Metodos del CRUD
		public List<Rol> listarRol();	//Listar All 
		
		public Rol guardarRol(Rol rol);	//Guarda un rol CREATE
		
		public Rol rolXID(int idRol);	//Leer datos de un rol READ
		
		public Rol actualizarRol(Rol rol);	//Actualiza datos del rol UPDATE
		
		public void eliminarRol(int idRol);	//Elimina el rol DELETE
	
}
