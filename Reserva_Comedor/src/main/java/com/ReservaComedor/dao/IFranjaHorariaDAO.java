package com.ReservaComedor.dao;


import org.springframework.data.jpa.repository.JpaRepository;

import com.ReservaComedor.dto.FranjaHoraria;


/**
 * @author viach
 *
 */
public interface IFranjaHorariaDAO extends JpaRepository<FranjaHoraria, Integer> {

}
