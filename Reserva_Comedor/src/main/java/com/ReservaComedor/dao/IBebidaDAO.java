package com.ReservaComedor.dao;


import org.springframework.data.jpa.repository.JpaRepository;

import com.ReservaComedor.dto.Bebida;


/**
 * @author Vyacheslav Khaydorov
 * @author Miguel A. Sastre
 * @author Ingrid Dominguez
 */

public interface IBebidaDAO extends JpaRepository<Bebida, Long> {

}
