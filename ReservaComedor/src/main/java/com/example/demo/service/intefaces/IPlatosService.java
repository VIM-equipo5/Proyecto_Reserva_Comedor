package com.example.demo.service.intefaces;

import java.util.List;
import com.example.demo.dto.Platos;

/**
 * @author Vyacheslav Khaydorov
 * @author Miguel A. Sastre
 * @author Ingrid Dominguez
 */
public interface IPlatosService {
	//Metodos del CRUD
	public List<Platos> listarPlatos();	//Listar All 
	
	public Platos guardarPlato(Platos plato);	//Guarda un plato (CREATE)
	
	public Platos platoXID(int IdPlato);	//Leer datos de un plato (READ)
	
	public Platos actualizarPlato(Platos plato);	//Actualiza datos del plato (UPDATE)
	
	public void eliminarPlato(int IdPlato);	//Elimina el plato (DELETE)
	
}
