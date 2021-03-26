package com.ReservaComedor.dao;



import  org.springframework.data.jpa.repository.JpaRepository;

import com.ReservaComedor.dto.PedirPlato;

/**
 * @author Vyacheslav Khaydorov
 * @author Miguel A. Sastre
 * @author Ingrid Dominguez
 */

public interface IPedirPlatosDAO extends JpaRepository<PedirPlato, Long>{

}
