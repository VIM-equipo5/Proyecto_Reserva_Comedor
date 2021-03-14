/**
 * 
 */
package com.VIMequipo5.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.VIMequipo5.model.dto.Usuario;

/**
 * @author viach
 *
 */
public interface IUsuarioDAO extends JpaRepository<Usuario, Integer> {

}
