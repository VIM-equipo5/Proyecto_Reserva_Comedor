package com.ReservaComedor.dao;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ReservaComedor.dto.Usuario;


/**
 * @author Vyacheslav Khaydorov
 * @author Miguel A. Sastre
 * @author Ingrid Dominguez
 */

public interface IUsuarioDAO extends JpaRepository<Usuario, Integer> {
	public List<Usuario> findBynombreUsuario(String nombreUsuario);

}
