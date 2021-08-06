package br.com.devschool.sistemaDocumentacao.infraestructure.exception;

public class NoContentException extends Exception {
	private static final long serialVersionUID = 1L;

	public NoContentException(String message) {
		super(message);
	}
	
}
