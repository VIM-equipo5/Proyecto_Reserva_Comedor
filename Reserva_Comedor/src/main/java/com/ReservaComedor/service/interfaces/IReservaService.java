/**
 * Interfaz Reserva service
 */
package com.ReservaComedor.service.interfaces;

import java.util.List;

import com.ReservaComedor.dto.Reserva;



/**
 * @author Vyacheslav Khaydorov
 * @author Miguel A. Sastre
 * @author Ingrid Dominguez
 */
public interface IReservaService {

	//Metodos del CRUD
	public List<Reserva> listarReserva();	
	
	public Reserva guardarReserva(Reserva reserva);	
	
	public Reserva reservaXID(Long idReserva);	
	
	public Reserva actualizarReserva(Reserva reserva);	
	
	public void eliminarReserva(Long idReserva);	
	
}
