package com.ReservaComedor.service.implementacion;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ReservaComedor.dao.IPlatosDAO;
import com.ReservaComedor.dto.Plato;
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
	public List<Plato> listarPlatos() {
		return iPlatosDAO.findAll();
	}

	@Override
	public Plato guardarPlato(Plato plato) {
		return iPlatosDAO.save(plato);
	}

	@Override
	public Plato platoXID(int IdPlato) {
		return iPlatosDAO.findById(IdPlato).get();
	}

	@Override
	public Plato actualizarPlato(Plato plato) {
		return iPlatosDAO.save(plato);
	}

	@Override
	public void eliminarPlato(int IdUsuario) {
		iPlatosDAO.deleteById(IdUsuario);
	}
	
}
