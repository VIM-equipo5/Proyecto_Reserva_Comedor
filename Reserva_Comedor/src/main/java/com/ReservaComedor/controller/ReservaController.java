package com.ReservaComedor.controller;

/**
 * Controller para Reserva
 */


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.ReservaComedor.dto.Reserva;
import com.ReservaComedor.service.implementacion.ReservaServiceImpl;


/**
 * @author Vyacheslav Khaydorov
 * @author Miguel A. Sastre
 * @author Ingrid Dominguez
 */

@RestController
@RequestMapping("/api")
public class ReservaController {

	//Inyeccion de dependencias
	@Autowired
	ReservaServiceImpl reservaServiceImpl;

	//End-points
	@GetMapping("/reserva")
	public List<Reserva> listarReserva(){
		return reservaServiceImpl.listarReserva();
	}
	
	@PostMapping("/reserva")
	public Reserva guardarReserva(@RequestBody Reserva reserva) {
		return reservaServiceImpl.guardarReserva(reserva);
	}
	
	@GetMapping("/reserva/{id}")
	public Reserva reservaXID(@PathVariable(name="idReserva") Long idReserva) {
		Reserva reservaBuscado = new Reserva();	
		reservaBuscado = reservaServiceImpl.reservaXID(idReserva);
		System.out.println("Reserva: " + reservaBuscado);
		return reservaBuscado;
	}
	
	@PutMapping("/reserva/{id}")
	public Reserva actualizarReserva(@PathVariable(name="idReserva")Long idReserva,@RequestBody Reserva reserva) {
		//Creamos dos reservas
		Reserva ptReserva = new Reserva();
		
		//El reservaSeleccionado copia los datos del reserva que esta en la BD, buscando por el ID
		ptReserva = reservaServiceImpl.reservaXID(idReserva);
		
		//Actualizamos valores
		ptReserva.setIdReserva(reserva.getIdReserva());
		ptReserva.setCantidadComensales(reserva.getCantidadComensales());
		ptReserva.setPrecioTotal(reserva.getPrecioTotal());
		ptReserva.setFechaReserva(reserva.getFechaReserva());
		ptReserva.setFechaReservada(reserva.getFechaReservada());
		ptReserva.setUsuario(reserva.getUsuario());
		ptReserva.setFranjaHoraria(reserva.getFranjaHoraria());
		
		
		//...
		ptReserva = reservaServiceImpl.actualizarReserva(ptReserva);
		
		System.out.println("Reserva actualizado: " + ptReserva);
		return ptReserva;
	}
	
	@DeleteMapping("/reserva/{id}")
	public void eliminarReserva(@PathVariable(name="idReserva")Long idReserva) {
		reservaServiceImpl.eliminarReserva(idReserva);
	}
}
