package com.ReservaComedor.dao;



import  org.springframework.data.jpa.repository.JpaRepository;

import com.ReservaComedor.dto.PedirPlato;


public interface IPedirPlatosDAO extends JpaRepository<PedirPlato, Integer>{

}
