/**
 * Implementacion de la interfaz FranjaHoraria service
 */
package com.VIMequipo5.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.VIMequipo5.model.dao.IFranjaHorariaDAO;
import com.VIMequipo5.model.dto.FranjaHoraria;

/**
 * @author viach
 *
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
