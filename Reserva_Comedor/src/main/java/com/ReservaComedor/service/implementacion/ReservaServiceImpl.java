/**
 * Implementacion de la interfaz Reserva service
 */
package com.ReservaComedor.service.implementacion;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ReservaComedor.dao.IReservaDAO;
import com.ReservaComedor.dto.Reserva;
import com.ReservaComedor.service.interfaces.IReservaService;


/**
 * @author Vyacheslav Khaydorov
 * @author Miguel A. Sastre
 * @author Ingrid Dominguez
 */

@Service
public class ReservaServiceImpl implements IReservaService {

	//Inyeccion de dependencias
	@Autowired
	IReservaDAO iReservaDAO;

	//Metodos de la interfaz implementados
	@Override
	public List<Reserva> listarReserva() {
		return iReservaDAO.findAll();
	}

	@Override
	public Reserva guardarReserva(Reserva reserva) {
		return iReservaDAO.save(reserva);
	}

	@Override
	public Reserva reservaXID(Long idReserva) {
		return iReservaDAO.findById(idReserva).get();
	}

	@Override
	public Reserva actualizarReserva(Reserva reserva) {
		return iReservaDAO.save(reserva);
	}

	@Override
	public void eliminarReserva(Long idReserva) {
		iReservaDAO.deleteById(idReserva);
	}
	
}
