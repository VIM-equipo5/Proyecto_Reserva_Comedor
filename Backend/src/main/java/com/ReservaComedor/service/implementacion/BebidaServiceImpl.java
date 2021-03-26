/**
 * Implementacion de la interfaz Bebida service
 */
package com.ReservaComedor.service.implementacion;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ReservaComedor.dao.IBebidaDAO;
import com.ReservaComedor.dto.Bebida;
import com.ReservaComedor.service.interfaces.IBebidaService;


/**
 * @author Vyacheslav Khaydorov
 * @author Miguel A. Sastre
 * @author Ingrid Dominguez
 */

@Service
public class BebidaServiceImpl implements IBebidaService {

	//Inyeccion de dependencias
	@Autowired
	IBebidaDAO iBebidaDAO;

	//Metodos de la interfaz implementados
	@Override
	public List<Bebida> listarBebida() {
		return iBebidaDAO.findAll();
	}

	@Override
	public Bebida guardarBebida(Bebida bebida) {
		return iBebidaDAO.save(bebida);
	}

	@Override
	public Bebida bebidaXID(Long idBebida) {
		return iBebidaDAO.findById(idBebida).get();
	}

	@Override
	public Bebida actualizarBebida(Bebida bebida) {
		return iBebidaDAO.save(bebida);
	}

	@Override
	public void eliminarBebida(Long idBebida) {
		iBebidaDAO.deleteById(idBebida);
	}
	
}
