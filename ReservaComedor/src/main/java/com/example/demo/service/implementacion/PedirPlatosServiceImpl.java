package com.example.demo.service.implementacion;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.IPedirPlatosDAO;
import com.example.demo.dto.PedirPlatos;
import com.example.demo.service.intefaces.IPedirPlatosService;

/**
 * @author Vyacheslav Khaydorov
 * @author Miguel A. Sastre
 * @author Ingrid Dominguez
 */

@Service
public class PedirPlatosServiceImpl implements IPedirPlatosService {

	//Inyeccion de dependencias
	@Autowired
	IPedirPlatosDAO iPedirPlatosDAO;

	//Metodos de la interfaz implementados
	@Override
	public List<PedirPlatos> listarPedirPlatos() {
		return iPedirPlatosDAO.findAll();
	}

	@Override
	public PedirPlatos guardarPedirPlatos(PedirPlatos pedirPlatos) {
		return iPedirPlatosDAO.save(pedirPlatos);
	}

	@Override
	public PedirPlatos pedirPlatosXID(int IdPedirPlatos) {
		return iPedirPlatosDAO.findById(IdPedirPlatos).get();
	}

	@Override
	public PedirPlatos actualizarPedirPlatos(PedirPlatos pedirPlatos) {
		return iPedirPlatosDAO.save(pedirPlatos);
	}

	@Override
	public void eliminarPedirPlatos(int IdPedirPlatos) {
		iPedirPlatosDAO.deleteById(IdPedirPlatos);
	}
	
}
