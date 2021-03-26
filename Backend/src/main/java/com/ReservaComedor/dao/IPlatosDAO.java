package com.ReservaComedor.dao;



import org.springframework.data.jpa.repository.JpaRepository;

import com.ReservaComedor.dto.Platos;

/**
 * @author Vyacheslav Khaydorov
 * @author Miguel A. Sastre
 * @author Ingrid Dominguez
 */

public interface IPlatosDAO extends JpaRepository<Platos, Integer> {

}
