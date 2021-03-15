/**
 * Implementacion de la interfaz Usuario service
 */
package com.ReservaComedor.service.implementacion;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ReservaComedor.dao.IUsuarioDAO;
import com.ReservaComedor.dto.Usuario;
import com.ReservaComedor.service.interfaces.IUsuarioService;


/**
 * @author viach
 *
 */

@Service
public class UsuarioServiceImpl implements IUsuarioService {

	//Inyeccion de dependencias
	@Autowired
	IUsuarioDAO iUsuarioDAO;

	//Metodos de la interfaz implementados
	@Override
	public List<Usuario> listarUsuario() {
		return iUsuarioDAO.findAll();
	}

	@Override
	public Usuario guardarUsuario(Usuario usuario) {
		return iUsuarioDAO.save(usuario);
	}

	@Override
	public Usuario usuarioXID(int idUsuario) {
		return iUsuarioDAO.findById(idUsuario).get();
	}

	@Override
	public Usuario actualizarUsuario(Usuario usuario) {
		return iUsuarioDAO.save(usuario);
	}

	@Override
	public void eliminarUsuario(int idUsuario) {
		iUsuarioDAO.deleteById(idUsuario);
	}
	
}
