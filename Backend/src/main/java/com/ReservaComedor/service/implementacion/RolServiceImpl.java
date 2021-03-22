/**
 * Implementacion de la interfaz Rol service
 */
package com.ReservaComedor.service.implementacion;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ReservaComedor.dao.IRolDAO;
import com.ReservaComedor.dto.Rol;
import com.ReservaComedor.service.interfaces.IRolService;


/**
 * @author Vyacheslav Khaydorov
 * @author Miguel A. Sastre
 * @author Ingrid Dominguez
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
