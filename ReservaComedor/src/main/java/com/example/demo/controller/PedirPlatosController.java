package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.dto.PedirPlatos;
import com.example.demo.service.implementacion.PedirPlatosServiceImpl;

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
	public List<PedirPlatos> listarPedirPlatos(){
		return pedirPlatosServiceImpl.listarPedirPlatos();
	}
	
	@PostMapping("/pedirPlatos")
	public PedirPlatos guardarPedirPlatos(@RequestBody PedirPlatos pedirPlatos) {
		return pedirPlatosServiceImpl.guardarPedirPlatos(pedirPlatos);
	}
	
	@GetMapping("/pedirPlatos/{id}")
	public PedirPlatos pedirPlatosXID(@PathVariable(name="id") int IdPedirPlatos) {
		PedirPlatos pedirPlatosBuscado = new PedirPlatos();	
		pedirPlatosBuscado = pedirPlatosServiceImpl.pedirPlatosXID(IdPedirPlatos);
		System.out.println("Pedir Platos: " + pedirPlatosBuscado);
		return pedirPlatosBuscado;
	}
	
	@PutMapping("/pedirPlatos/{id}")
	public PedirPlatos actualizarPedirPlatos(@PathVariable(name="id")int IdPedirPlatos,@RequestBody PedirPlatos pedirPlatos) {
		//Creamos dos pedirPlatos
		PedirPlatos ptPedirPlatos = new PedirPlatos();
		
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