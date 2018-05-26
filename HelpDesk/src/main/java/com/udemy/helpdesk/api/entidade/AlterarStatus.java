package com.udemy.helpdesk.api.entidade;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import com.udemy.helpdesk.api.perfil.StatusEnum;

@Document
public class AlterarStatus {

	@Id
	private String id;
	
	@DBRef
	private Ticket ticketAlterado;//POSSIU UM TICKET (QUE FOI ALTERADO O STATUS)
	
	@DBRef
	private Usuario usuarioAlterado; //USUARIO QUE FEZ ALTERAÇÃO
	
	private Date dataAlteracaoStatus; //DATA DA ALTERAÇÃO
	
	private StatusEnum statusAlterado ;//STAUS QUE TAVA

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Ticket getTicketAlterado() {
		return ticketAlterado;
	}

	public void setTicketAlterado(Ticket ticketAlterado) {
		this.ticketAlterado = ticketAlterado;
	}

	public Usuario getUsuarioAlterado() {
		return usuarioAlterado;
	}

	public void setUsuarioAlterado(Usuario usuarioAlterado) {
		this.usuarioAlterado = usuarioAlterado;
	}

	public Date getDataAlteracaoStatus() {
		return dataAlteracaoStatus;
	}

	public void setDataAlteracaoStatus(Date dataAlteracaoStatus) {
		this.dataAlteracaoStatus = dataAlteracaoStatus;
	}

	public StatusEnum getStatusAlterado() {
		return statusAlterado;
	}

	public void setStatusAlterado(StatusEnum statusAlterado) {
		this.statusAlterado = statusAlterado;
	}
	
	
}
