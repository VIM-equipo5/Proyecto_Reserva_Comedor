/**
 * 
 */
package com.ReservaComedor.service.implementacion;

import static java.util.Collections.emptyList;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.ReservaComedor.dao.IUsuarioApiDAO;
import com.ReservaComedor.dto.UsuarioApi;


/**
 * @author Miguel A. Sastre
 *
 */
@Service
public class UsuarioApiDetailsServiceImpl implements UserDetailsService {

	private IUsuarioApiDAO iUsuarioDAO;

	public UsuarioApiDetailsServiceImpl(IUsuarioApiDAO iUsuarioDAO) {
		this.iUsuarioDAO = iUsuarioDAO;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UsuarioApi usuario = iUsuarioDAO.findByUsername(username);
		if (usuario == null) {
			throw new UsernameNotFoundException(username);
		}
		return new User(usuario.getUsername(), usuario.getPassword(), emptyList());
	}
	
}
