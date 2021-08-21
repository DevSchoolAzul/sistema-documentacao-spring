package br.com.devschool.sistemaDocumentacao.aplication.errorHandler;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import br.com.devschool.sistemaDocumentacao.aplication.errorHandler.dto.ResponseErrorDto;
import br.com.devschool.sistemaDocumentacao.aplication.errorHandler.dto.ResponseFieldErrorDto;
import br.com.devschool.sistemaDocumentacao.infraestructure.exception.DeleteEntityWithDependentsException;
import br.com.devschool.sistemaDocumentacao.infraestructure.exception.NoContentException;

@RestControllerAdvice
public class ErrorHandler {

	private static final Logger logger = LoggerFactory.getLogger(ErrorHandler.class);

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ResponseFieldErrorDto> parametrosInvalidos(MethodArgumentNotValidException exception, HttpServletRequest request) {
		ResponseFieldErrorDto erro = ResponseFieldErrorDto.builder().message("Erro de validação")
				.fields(exception.getBindingResult().getFieldErrors()).build();
		logger.info("Erro de validação. [usuario = {}, URI = {}, parametros = {}, metodo = {}]",
				request.getUserPrincipal(), request.getRequestURI(), request.getQueryString(), request.getMethod());
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(erro);
	}

	@ExceptionHandler(NoContentException.class)
	public ResponseEntity<ResponseErrorDto> conteudoNaoEncontrado(NoContentException exception,
			HttpServletRequest request) {
		logger.info("Conteudo não encontrado. [usuario = {}, URI = {}, parametros = {}, metodo = {}]",
				request.getUserPrincipal(), request.getRequestURI(), request.getQueryString(), request.getMethod());
		return ResponseEntity.status(HttpStatus.NO_CONTENT).body(new ResponseErrorDto(exception.getMessage()));
	}

	@ExceptionHandler(DeleteEntityWithDependentsException.class)
	public ResponseEntity<ResponseErrorDto> falhaAoDeletar(DeleteEntityWithDependentsException exception, HttpServletRequest request) {
		logger.info(exception.getMessage() + " [usuario = {}, URI = {}, parametros = {}, metodo = {}]",
				request.getUserPrincipal(), request.getRequestURI(), request.getQueryString(), request.getMethod());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseErrorDto(exception.getMessage()));
	}

	@ExceptionHandler(HttpMessageNotReadableException.class)
	public ResponseEntity<ResponseErrorDto> tipoDoParametroInvalido(HttpMessageNotReadableException exception, HttpServletRequest request) {
		logger.info("Tipo dos parametros invalidos. [usuario = {}, URI = {}, parametros = {}, metodo = {}]",
				request.getUserPrincipal(), request.getRequestURI(), request.getQueryString(), request.getMethod());
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
				.body(new ResponseErrorDto("Tipo dos parametros invalidos"));
	}

}
