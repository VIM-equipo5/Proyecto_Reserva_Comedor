package com.ReservaComedor.service.implementacion;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ReservaComedor.dao.IPedirPlatosDAO;
import com.ReservaComedor.dto.PedirPlato;
import com.ReservaComedor.service.interfaces.IPedirPlatosService;



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
	public List<PedirPlato> listarPedirPlatos() {
		return iPedirPlatosDAO.findAll();
	}

	@Override
	public PedirPlato guardarPedirPlatos(PedirPlato pedirPlato) {
		return iPedirPlatosDAO.save(pedirPlato);
	}

	@Override
	public PedirPlato pedirPlatosXID(Long idPedirPlatos) {
		return iPedirPlatosDAO.findById(idPedirPlatos).get();
	}

	@Override
	public PedirPlato actualizarPedirPlatos(PedirPlato pedirPlato) {
		return iPedirPlatosDAO.save(pedirPlato);
	}

	@Override
	public void eliminarPedirPlatos(Long IdPedirPlatos) {
		iPedirPlatosDAO.deleteById(IdPedirPlatos);
	}
	
}
