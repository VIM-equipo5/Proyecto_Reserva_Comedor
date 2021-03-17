package com.ReservaComedor.dao;


import org.springframework.data.jpa.repository.JpaRepository;

import com.ReservaComedor.dto.OfrecerBebida;


/**
 * @author Vyacheslav Khaydorov
 * @author Miguel A. Sastre
 * @author Ingrid Dominguez
 */

public interface IOfrecerBebidaDAO extends JpaRepository<OfrecerBebida, Long> {

}
