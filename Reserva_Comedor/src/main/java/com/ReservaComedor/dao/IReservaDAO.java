package com.ReservaComedor.dao;


import org.springframework.data.jpa.repository.JpaRepository;

import com.ReservaComedor.dto.Reserva;


/**
 * @author Vyacheslav Khaydorov
 * @author Miguel A. Sastre
 * @author Ingrid Dominguez
 */

public interface IReservaDAO extends JpaRepository<Reserva, Long> {

}
