package com.udemy.helpdesk.api.service;

import java.util.Optional;

import org.springframework.data.domain.Page;

import com.udemy.helpdesk.api.entidade.Usuario;

public interface UsuarioService {

	//Buscar
	Usuario findByEmail(String email);
	
	//Criar e alterar
	Usuario createOrUpdate(Usuario usuario);
	
	//Detalhar Usuario
	Optional<Usuario> findById(String id);
	
	//Deletar
	void delete(String id);
	
	Page<Usuario> findAll(int page, int count); //passar pagina e quantidade de registro
	
	
	
}
