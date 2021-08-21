package br.com.devschool.sistemaDocumentacao.infraestructure.exception;

import lombok.Getter;

@Getter
public class DeleteEntityWithDependentsException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	public DeleteEntityWithDependentsException(String message) {
		super(message);
	}

}
