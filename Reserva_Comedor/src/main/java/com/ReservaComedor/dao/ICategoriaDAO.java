package com.ReservaComedor.dao;



import org.springframework.data.jpa.repository.JpaRepository;

import com.ReservaComedor.dto.Categoria;

/**
 * @author Vyacheslav Khaydorov
 * @author Miguel A. Sastre
 * @author Ingrid Dominguez
 */


public interface ICategoriaDAO extends JpaRepository<Categoria, Integer> {

}
