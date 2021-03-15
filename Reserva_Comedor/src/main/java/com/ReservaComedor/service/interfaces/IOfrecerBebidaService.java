/**
 * Interfaz OfrecerBebida service
 */
package com.ReservaComedor.service.interfaces;

import java.util.List;

import com.ReservaComedor.dto.OfrecerBebida;



/**
 * @author Vyacheslav Khaydorov
 * @author Miguel A. Sastre
 * @author Ingrid Dominguez
 */
public interface IOfrecerBebidaService {

	//Metodos del CRUD
	public List<OfrecerBebida> listarOfrecerBebida();	
	
	public OfrecerBebida guardarOfrecerBebida(OfrecerBebida ofrecerBebida);	
	
	public OfrecerBebida ofrecerBebidaXID(Long idOfrecerBebida);	
	
	public OfrecerBebida actualizarOfrecerBebida(OfrecerBebida ofrecerBebida);	
	
	public void eliminarOfrecerBebida(Long idOfrecerBebida);	
	
}
