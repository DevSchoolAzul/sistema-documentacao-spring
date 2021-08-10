package br.com.devschool.sistemaDocumentacao.aplication.errorHandler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import br.com.devschool.sistemaDocumentacao.aplication.errorHandler.dto.ResponseErrorDto;
import br.com.devschool.sistemaDocumentacao.domain.internal.service.logBanco.LogBancoService;
import br.com.devschool.sistemaDocumentacao.infraestructure.exception.DeleteEntityWithDependentsException;
import br.com.devschool.sistemaDocumentacao.infraestructure.exception.NoContentException;

@RestControllerAdvice
public class ErrorHandler {
	
	@Autowired
	private LogBancoService logBancoService;
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ResponseErrorDto> parametrosInvalidos(MethodArgumentNotValidException exception) {
		
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ResponseErrorDto(exception.getMessage()));
	}

	@ExceptionHandler(NoContentException.class)
	public ResponseEntity<ResponseErrorDto> conteudoNaoEncontrado(NoContentException exception) {
		logBancoService.salvarLog(exception.getEntidade(), exception.getMetodo(), exception.getParametros());
		return ResponseEntity.status(HttpStatus.NO_CONTENT).body(new ResponseErrorDto(exception.getMessage()));
	}

	@ExceptionHandler(DeleteEntityWithDependentsException.class)
	public ResponseEntity<ResponseErrorDto> falhaAoDeletar(DeleteEntityWithDependentsException exception) {
		logBancoService.salvarLog(exception.getEntidade(), exception.getMetodo(), exception.getParametros());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseErrorDto(exception.getMessage()));
	}
	
	@ExceptionHandler(HttpMessageNotReadableException.class)
	public ResponseEntity<ResponseErrorDto> tipoDoParametroInvalido(HttpMessageNotReadableException exception) {
		
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ResponseErrorDto(exception.getMessage()));
	}
	
	
}
