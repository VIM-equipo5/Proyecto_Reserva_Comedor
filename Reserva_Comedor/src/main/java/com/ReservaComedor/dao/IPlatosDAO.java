package com.ReservaComedor.dao;



import org.springframework.data.jpa.repository.JpaRepository;

import com.ReservaComedor.dto.Platos;


public interface IPlatosDAO extends JpaRepository<Platos, Integer> {

}
