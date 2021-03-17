package com.ReservaComedor.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.ReservaComedor.dto.FranjaHoraria;
import com.ReservaComedor.service.implementacion.FranjaHorariaServiceImpl;

/**
 * @author Vyacheslav Khaydorov
 * @author Miguel A. Sastre
 * @author Ingrid Dominguez
 */

@RestController
@RequestMapping("/api")
public class FranjaHorariaController {

	//Inyeccion de dependencias
	@Autowired
	FranjaHorariaServiceImpl franjaHorariaServiceImpl;
	
	//End-points
	@GetMapping("/franjahoraria")
	public List<FranjaHoraria> listarFranjaHoraria(){
		return franjaHorariaServiceImpl.listarFranjaHoraria();
	}
	
	@PostMapping("/franjahoraria")
	public FranjaHoraria guardarFranjaHoraria(@RequestBody FranjaHoraria franjaHoraria) {
		return franjaHorariaServiceImpl.guardarFranjaHoraria(franjaHoraria);
	}
	
	@GetMapping("/franjahoraria/{id}")
	public FranjaHoraria franjaHorariaXID(@PathVariable(name="idFranja") int idFranja) {
		FranjaHoraria franjaHorariaBuscada = new FranjaHoraria();	
		franjaHorariaBuscada = franjaHorariaServiceImpl.franjaHorariaXID(idFranja);
		System.out.println("Franja horaria: " + franjaHorariaBuscada);
		return franjaHorariaBuscada;
	}
	
	@PutMapping("/franjahoraria/{id}")
	public FranjaHoraria actualizarFranjaHoraria(@PathVariable(name="idFranja")int idFranja,@RequestBody FranjaHoraria franjaHoraria) {
		//Creamos dos franjas horarias
		FranjaHoraria franjaHorariaSeleccionada = new FranjaHoraria();
		FranjaHoraria franjaHorariaActualizada = new FranjaHoraria();
		
		//La franjaHorariaSeleccionada copia los datos de la franja que esta en la BD, buscando por el ID
		franjaHorariaSeleccionada = franjaHorariaServiceImpl.franjaHorariaXID(idFranja);
		
		//Actualizamos valores
		franjaHorariaSeleccionada.setCapacidadMax(franjaHoraria.getCapacidadMax());
		franjaHorariaSeleccionada.setOcupacionTotal(franjaHoraria.getOcupacionTotal());
		franjaHorariaSeleccionada.setFranjaInicio(franjaHoraria.getFranjaInicio());
		franjaHorariaSeleccionada.setFranjaFin(franjaHoraria.getFranjaFin());
		
		//...
		franjaHorariaActualizada = franjaHorariaServiceImpl.actualizarFranjaHoraria(franjaHorariaSeleccionada);
		
		System.out.println("Franja horaria actualizada: " + franjaHorariaActualizada);
		return franjaHorariaActualizada;
	}
	
	@DeleteMapping("/franjahoraria/{id}")
	public void eliminarFranjaHoraria(@PathVariable(name="idFranja")int idFranja) {
		franjaHorariaServiceImpl.eliminarFranjaHoraria(idFranja);
	}
	
}
