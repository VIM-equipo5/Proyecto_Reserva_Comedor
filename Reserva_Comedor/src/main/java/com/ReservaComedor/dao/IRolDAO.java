package com.ReservaComedor.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import com.ReservaComedor.dto.Rol;


/**
 * @author viach
 *
 */
public interface IRolDAO extends JpaRepository<Rol, Integer> {

}
