package br.com.devschool.sistemaDocumentacao.aplication.errorHandler.dto;

public class ResponseErrorDto {

	private String message;

	public ResponseErrorDto(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
	
}
