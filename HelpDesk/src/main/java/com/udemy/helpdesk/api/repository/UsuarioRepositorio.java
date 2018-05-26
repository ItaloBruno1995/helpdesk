package com.udemy.helpdesk.api.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.udemy.helpdesk.api.entidade.Usuario;
//Objeto e Tipo Id
public interface UsuarioRepositorio extends MongoRepository<Usuario, String> {

	Usuario findByEmail(String email);//PESQUISAR USUARIO POR EMAIL
	
}
