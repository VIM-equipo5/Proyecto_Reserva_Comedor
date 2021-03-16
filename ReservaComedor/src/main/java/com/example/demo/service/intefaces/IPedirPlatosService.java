package com.example.demo.service.intefaces;

import java.util.List;

import com.example.demo.dto.PedirPlatos;

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