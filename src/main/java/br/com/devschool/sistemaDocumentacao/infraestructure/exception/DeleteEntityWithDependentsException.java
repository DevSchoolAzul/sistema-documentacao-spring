package br.com.devschool.sistemaDocumentacao.infraestructure.exception;

import lombok.Getter;

@Getter
public class DeleteEntityWithDependentsException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	private String entidade;
	private String metodo;
	
	public DeleteEntityWithDependentsException(String entidade, String metodo, String message) {
		super(message);
		this.entidade = entidade;
		this.metodo = metodo;
	}
}
