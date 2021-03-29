/**
 * Interfaz Bebida service
 */
package com.ReservaComedor.service.interfaces;

import java.util.List;

import com.ReservaComedor.dto.Bebida;



/**
 * @author Vyacheslav Khaydorov
 * @author Miguel A. Sastre
 * @author Ingrid Dominguez
 */
public interface IBebidaService {

	//Metodos del CRUD
	public List<Bebida> listarBebida();	
	
	public Bebida guardarBebida(Bebida bebida);
	
	public Bebida bebidaXID(Long idBebida);	
	
	public Bebida actualizarBebida(Bebida bebida);	
	
	public void eliminarBebida(Long idBebida);	
	
	public List<Bebida> bebidaXNombre(String nombreBebida);
	
}
