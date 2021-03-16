package com.ReservaComedor.controller;



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

import com.ReservaComedor.dto.Categoria;
import com.ReservaComedor.service.implementacion.CategoriaServiceImpl;



/**
 * @author Vyacheslav Khaydorov
 * @author Miguel A. Sastre
 * @author Ingrid Dominguez
 */

@RestController
@RequestMapping("/api")
public class CategoriaController {

	//Inyeccion de dependencias
	@Autowired
	CategoriaServiceImpl categoriaServiceImpl;

	//End-points
	@GetMapping("/categorias")
	public List<Categoria> listarCategoria(){
		return categoriaServiceImpl.listarCategoria();
	}
	
	@PostMapping("/categorias")
	public Categoria guardarCategoria(@RequestBody Categoria categoria) {
		return categoriaServiceImpl.guardarCategoria(categoria);
	}
	
	@GetMapping("/categorias/{id}")
	public Categoria categoriaXID(@PathVariable(name="idCategoria") int IdCategoria) {
		Categoria categoriaBuscada = new Categoria();	
		categoriaBuscada = categoriaServiceImpl.categoriaXID(IdCategoria);
		System.out.println("Categoria buscada: " + categoriaBuscada);
		return categoriaBuscada;
	}
	
	@PutMapping("/categorias/{id}")
	public Categoria actualizarCategoria(@PathVariable(name="idCategoria")int IdCategoria,@RequestBody Categoria categoria) {
		//Creamos dos platos
		Categoria categoriaSeleccionada = new Categoria();
		Categoria categoriaActualizada = new Categoria();
		
		//El platoSeleccionado copia los datos del usuario que esta en la BD, buscando por el ID
		categoriaSeleccionada = categoriaServiceImpl.categoriaXID(IdCategoria);
		
		//Actualizamos valores
		categoriaSeleccionada.setIdCategoria(categoria.getIdCategoria());
		categoriaSeleccionada.setNombre(categoria.getNombre());
		categoriaSeleccionada.setDescripcion(categoria.getDescripcion());
		
		categoriaActualizada = categoriaServiceImpl.actualizarCategoria(categoriaSeleccionada);
		
		System.out.println("Categoria actualizada: " + categoriaActualizada);
		return categoriaActualizada;
	}
	
	@DeleteMapping("/categoria/{id}")
	public void eliminarCategoria(@PathVariable(name="idCategoria")int IdCategoria) {
		categoriaServiceImpl.eliminarCategoria(IdCategoria);
	}
}

