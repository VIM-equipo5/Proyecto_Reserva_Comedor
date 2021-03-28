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
@CrossOrigin(origins="*",methods= {RequestMethod.GET,RequestMethod.POST})
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
	public PedirPlato guardarPedirPlatos(@RequestBody PedirPlato pedirPlato) {
		return pedirPlatosServiceImpl.guardarPedirPlatos(pedirPlato);
	}
	
	@GetMapping("/pedirPlatos/{id}")
	public PedirPlato pedirPlatosXID(@PathVariable(name="id") Long IdPedirPlatos) {
		PedirPlato pedirPlatosBuscado = new PedirPlato();	
		pedirPlatosBuscado = pedirPlatosServiceImpl.pedirPlatosXID(IdPedirPlatos);
		System.out.println("Pedir Platos: " + pedirPlatosBuscado);
		return pedirPlatosBuscado;
	}
	
	@PutMapping("/pedirPlatos/{id}")
	public PedirPlato actualizarPedirPlatos(@PathVariable(name="id")Long IdPedirPlatos,@RequestBody PedirPlato pedirPlato) {
		//Creamos dos pedirPlatos
		PedirPlato ptPedirPlatos = new PedirPlato();
		
		//El ofrecerBebidaSeleccionado copia los datos del ofrecerBebida que esta en la BD, buscando por el ID
		ptPedirPlatos = pedirPlatosServiceImpl.pedirPlatosXID(IdPedirPlatos);
		
		//Actualizamos valores
		ptPedirPlatos.setIdReserva(pedirPlato.getIdReserva());
		ptPedirPlatos.setIdPlato(pedirPlato.getIdPlato());
		ptPedirPlatos.setCantidadPlatos(pedirPlato.getCantidadPlatos());
		
		System.out.println("PedirPlato actualizado: " + ptPedirPlatos);
		return ptPedirPlatos;
	}
	
	@DeleteMapping("/pedirPlatos/{id}")
	public void eliminarPedirPlatos(@PathVariable(name="id")Long IdPedirPlato) {
		pedirPlatosServiceImpl.eliminarPedirPlatos(IdPedirPlato);
	}
}