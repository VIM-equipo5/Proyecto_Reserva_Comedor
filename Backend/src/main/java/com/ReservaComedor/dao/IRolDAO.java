package com.ReservaComedor.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import com.ReservaComedor.dto.Rol;


/**
 * @author Vyacheslav Khaydorov
 * @author Miguel A. Sastre
 * @author Ingrid Dominguez
 */

public interface IRolDAO extends JpaRepository<Rol, Integer> {

}
