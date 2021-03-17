package com.ReservaComedor.dao;



import org.springframework.data.jpa.repository.JpaRepository;

import com.ReservaComedor.dto.Plato;


public interface IPlatosDAO extends JpaRepository<Plato, Integer> {

}
