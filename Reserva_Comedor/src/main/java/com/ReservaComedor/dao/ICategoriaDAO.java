package com.ReservaComedor.dao;



import org.springframework.data.jpa.repository.JpaRepository;

import com.ReservaComedor.dto.Categoria;


public interface ICategoriaDAO extends JpaRepository<Categoria, Integer> {

}
