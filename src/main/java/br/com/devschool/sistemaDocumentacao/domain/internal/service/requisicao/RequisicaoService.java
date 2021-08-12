package br.com.devschool.sistemaDocumentacao.domain.internal.service.requisicao;

import java.util.List;

import br.com.devschool.sistemaDocumentacao.domain.internal.model.requisicao.Requisicao;
import br.com.devschool.sistemaDocumentacao.domain.internal.model.requisicao.form.RequisicaoAlterarForm;

public interface RequisicaoService {

	Requisicao cadastrar(Requisicao requisicao);
	
	List<Requisicao> listar(Long idEvento);
	
	Requisicao buscar(Long id);  
	
	Requisicao alterar(Long id, RequisicaoAlterarForm requisicaoForm);
	
	void excluir(Long id);
}