/**
 * Implementacion de la interfaz OfrecerBebida service
 */
package com.ReservaComedor.service.implementacion;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ReservaComedor.dao.IOfrecerBebidaDAO;
import com.ReservaComedor.dto.OfrecerBebida;
import com.ReservaComedor.service.interfaces.IOfrecerBebidaService;


/**
 * @author Vyacheslav Khaydorov
 * @author Miguel A. Sastre
 * @author Ingrid Dominguez
 */

@Service
public class OfrecerBebidaServiceImpl implements IOfrecerBebidaService {

	//Inyeccion de dependencias
	@Autowired
	IOfrecerBebidaDAO iOfrecerBebidaDAO;

	//Metodos de la interfaz implementados
	@Override
	public List<OfrecerBebida> listarOfrecerBebida() {
		return iOfrecerBebidaDAO.findAll();
	}

	@Override
	public OfrecerBebida guardarOfrecerBebida(OfrecerBebida ofrecerBebida) {
		return iOfrecerBebidaDAO.save(ofrecerBebida);
	}

	@Override
	public OfrecerBebida ofrecerBebidaXID(Long idOfrecerBebida) {
		return iOfrecerBebidaDAO.findById(idOfrecerBebida).get();
	}

	@Override
	public OfrecerBebida actualizarOfrecerBebida(OfrecerBebida ofrecerBebida) {
		return iOfrecerBebidaDAO.save(ofrecerBebida);
	}

	@Override
	public void eliminarOfrecerBebida(Long idOfrecerBebida) {
		iOfrecerBebidaDAO.deleteById(idOfrecerBebida);
	}
	
}
