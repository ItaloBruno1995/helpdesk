package com.udemy.helpdesk.api.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.udemy.helpdesk.api.entidade.Usuario;
import com.udemy.helpdesk.api.security.jwt.JwtUserFactory;
import com.udemy.helpdesk.api.service.UsuarioService;

@Service
public class JwtUserDetailsServiceImpl implements UserDetailsService {
 
	@Autowired
	private UsuarioService userservice;
	
	
	//Carregar Usuario
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
			Usuario user = userservice.findByEmail(email);
			if(user == null){
				throw new UsernameNotFoundException(String.format("No user found with username '%s'.", email));
			}else{
				return JwtUserFactory.create(user);
		}
	}

	
}
