package com.ReservaComedor.service.interfaces;



import java.util.List;

import com.ReservaComedor.dto.Plato;


/**
 * @author Vyacheslav Khaydorov
 * @author Miguel A. Sastre
 * @author Ingrid Dominguez
 */
public interface IPlatosService {
	//Metodos del CRUD
	public List<Plato> listarPlatos();	//Listar All 
	
	public Plato guardarPlato(Plato plato);	//Guarda un plato (CREATE)
	
	public Plato platoXID(int IdPlato);	//Leer datos de un plato (READ)
	
	public Plato actualizarPlato(Plato plato);	//Actualiza datos del plato (UPDATE)
	
	public void eliminarPlato(int IdPlato);	//Elimina el plato (DELETE)
	
}
