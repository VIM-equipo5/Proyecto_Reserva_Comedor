/**
 * Interfaz Usuario service
 */
package com.ReservaComedor.service.interfaces;

import java.util.List;

import com.ReservaComedor.dto.Usuario;



/**
 * @author Vyacheslav Khaydorov
 * @author Miguel A. Sastre
 * @author Ingrid Dominguez
 */
public interface IUsuarioService {

	//Metodos del CRUD
	public List<Usuario> listarUsuario();	//Listar All 
	
	public Usuario guardarUsuario(Usuario usuario);	//Guarda un usuario CREATE
	
	public Usuario usuarioXID(int idUsuario);	//Leer datos de un usuario READ
	
	public Usuario actualizarUsuario(Usuario usuario);	//Actualiza datos del usuario UPDATE
	
	public void eliminarUsuario(int idUsuario);	//Elimina el usuario DELETE
	
	public List<Usuario> usuarioXNombre(String nombreUsuario);
}
