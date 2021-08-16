package br.com.devschool.sistemaDocumentacao.domain.internal.service.logBanco.impl;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.devschool.sistemaDocumentacao.domain.internal.model.logBanco.LogBanco;
import br.com.devschool.sistemaDocumentacao.domain.internal.service.logBanco.LogBancoService;
import br.com.devschool.sistemaDocumentacao.infraestructure.repository.LogBanco.LogBancoRepository;

@Service
public class LogBancoServiceImpl implements LogBancoService{

	@Autowired
	private LogBancoRepository logBancoRepository;

	@Override
	public void salvarLog(String recurso, String metodo, String parametros) {
		LogBanco log = new LogBanco(recurso, metodo, LocalDateTime.now(), parametros);
		logBancoRepository.save(log);		
	}
}
