/**
 * Controller para Rol
 */
package com.VIMequipo5.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.VIMequipo5.model.dto.Rol;
import com.VIMequipo5.model.service.RolServiceImpl;

/**
 * @author viach
 *
 */

@RestController
@RequestMapping("/api")
public class RolController {

	//Inyeccion de dependencias
	@Autowired
	RolServiceImpl rolServiceImpl;

	//End-points
	@GetMapping("/rol")
	public List<Rol> listarRol(){
		return rolServiceImpl.listarRol();
	}
	
	@PostMapping("/rol")
	public Rol guardarRol(@RequestBody Rol rol) {
		return rolServiceImpl.guardarRol(rol);
	}
	
	@GetMapping("/rol/{id}")
	public Rol rolXID(@PathVariable(name="idRol") int idRol) {
		Rol rolBuscado = new Rol();	
		rolBuscado = rolServiceImpl.rolXID(idRol);
		System.out.println("Rol: " + rolBuscado);
		return rolBuscado;
	}
	
	@PutMapping("/rol/{id}")
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
	
	@DeleteMapping("/rol/{id}")
	public void eliminarRol(@PathVariable(name="idRol")int idRol) {
		rolServiceImpl.eliminarRol(idRol);
	}
}
