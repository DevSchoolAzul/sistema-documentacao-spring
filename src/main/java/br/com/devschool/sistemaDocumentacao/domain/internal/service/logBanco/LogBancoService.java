package br.com.devschool.sistemaDocumentacao.domain.internal.service.logBanco;

public interface LogBancoService {

	public void salvarLog(String recurso, String metodo, String parametros);
}
