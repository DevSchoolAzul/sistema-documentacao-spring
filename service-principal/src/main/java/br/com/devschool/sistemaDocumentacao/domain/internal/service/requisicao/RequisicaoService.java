package br.com.devschool.sistemaDocumentacao.domain.internal.service.requisicao;

import java.util.List;

import br.com.devschool.sistemaDocumentacao.domain.internal.model.requisicao.Requisicao;
import br.com.devschool.sistemaDocumentacao.domain.internal.model.requisicao.form.RequisicaoAlterarForm;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;

public interface RequisicaoService {
	@Cacheable(value = "listRequisition")
	List<Requisicao> listar();

	@CacheEvict(value = "listRequisition", allEntries = true)
	Requisicao cadastrar(Requisicao requisicao);

	@CacheEvict(value = "listRequisition", allEntries = true)
	Requisicao buscar(Long id);

	@CacheEvict(value = "listRequisition", allEntries = true)
	Requisicao alterar(Long id, RequisicaoAlterarForm requisicaoForm);

	@CacheEvict(value = "listRequisition", allEntries = true)
	void excluir(Long id);
	
	List<Requisicao> listarPorEvento(Long idEvento);
}