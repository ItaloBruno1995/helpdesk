package com.udemy.helpdesk.api.repository;



import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.udemy.helpdesk.api.entidade.Ticket;

public interface TicketRepositorio extends MongoRepository<Ticket, String> {
/**
 * Metodos
 * Campos de pesquisa tem que ser igual ao mapeado na entidade
 * Containing equivale ao like
 */
	/**
	 * Metodos de Paginação:
	 */
	
	//Buscar Ticket Referente ao usuario
	Page<Ticket> findByUsuarioIdOrderByDataDesc(Pageable pages, String userId);
	
	//FILTRO:(Verifcar se campos corresponde a entidade)  Metodo filtro
	Page<Ticket> findByTituloIgnoreCaseContainingAndStatusAndPrioridadeOrderByDataDesc(
			String titulo, String status, String prioridade, Pageable page);
	
	
	//Filtro> Somentes com tecenicos atribuido a eles(USUARIOS ATRIBIDOS AUELE TIKCKET)
	Page<Ticket> findByTituloIgnoreCaseContainingAndStatusAndPrioridadeAndUsuarioIdOrderByDataDesc(
			String titulo, String status, String prioridade, Pageable page);
	
	//Filtro
	Page<Ticket> findByTituloIgnoreCaseContainingAndStatusAndPrioridadeAndUserAtribuidoIdOrderByDataDesc(
			String titulo, String status, String prioridade, Pageable page);
	
	//Filtro> pesquisa por numero do Ticket
	Page<Ticket> findByNumero(Integer numero, Pageable page);
	
	
	
}
