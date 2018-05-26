package com.udemy.helpdesk.api.entidade;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import com.udemy.helpdesk.api.perfil.PerfilEnum;

@Document
public class Usuario {
	
	@Id
	private String id;
	
	@Indexed(unique = true)//Email Unico
	@NotBlank(message="Email Obrigatorio") //MENSAGEM ASSOCIADA AO CAMPO
	@Email(message="Email invalido!")
	private String email;
	
	
	@NotBlank(message="Senha Obrigatorio") //MENSAGEM ASSOCIADA AO CAMPO
	@Size(min=6)//DEFINIR TAMANHO
	private String senha;
	
	private PerfilEnum perfil;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public PerfilEnum getPerfil() {
		return perfil;
	}

	public void setPerfil(PerfilEnum perfil) {
		this.perfil = perfil;
	}
	
	

}
