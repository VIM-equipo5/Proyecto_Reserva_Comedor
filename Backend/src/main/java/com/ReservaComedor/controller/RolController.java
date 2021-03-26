package com.ReservaComedor.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.ReservaComedor.dto.Rol;
import com.ReservaComedor.service.implementacion.RolServiceImpl;



/**
 * @author Vyacheslav Khaydorov
 * @author Miguel A. Sastre
 * @author Ingrid Dominguez
 */

@RestController
@RequestMapping("/api")
public class RolController {

	//Inyeccion de dependencias
	@Autowired
	RolServiceImpl rolServiceImpl;

	//End-points
	@GetMapping("/roles")
	public List<Rol> listarRol(){
		return rolServiceImpl.listarRol();
	}
	
	@PostMapping("/roles")
	public Rol guardarRol(@RequestBody Rol rol) {
		return rolServiceImpl.guardarRol(rol);
	}
	
	@GetMapping("/roles/{idRol}")
	public Rol rolXID(@PathVariable(name="idRol") int idRol) {
		Rol rolBuscado = new Rol();	
		rolBuscado = rolServiceImpl.rolXID(idRol);
		System.out.println("Rol: " + rolBuscado);
		return rolBuscado;
	}
	
	@PutMapping("/roles/{idRol}")
	public Rol actualizarRol(@PathVariable(name="idRol")int idRol,@RequestBody Rol rol) {
		//Creamos dos roles
		Rol rolSeleccionado = new Rol();
		Rol rolActualizado = new Rol();
		
		//El rolSeleccionado copia los datos del rol que esta en la BD, buscando por el ID
		rolSeleccionado = rolServiceImpl.rolXID(idRol);
		
		//Actualizamos valores
		rolSeleccionado.setNombreRol(rol.getNombreRol());
		rolSeleccionado.setDescripcion(rol.getDescripcion());
		
		//...
		rolActualizado = rolServiceImpl.actualizarRol(rolSeleccionado);
		
		System.out.println("Rol actualizado: " + rolActualizado);
		return rolActualizado;
	}
	
	@DeleteMapping("/roles/{idRol}")
	public void eliminarRol(@PathVariable(name="idRol")int idRol) {
		rolServiceImpl.eliminarRol(idRol);
	}
}
