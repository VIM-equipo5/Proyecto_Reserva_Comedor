package com.ReservaComedor.controller;



/**
 * Controller para Bebida
 */


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.ReservaComedor.dto.Bebida;
import com.ReservaComedor.service.implementacion.BebidaServiceImpl;



/**
 * @author Vyacheslav Khaydorov
 * @author Miguel A. Sastre
 * @author Ingrid Dominguez
 */

@RestController
@CrossOrigin(origins="*",methods= {RequestMethod.GET,RequestMethod.POST})
@RequestMapping("/api")
public class BebidaController {

	//Inyeccion de dependencias
	@Autowired
	BebidaServiceImpl bebidaServiceImpl;

	//End-points
	@GetMapping("/bebidas")
	public List<Bebida> listarBebida(){
		return bebidaServiceImpl.listarBebida();
	}
	
	@PostMapping("/bebidas")
	public Bebida guardarBebida(@RequestBody Bebida bebida) {
		return bebidaServiceImpl.guardarBebida(bebida);
	}
	
	@GetMapping("/bebidas/{idBebida}")
	public Bebida bebidaXID(@PathVariable(name="idBebida") Long idBebida) {
		Bebida bebidaBuscado = new Bebida();	
		bebidaBuscado = bebidaServiceImpl.bebidaXID(idBebida);
		System.out.println("Bebida: " + bebidaBuscado);
		return bebidaBuscado;
	}
	
	@PutMapping("/bebidas/{idBebida}")
	public Bebida actualizarBebida(@PathVariable(name="idBebida")Long idBebida,@RequestBody Bebida bebida) {
		//Creamos dos bebidas
		Bebida ptBebida = new Bebida();
		
		//El bebidaSeleccionado copia los datos del bebida que esta en la BD, buscando por el ID
		ptBebida = bebidaServiceImpl.bebidaXID(idBebida);
		
		//Actualizamos valores
		ptBebida.setNombre(bebida.getNombre());
		ptBebida.setPrecioUnitario(bebida.getPrecioUnitario());
		ptBebida.setImagen(bebida.getImagen());
		ptBebida.setDescripcion(bebida.getDescripcion());
		
		
		//...
		ptBebida = bebidaServiceImpl.actualizarBebida(ptBebida);
		
		System.out.println("Bebida actualizado: " + ptBebida);
		return ptBebida;
	}
	
	@DeleteMapping("/bebidas/{idBebida}")
	public void eliminarBebida(@PathVariable(name="idBebida")Long idBebida) {
		bebidaServiceImpl.eliminarBebida(idBebida);
	}
}
