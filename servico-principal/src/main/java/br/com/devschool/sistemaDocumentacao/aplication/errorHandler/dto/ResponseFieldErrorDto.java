package br.com.devschool.sistemaDocumentacao.aplication.errorHandler.dto;

import java.util.List;

import org.springframework.validation.FieldError;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ResponseFieldErrorDto {

	private String message;
	private List<FieldError> fields;
}
