package br.com.devschool.sistemaDocumentacao.infraestructure.exception;

import lombok.Getter;

@Getter
public class NoContentException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	public NoContentException(String message) {
		super(message);
	}
	
}
