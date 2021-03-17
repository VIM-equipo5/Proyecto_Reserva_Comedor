package com.ReservaComedor.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.ReservaComedor.dto.PedirPlato;
import com.ReservaComedor.service.implementacion.PedirPlatosServiceImpl;



/**
 * @author Vyacheslav Khaydorov
 * @author Miguel A. Sastre
 * @author Ingrid Dominguez
 */

@RestController
@RequestMapping("/api")
public class PedirPlatosController {

	//Inyeccion de dependencias
	@Autowired
	PedirPlatosServiceImpl pedirPlatosServiceImpl;

	//End-points
	@GetMapping("/pedirPlatos")
	public List<PedirPlato> listarPedirPlatos(){
		return pedirPlatosServiceImpl.listarPedirPlatos();
	}
	
	@PostMapping("/pedirPlatos")
	public PedirPlato guardarPedirPlatos(@RequestBody PedirPlato pedirPlatos) {
		return pedirPlatosServiceImpl.guardarPedirPlatos(pedirPlatos);
	}
	
	@GetMapping("/pedirPlatos/{id}")
	public PedirPlato pedirPlatosXID(@PathVariable(name="id") int IdPedirPlatos) {
		PedirPlato pedirPlatosBuscado = new PedirPlato();	
		pedirPlatosBuscado = pedirPlatosServiceImpl.pedirPlatosXID(IdPedirPlatos);
		System.out.println("Pedir Platos: " + pedirPlatosBuscado);
		return pedirPlatosBuscado;
	}
	
	@PutMapping("/pedirPlatos/{id}")
	public PedirPlato actualizarPedirPlatos(@PathVariable(name="id")int IdPedirPlatos,@RequestBody PedirPlato pedirPlatos) {
		//Creamos dos pedirPlatos
		PedirPlato ptPedirPlatos = new PedirPlato();
		
		//El ofrecerBebidaSeleccionado copia los datos del ofrecerBebida que esta en la BD, buscando por el ID
		ptPedirPlatos = pedirPlatosServiceImpl.pedirPlatosXID(IdPedirPlatos);
		
		//Actualizamos valores
		ptPedirPlatos.setIdReserva(pedirPlatos.getIdReserva());
		ptPedirPlatos.setIdPlato(pedirPlatos.getIdPlato());
		ptPedirPlatos.setCantidadPlatos(pedirPlatos.getCantidadPlatos());
		
		System.out.println("PedirPlatos actualizado: " + ptPedirPlatos);
		return ptPedirPlatos;
	}
	
	@DeleteMapping("/pedirPlatos/{id}")
	public void eliminarPedirPlatos(@PathVariable(name="id")int IdPedirPlato) {
		pedirPlatosServiceImpl.eliminarPedirPlatos(IdPedirPlato);
	}
}