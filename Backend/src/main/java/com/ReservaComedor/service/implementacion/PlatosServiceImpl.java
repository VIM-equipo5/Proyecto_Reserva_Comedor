package com.ReservaComedor.service.implementacion;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ReservaComedor.dao.IPlatosDAO;
import com.ReservaComedor.dto.Platos;
import com.ReservaComedor.service.interfaces.IPlatosService;



/**
 * @author Vyacheslav Khaydorov
 * @author Miguel A. Sastre
 * @author Ingrid Dominguez
 */

@Service
public class PlatosServiceImpl implements IPlatosService {

	//Inyeccion de dependencias
	@Autowired
	IPlatosDAO iPlatosDAO;

	//Metodos de la interfaz implementados
	@Override
	public List<Platos> listarPlatos() {
		return iPlatosDAO.findAll();
	}

	@Override
	public Platos guardarPlato(Platos plato) {
		return iPlatosDAO.save(plato);
	}

	@Override
	public Platos platoXID(int IdPlato) {
		return iPlatosDAO.findById(IdPlato).get();
	}

	@Override
	public Platos actualizarPlato(Platos plato) {
		return iPlatosDAO.save(plato);
	}

	@Override
	public void eliminarPlato(int idPlato) {
		iPlatosDAO.deleteById(idPlato);
	}
	
}
