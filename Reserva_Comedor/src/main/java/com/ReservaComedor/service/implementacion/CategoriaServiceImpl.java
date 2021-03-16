package com.ReservaComedor.service.implementacion;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ReservaComedor.dao.ICategoriaDAO;
import com.ReservaComedor.dto.Categoria;
import com.ReservaComedor.service.interfaces.ICategoriaService;


/**
 * @author Vyacheslav Khaydorov
 * @author Miguel A. Sastre
 * @author Ingrid Dominguez
 */

@Service
public class CategoriaServiceImpl implements ICategoriaService {

	//Inyeccion de dependencias
	@Autowired
	ICategoriaDAO iCategoriaDAO;

	//Metodos de la interfaz implementados
	@Override
	public List<Categoria> listarCategoria() {
		return iCategoriaDAO.findAll();
	}

	@Override
	public Categoria guardarCategoria(Categoria categoria) {
		return iCategoriaDAO.save(categoria);
	}

	@Override
	public Categoria categoriaXID(int IdCategoria) {
		return iCategoriaDAO.findById(IdCategoria).get();
	}

	@Override
	public Categoria actualizarCategoria(Categoria categoria) {
		return iCategoriaDAO.save(categoria);
	}

	@Override
	public void eliminarCategoria(int IdCategoria) {
		iCategoriaDAO.deleteById(IdCategoria);
	}
	
}
