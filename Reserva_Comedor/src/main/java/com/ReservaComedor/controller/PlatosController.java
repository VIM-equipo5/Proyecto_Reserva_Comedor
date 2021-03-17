package com.ReservaComedor.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.ReservaComedor.dto.Plato;
import com.ReservaComedor.service.implementacion.PlatosServiceImpl;




/**
 * @author Vyacheslav Khaydorov
 * @author Miguel A. Sastre
 * @author Ingrid Dominguez
 */

@RestController
@RequestMapping("/api")
public class PlatosController {

	//Inyeccion de dependencias
	@Autowired
	PlatosServiceImpl platosServiceImpl;

	//End-points
	@GetMapping("/platos")
	public List<Plato> listarPlatos(){
		return platosServiceImpl.listarPlatos();
	}
	
	@PostMapping("/platos")
	public Plato guardarPlato(@RequestBody Plato plato) {
		return platosServiceImpl.guardarPlato(plato);
	}
	
	@GetMapping("/plato/{id}")
	public Plato platoXID(@PathVariable(name="idPlato") int IdPlato) {
		Plato platoBuscado = new Plato();	
		platoBuscado = platosServiceImpl.platoXID(IdPlato);
		System.out.println("Plato: " + platoBuscado);
		return platoBuscado;
	}
	
	@PutMapping("/platos/{id}")
	public Plato actualizarPlato(@PathVariable(name="idPlato")int IdPlato,@RequestBody Plato plato) {
		//Creamos dos platos
		Plato platoSeleccionado = new Plato();
		Plato platoActualizado = new Plato();
		
		//El platoSeleccionado copia los datos del usuario que esta en la BD, buscando por el ID
		platoSeleccionado = platosServiceImpl.platoXID(IdPlato);
		
		//Actualizamos valores
		platoSeleccionado.setNombre(plato.getNombre());
		platoSeleccionado.setDescripcion(plato.getDescripcion());
		platoSeleccionado.setImagen(plato.getImagen());
		platoSeleccionado.setPrecioUnitario(plato.getPrecioUnitario());
		platoSeleccionado.setTipo(plato.getTipo());
		platoSeleccionado.setIdCategoria(plato.getIdCategoria());
		
		platoActualizado = platosServiceImpl.actualizarPlato(platoSeleccionado);
		
		System.out.println("Usuario actualizado: " + platoActualizado);
		return platoActualizado;
	}
	
	@DeleteMapping("/platos/{id}")
	public void eliminarPlato(@PathVariable(name="idPlato")int IdPlato) {
		platosServiceImpl.eliminarPlato(IdPlato);
	}
}
