package br.com.devschool.sistemaDocumentacao.infraestructure.exception;

import lombok.Getter;

@Getter
public class NoContentException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	private String entidade;
	private String metodo;
	private String parametros;
	
	public NoContentException(String entidade, String metodo, String parametros, String message) {
		super(message);
		this.entidade = entidade;
		this.metodo = metodo;
		this.parametros = parametros;
	}
	
}
