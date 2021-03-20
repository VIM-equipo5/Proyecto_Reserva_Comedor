/**
 * 
 */
package com.ReservaComedor.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ReservaComedor.dto.UsuarioApi;



/**
 * @author Vyacheslav Khaydorov
 * @author Miguel A. Sastre
 * @author Ingrid Dominguez
 */

public interface IUsuarioApiDAO extends JpaRepository<UsuarioApi, Long> {

	UsuarioApi findByUsername(String username);
}