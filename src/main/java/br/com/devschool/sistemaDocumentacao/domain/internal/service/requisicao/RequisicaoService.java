package br.com.devschool.sistemaDocumentacao.domain.internal.service.requisicao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.devschool.sistemaDocumentacao.domain.internal.model.requisicao.Requisicao;
import br.com.devschool.sistemaDocumentacao.domain.internal.model.requisicao.dto.RequisicaoAlterarForm;
import br.com.devschool.sistemaDocumentacao.domain.internal.service.evento.EventoService;
import br.com.devschool.sistemaDocumentacao.infraestructure.repository.requisicao.RequisicaoRepository;

@Service
public class RequisicaoService {

	@Autowired
	private RequisicaoRepository requisicaoRepository;
	@Autowired
	private EventoService eventoService;
	
	public Requisicao cadastrar(Requisicao requisicao) {
		return requisicaoRepository.save(requisicao);
	}
	
	public List<Requisicao> listar() {
		return requisicaoRepository.findAll();
	}
	
	public Requisicao buscar(Long id) {
		Optional<Requisicao> requisicao = requisicaoRepository.findById(id);
		if (requisicao.isPresent()) {
			return requisicao.get();
		}
		// TODO exception de buscar requisicao
		throw new RuntimeException("Requisicao não encontrada");
	}
	
	public Requisicao alterar(Long id, RequisicaoAlterarForm requisicaoForm) {
		Requisicao requisicao = this.buscar(id);
		requisicaoForm.atualizar(requisicao, eventoService, this);
		requisicaoRepository.save(requisicao);
		return requisicao;
	}
	
	public void excluir(Long id) {
		Requisicao requisicao = this.buscar(id);
		requisicaoRepository.delete(requisicao);
	}
	
}
