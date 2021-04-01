package com.ReservaComedor.controller;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.ReservaComedor.dto.Platos;
import com.ReservaComedor.service.implementacion.PlatosServiceImpl;




/**
 * @author Vyacheslav Khaydorov
 * @author Miguel A. Sastre
 * @author Ingrid Dominguez
 */

@RestController
@CrossOrigin(origins="*",methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.DELETE,RequestMethod.PUT})
@RequestMapping("/api")
public class PlatosController {

	//Inyeccion de dependencias
	@Autowired
	PlatosServiceImpl platosServiceImpl;

	//End-points
	@GetMapping("/platos")
	public List<Platos> listarPlatos(){
		return platosServiceImpl.listarPlatos();
	}
	
	@PostMapping("/platos")
	public Platos guardarPlato(@RequestBody Platos plato) {
		return platosServiceImpl.guardarPlato(plato);
	}
	
	@GetMapping("/platos/{idPlato}")
	public Platos platoXID(@PathVariable(name="idPlato") int IdPlato) {
		Platos platoBuscado = new Platos();	
		platoBuscado = platosServiceImpl.platoXID(IdPlato);
		System.out.println("Plato: " + platoBuscado);
		return platoBuscado;
	}
	
	@GetMapping("/platos/nombre/{nombrePlato}")
	public List<Platos> platoXNombre(@PathVariable(name="nombrePlato") String nombrePlato) {
		return platosServiceImpl.platoXNombre(nombrePlato);
	}
	
	@PutMapping("/platos/{idPlato}")
	public Platos actualizarPlato(@PathVariable(name="idPlato")int IdPlato,@RequestBody Platos plato) {
		//Creamos dos platos
		Platos platoSeleccionado = new Platos();
		Platos platoActualizado = new Platos();
		
		//El platoSeleccionado copia los datos del usuario que esta en la BD, buscando por el ID
		platoSeleccionado = platosServiceImpl.platoXID(IdPlato);
		
		//Actualizamos valores
		platoSeleccionado.setNombre(plato.getNombre());
		platoSeleccionado.setDescripcion(plato.getDescripcion());
		platoSeleccionado.setImagen(plato.getImagen());
		platoSeleccionado.setPrecioUnitario(plato.getPrecioUnitario());
		platoSeleccionado.setTipo(plato.getTipo());
		
		platoActualizado = platosServiceImpl.actualizarPlato(platoSeleccionado);
		
		System.out.println("Usuario actualizado: " + platoActualizado);
		return platoActualizado;
	}
	
	@DeleteMapping("/platos/{idPlato}")
	public void eliminarPlato(@PathVariable(name="idPlato")int IdPlato) {
		platosServiceImpl.eliminarPlato(IdPlato);
	}
}
