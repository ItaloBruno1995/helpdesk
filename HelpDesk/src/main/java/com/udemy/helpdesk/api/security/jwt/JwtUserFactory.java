package com.udemy.helpdesk.api.security.jwt;

import com.udemy.helpdesk.api.entidade.Usuario;
import com.udemy.helpdesk.api.perfil.PerfilEnum;
import com.udemy.helpdesk.api.perfil.PrioridadeEnum;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

public class JwtUserFactory {

	private  JwtUserFactory() {
	
	}
	//Gera um JWT User(com base nos dados do usario)
	public static JwtUser create(Usuario user ){
		return new JwtUser(user.getId(), user.getEmail(), user.getSenha(), 
				mapToGrantedAuthorities(user.getPerfil()));
	}
	
	//Converte o perfil do uario para formato usado pelo spring security
	private static List<GrantedAuthority>mapToGrantedAuthorities(PerfilEnum perfilEnum){
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		authorities.add(new SimpleGrantedAuthority(perfilEnum.toString()));
		return authorities;
	}
}
