package com.udemy.helpdesk.api.service.impl.copy;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;

import org.springframework.stereotype.Service;
import org.springframework.data.domain.Pageable; //CORRETO
import org.springframework.data.domain.PageRequest;

import com.udemy.helpdesk.api.entidade.Usuario;
import com.udemy.helpdesk.api.repository.UsuarioRepositorio;
import com.udemy.helpdesk.api.service.UsuarioService;

@Service
public class UsuarioServiceImpl  implements UsuarioService{
//Injeção de Dependencia
	
	@Autowired
	private  UsuarioRepositorio usuarioRepositorio;
	
	@Override
	public Usuario findByEmail(String email) {
		return this.usuarioRepositorio.findByEmail(email);
	}

	@Override
	public Usuario createOrUpdate(Usuario usuario) {
		return this.usuarioRepositorio.save(usuario);
	}

	@Override
	public Optional<Usuario> findById(String id) {	
		return this.usuarioRepositorio.findById(id);
	}

	@Override
	public void delete(String id) {
		this.usuarioRepositorio.deleteById(id);
		
	}

	@Override
    public Page<Usuario> findAll(int page, int count) {
        Pageable pages = new PageRequest(page, count);
        return this.usuarioRepositorio.findAll(pages);
    }
	
	

}
