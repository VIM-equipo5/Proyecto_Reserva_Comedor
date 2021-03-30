package com.ReservaComedor.controller;



/**
 * Controller para OfrecerBebida
 */


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.ReservaComedor.dto.OfrecerBebida;
import com.ReservaComedor.service.implementacion.OfrecerBebidaServiceImpl;




/**
 * @author Vyacheslav Khaydorov
 * @author Miguel A. Sastre
 * @author Ingrid Dominguez
 */

@RestController
@CrossOrigin(origins="*",methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.DELETE,RequestMethod.PUT})
@RequestMapping("/api")
public class OfrecerBebidaController {

	//Inyeccion de dependencias
	@Autowired
	OfrecerBebidaServiceImpl ofrecerBebidaServiceImpl;

	//End-points
	@GetMapping("/ofrecerBebidas")
	public List<OfrecerBebida> listarOfrecerBebida(){
		return ofrecerBebidaServiceImpl.listarOfrecerBebida();
	}
	
	@PostMapping("/ofrecerBebidas")
	public OfrecerBebida guardarOfrecerBebida(@RequestBody OfrecerBebida ofrecerBebida) {
		return ofrecerBebidaServiceImpl.guardarOfrecerBebida(ofrecerBebida);
	}
	
	@GetMapping("/ofrecerBebidas/{id}")
	public OfrecerBebida ofrecerBebidaXID(@PathVariable(name="id") Long idOfrecerBebida) {
		OfrecerBebida ofrecerBebidaBuscado = new OfrecerBebida();	
		ofrecerBebidaBuscado = ofrecerBebidaServiceImpl.ofrecerBebidaXID(idOfrecerBebida);
		System.out.println("OfrecerBebida: " + ofrecerBebidaBuscado);
		return ofrecerBebidaBuscado;
	}
	
	@PutMapping("/ofrecerBebidas/{id}")
	public OfrecerBebida actualizarOfrecerBebida(@PathVariable(name="id")Long idOfrecerBebida,@RequestBody OfrecerBebida ofrecerBebida) {
		//Creamos dos ofrecerBebidas
		OfrecerBebida ptOfrecerBebida = new OfrecerBebida();
		
		//El ofrecerBebidaSeleccionado copia los datos del ofrecerBebida que esta en la BD, buscando por el ID
		ptOfrecerBebida = ofrecerBebidaServiceImpl.ofrecerBebidaXID(idOfrecerBebida);
		
		//Actualizamos valores
		ptOfrecerBebida.setCantidadBebidas(ofrecerBebida.getCantidadBebidas());
		ptOfrecerBebida.setReserva(ofrecerBebida.getReserva());
		ptOfrecerBebida.setBebida(ofrecerBebida.getBebida());
		
		//...
		ptOfrecerBebida = ofrecerBebidaServiceImpl.actualizarOfrecerBebida(ptOfrecerBebida);
		
		System.out.println("OfrecerBebida actualizado: " + ptOfrecerBebida);
		return ptOfrecerBebida;
	}
	
	@DeleteMapping("/ofrecerBebidas/{id}")
	public void eliminarOfrecerBebida(@PathVariable(name="id")Long idOfrecerBebida) {
		ofrecerBebidaServiceImpl.eliminarOfrecerBebida(idOfrecerBebida);
	}
}
