package br.com.devschool.sistemaDocumentacao.domain.internal.service.requisicao.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.devschool.sistemaDocumentacao.domain.internal.model.requisicao.Requisicao;
import br.com.devschool.sistemaDocumentacao.domain.internal.model.requisicao.form.RequisicaoAlterarForm;
import br.com.devschool.sistemaDocumentacao.domain.internal.service.evento.EventoService;
import br.com.devschool.sistemaDocumentacao.domain.internal.service.requisicao.RequisicaoService;
import br.com.devschool.sistemaDocumentacao.infraestructure.exception.DeleteEntityWithDependentsException;
import br.com.devschool.sistemaDocumentacao.infraestructure.exception.NoContentException;
import br.com.devschool.sistemaDocumentacao.infraestructure.repository.requisicao.RequisicaoRepository;

@Service
public class RequisicaoServiceImpl implements RequisicaoService {

	@Autowired
	private RequisicaoRepository requisicaoRepository;
	@Autowired
	private EventoService eventoService;
	
	public List<Requisicao> listar() {
		List<Requisicao> requisicoes = requisicaoRepository.findAll();
		if (requisicoes.isEmpty()) {
			throw new NoContentException("Não há requisições cadastradas");
		}
		return requisicoes;
	}
	
	public List<Requisicao> listarPorEvento(Long idEvento) {
		List<Requisicao> requisicoes = requisicaoRepository.findAllByEventoId(idEvento);
		if (requisicoes.isEmpty()) {
			throw new NoContentException("Nenhuma requisicao encontrada para esse evento");
		}
		return requisicoes;
	}
	
	public Requisicao cadastrar(Requisicao requisicao) {
		return requisicaoRepository.save(requisicao);
	}
	
	public Requisicao buscar(Long id) {
		Optional<Requisicao> requisicao = requisicaoRepository.findById(id);
		if (requisicao.isPresent()) {
			return requisicao.get();
		}
		throw new NoContentException("Nenhuma Requisição cadastrada com este Id");
	}
	
	public Requisicao alterar(Long id, RequisicaoAlterarForm requisicaoForm) {
		Requisicao requisicao = this.buscar(id);
		requisicaoForm.atualizar(requisicao, eventoService, this);
		requisicaoRepository.save(requisicao);
		return requisicao;
	}
	
	public void excluir(Long id) {
		Requisicao requisicao = this.buscar(id);
		if (requisicao.getPropriedades().size() > 0) {
			throw new DeleteEntityWithDependentsException("Esta requisição não pode ser excluida pois possui propriedades associadas a ela.");
		}
		requisicaoRepository.delete(requisicao);
	}
}