package com.ReservaComedor.dao;


import org.springframework.data.jpa.repository.JpaRepository;

import com.ReservaComedor.dto.Usuario;


/**
 * @author viach
 *
 */
public interface IUsuarioDAO extends JpaRepository<Usuario, Integer> {

}
