/**
 * Implementacion de la interfaz Rol service
 */
package com.VIMequipo5.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.VIMequipo5.model.dao.IRolDAO;
import com.VIMequipo5.model.dto.Rol;

/**
 * @author viach
 *
 */

@Service
public class RolServiceImpl implements IRolService {

	//Inyeccion de dependencias
	@Autowired
	IRolDAO iRolDAO;

	//Metodos de la interfaz implementados
	@Override
	public List<Rol> listarRol() {
		return iRolDAO.findAll();
	}

	@Override
	public Rol guardarRol(Rol rol) {
		return iRolDAO.save(rol);
	}

	@Override
	public Rol rolXID(int idRol) {
		return iRolDAO.findById(idRol).get();
	}

	@Override
	public Rol actualizarRol(Rol rol) {
		return iRolDAO.save(rol);
	}

	@Override
	public void eliminarRol(int idRol) {
		iRolDAO.deleteById(idRol);
	}	
}
