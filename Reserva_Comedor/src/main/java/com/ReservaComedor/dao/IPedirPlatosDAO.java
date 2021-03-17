package com.ReservaComedor.dao;



import  org.springframework.data.jpa.repository.JpaRepository;

import com.ReservaComedor.dto.PedirPlatos;


public interface IPedirPlatosDAO extends JpaRepository<PedirPlatos, Integer>{

}
