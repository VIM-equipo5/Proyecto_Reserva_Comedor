package com.example.demo.service.intefaces;

import java.util.List;
import com.example.demo.dto.Categoria;

/**
 * @author Vyacheslav Khaydorov
 * @author Miguel A. Sastre
 * @author Ingrid Dominguez
 */
public interface ICategoriaService {
	//Metodos del CRUD
	public List<Categoria> listarCategoria();	//Listar All 
	
	public Categoria guardarCategoria(Categoria categoria);	//Guarda una categoria (CREATE)
	
	public Categoria categoriaXID(int IdPlato);	//Leer datos de una categoria (READ)
	
	public Categoria actualizarCategoria(Categoria categoria);	//Actualiza datos de la categoria (UPDATE)
	
	public void eliminarCategoria(int IdCategoria);	//Elimina una categoria (DELETE)
	
}