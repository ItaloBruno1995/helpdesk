package com.udemy.helpdesk.api.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.udemy.helpdesk.api.entidade.AlterarStatus;

public interface AlterarStatusRepositorio  extends MongoRepository<AlterarStatus, String>{
/**
 * Metodos de pesquisa
 */
	
	//Busca alteração de um  Tiket pelo seu Id e ordenar pela data que foi alterado
	Iterable<AlterarStatus> findByTicketAlteradoIdOrderByDataAlteracaoStatusDesc(String tiketId);
	/**
	 * Interable: será usado para o sumário (Mostrar a quantidade de cada estado do ticket)
	 */
}
