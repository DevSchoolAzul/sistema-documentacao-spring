package br.com.devschool.sistemaDocumentacao.infraestructure.repository.LogBanco;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.devschool.sistemaDocumentacao.domain.internal.model.logBanco.LogBanco;
	
public interface LogBancoRepository extends JpaRepository<LogBanco, Long> {

}
