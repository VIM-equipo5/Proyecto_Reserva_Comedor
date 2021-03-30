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
@CrossOrigin(origins="*",methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.DELETE,RequestMethod.PUT})
@RequestMapping("/api")
public class ReservaController {

	//Inyeccion de dependencias
	@Autowired
	ReservaServiceImpl reservaServiceImpl;

	//End-points
	@GetMapping("/reservas")
	public List<Reserva> listarReserva(){
		return reservaServiceImpl.listarReserva();
	}
	
	@PostMapping("/reservas")
	public Reserva guardarReserva(@RequestBody Reserva reserva) {
		return reservaServiceImpl.guardarReserva(reserva);
	}
	
	@GetMapping("/reservas/{idReserva}")
	public Reserva reservaXID(@PathVariable(name="idReserva") Long idReserva) {
		Reserva reservaBuscado = new Reserva();	
		reservaBuscado = reservaServiceImpl.reservaXID(idReserva);
		System.out.println("Reserva: " + reservaBuscado);
		return reservaBuscado;
	}
	
	@PutMapping("/reservas/{idReserva}")
	public Reserva actualizarReserva(@PathVariable(name="idReserva")Long idReserva,@RequestBody Reserva reserva) {
		//Creamos dos reservas
		Reserva ptReserva = new Reserva();
		
		ptReserva = reservaServiceImpl.reservaXID(idReserva);
		
		//Actualizamos valores
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
	
	@DeleteMapping("/reservas/{idReserva}")
	public void eliminarReserva(@PathVariable(name="idReserva")Long idReserva) {
		reservaServiceImpl.eliminarReserva(idReserva);
	}
}
