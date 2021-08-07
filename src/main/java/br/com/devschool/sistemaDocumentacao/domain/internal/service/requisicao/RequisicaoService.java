package br.com.devschool.sistemaDocumentacao.domain.internal.service.requisicao;

import java.util.List;

import br.com.devschool.sistemaDocumentacao.domain.internal.model.requisicao.Requisicao;
import br.com.devschool.sistemaDocumentacao.domain.internal.model.requisicao.form.RequisicaoAlterarForm;
import br.com.devschool.sistemaDocumentacao.infraestructure.exception.DeleteEntityWithDependentsException;
import br.com.devschool.sistemaDocumentacao.infraestructure.exception.NoContentException;

public interface RequisicaoService {

	Requisicao cadastrar(Requisicao requisicao);
	
	List<Requisicao> listar(Long idEvento);
	
	Requisicao buscar(Long id) throws NoContentException;  
	
	Requisicao alterar(Long id, RequisicaoAlterarForm requisicaoForm) throws NoContentException;
	
	void excluir(Long id) throws NoContentException, DeleteEntityWithDependentsException;
}