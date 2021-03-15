/**
 * Implementacion de la interfaz FranjaHoraria service
 */
package com.ReservaComedor.service.implementacion;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ReservaComedor.dao.IFranjaHorariaDAO;
import com.ReservaComedor.dto.FranjaHoraria;
import com.ReservaComedor.service.interfaces.IFranjaHorariaService;


/**
 * @author Vyacheslav Khaydorov
 * @author Miguel A. Sastre
 * @author Ingrid Dominguez
 */

@Service
public class FranjaHorariaServiceImpl implements IFranjaHorariaService {

	//Inyeccion de dependencias
	@Autowired
	IFranjaHorariaDAO iFranjaHorariaDAO;

	//Metodos de la interfaz implementados
	@Override
	public List<FranjaHoraria> listarFranjaHoraria() {
		return iFranjaHorariaDAO.findAll();
	}

	@Override
	public FranjaHoraria guardarFranjaHoraria(FranjaHoraria franjaHoraria) {
		return iFranjaHorariaDAO.save(franjaHoraria);
	}

	@Override
	public FranjaHoraria franjaHorariaXID(int idFranjaHoraria) {
		return iFranjaHorariaDAO.findById(idFranjaHoraria).get();
	}

	@Override
	public FranjaHoraria actualizarFranjaHoraria(FranjaHoraria franjaHoraria) {
		return iFranjaHorariaDAO.save(franjaHoraria);
	}

	@Override
	public void eliminarFranjaHoraria(int idFranjaHoraria) {
		iFranjaHorariaDAO.deleteById(idFranjaHoraria);
	}
	
}
