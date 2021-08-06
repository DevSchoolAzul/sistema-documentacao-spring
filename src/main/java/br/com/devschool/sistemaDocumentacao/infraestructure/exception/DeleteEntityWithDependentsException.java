package br.com.devschool.sistemaDocumentacao.infraestructure.exception;

public class DeleteEntityWithDependentsException extends Exception {
	private static final long serialVersionUID = 1L;

	public DeleteEntityWithDependentsException(String message) {
		super(message);
	}
}
