package com.ReservaComedor.service.interfaces;


import java.util.List;

import com.ReservaComedor.dto.PedirPlatos;



/**
 * @author Vyacheslav Khaydorov
 * @author Miguel A. Sastre
 * @author Ingrid Dominguez
 */
public interface IPedirPlatosService {

	//Metodos del CRUD
	public List<PedirPlatos> listarPedirPlatos();	
	
	public PedirPlatos guardarPedirPlatos(PedirPlatos pedirPlatos);	
	
	public PedirPlatos pedirPlatosXID(int IdPrepararPlatos);	
	
	public PedirPlatos actualizarPedirPlatos(PedirPlatos pedirPlatos);	
	
	public void eliminarPedirPlatos(int IdPrepararPlatos);	
	
}