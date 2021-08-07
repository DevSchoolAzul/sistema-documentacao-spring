package br.com.devschool.sistemaDocumentacao.aplication.errorHandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import br.com.devschool.sistemaDocumentacao.aplication.errorHandler.dto.ResponseErrorDto;
import br.com.devschool.sistemaDocumentacao.infraestructure.exception.DeleteEntityWithDependentsException;
import br.com.devschool.sistemaDocumentacao.infraestructure.exception.NoContentException;

@RestControllerAdvice
public class ErrorHandler {
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ResponseErrorDto> parametrosInvalidos(MethodArgumentNotValidException exception) {
		
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ResponseErrorDto(exception.getMessage()));
	}

	@ExceptionHandler(NoContentException.class)
	public ResponseEntity<ResponseErrorDto> conteudoNaoEncontrado(NoContentException exception) {
		
		return ResponseEntity.status(HttpStatus.NO_CONTENT).body(new ResponseErrorDto(exception.getMessage()));
	}

	@ExceptionHandler(DeleteEntityWithDependentsException.class)
	public ResponseEntity<ResponseErrorDto> falhaAoDeletar(DeleteEntityWithDependentsException exception) {
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseErrorDto(exception.getMessage()));
	}
	
}
