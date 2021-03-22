package com.ReservaComedor.service.interfaces;


import java.util.List;

import com.ReservaComedor.dto.PedirPlato;



/**
 * @author Vyacheslav Khaydorov
 * @author Miguel A. Sastre
 * @author Ingrid Dominguez
 */
public interface IPedirPlatosService {

	//Metodos del CRUD
	public List<PedirPlato> listarPedirPlatos();	
	
	public PedirPlato guardarPedirPlatos(PedirPlato pedirPlato);	
	
	public PedirPlato pedirPlatosXID(int IdPrepararPlatos);	
	
	public PedirPlato actualizarPedirPlatos(PedirPlato pedirPlato);	
	
	public void eliminarPedirPlatos(int IdPrepararPlatos);	
	
}