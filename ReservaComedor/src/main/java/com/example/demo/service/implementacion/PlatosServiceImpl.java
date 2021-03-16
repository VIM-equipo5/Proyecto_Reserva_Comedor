package com.example.demo.service.implementacion;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.IPlatosDAO;
import com.example.demo.dto.Platos;
import com.example.demo.service.intefaces.IPlatosService;

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
	public void eliminarPlato(int IdUsuario) {
		iPlatosDAO.deleteById(IdUsuario);
	}
	
}
