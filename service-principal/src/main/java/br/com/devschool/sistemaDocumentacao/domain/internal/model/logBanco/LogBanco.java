package br.com.devschool.sistemaDocumentacao.domain.internal.model.logBanco;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Getter
@RequiredArgsConstructor
public class LogBanco {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NonNull
	private String recurso; // seria o nome da tela
	@NonNull
	private String metodo;
	@NonNull
	private LocalDateTime dateTime;
	@NonNull
	private String parametros;
//	private String usuario; // ainda não temos usuario na aplicação
		
}
