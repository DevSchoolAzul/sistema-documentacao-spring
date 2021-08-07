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
	
	public Requisicao cadastrar(Requisicao requisicao) {
		return requisicaoRepository.save(requisicao);
	}
	
	public List<Requisicao> listar(Long idEvento) {
		if (idEvento == null) {
			return requisicaoRepository.findAll();
		}
		return requisicaoRepository.findByEventoId(idEvento);
	}
	
	public Requisicao buscar(Long id) throws NoContentException  {
		Optional<Requisicao> requisicao = requisicaoRepository.findById(id);
		if (requisicao.isPresent()) {
			return requisicao.get();
		}
		throw new NoContentException("Nenhuma Requisição cadastrada com este Id");
	}
	
	public Requisicao alterar(Long id, RequisicaoAlterarForm requisicaoForm) throws NoContentException {
		Requisicao requisicao = this.buscar(id);
		requisicaoForm.atualizar(requisicao, eventoService, this);
		requisicaoRepository.save(requisicao);
		return requisicao;
	}
	
	public void excluir(Long id) throws NoContentException, DeleteEntityWithDependentsException {
		Requisicao requisicao = this.buscar(id);
		if (requisicao.getPropriedades().size() > 0) {
			throw new DeleteEntityWithDependentsException("Esta requisição não pode ser excluida pois possui propriedades associadas a ela.");
		}
		requisicaoRepository.delete(requisicao);
	}
}