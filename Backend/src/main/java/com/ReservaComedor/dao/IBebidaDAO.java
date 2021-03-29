package com.ReservaComedor.dao;


import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.ReservaComedor.dto.Bebida;



/**
 * @author Vyacheslav Khaydorov
 * @author Miguel A. Sastre
 * @author Ingrid Dominguez
 */

public interface IBebidaDAO extends JpaRepository<Bebida, Long> {
	public List<Bebida> findBynombre(String nombreBebida);
}
