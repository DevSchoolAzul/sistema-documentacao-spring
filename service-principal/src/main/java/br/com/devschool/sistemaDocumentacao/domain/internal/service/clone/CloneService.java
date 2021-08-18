package br.com.devschool.sistemaDocumentacao.domain.internal.service.clone;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.devschool.sistemaDocumentacao.domain.internal.model.evento.Evento;
import br.com.devschool.sistemaDocumentacao.domain.internal.model.propriedade.PropriedadeRequisicao;
import br.com.devschool.sistemaDocumentacao.domain.internal.model.requisicao.Requisicao;
import br.com.devschool.sistemaDocumentacao.domain.internal.model.tela.Tela;
import br.com.devschool.sistemaDocumentacao.domain.internal.model.versao.Versao;
import br.com.devschool.sistemaDocumentacao.infraestructure.repository.evento.EventoRepository;
import br.com.devschool.sistemaDocumentacao.infraestructure.repository.propriedade.PropriedadeRequisicaoRepository;
import br.com.devschool.sistemaDocumentacao.infraestructure.repository.requisicao.RequisicaoRepository;
import br.com.devschool.sistemaDocumentacao.infraestructure.repository.tela.TelaRepository;

@Service
public class CloneService {

	@Autowired
	private TelaRepository telaRepository;
	@Autowired
	private EventoRepository eventoRepository;
	@Autowired
	private RequisicaoRepository requisicaoRepository;
	@Autowired
	private PropriedadeRequisicaoRepository propriedadeRequisicaoRepository;
	
	public void clonar(Versao versaoOriginal, Versao versaoClone) {
		List<Tela> telas = telaRepository.findAllByVersaoIdAndTelaPaiIsNull(versaoOriginal.getId());
		telas.forEach(tela -> clonarTela(tela, versaoClone, null));
	}

	private void clonarTela(Tela tela, Versao versaoClone, Tela telaPai) {
		Tela novaTela = Tela.clonar(tela);
		novaTela.setVersao(versaoClone);
		novaTela.setTelaPai(telaPai);
		telaRepository.save(novaTela);
		
		List<Evento> eventos = eventoRepository.findAllByTelaId(tela.getId());
		eventos.forEach(evento -> clonarEvento(evento, novaTela));
		List<Tela> telasFilhas = tela.getTelasFilhas();
		telasFilhas.forEach(telaFilha -> clonarTela(telaFilha, versaoClone, novaTela));
	}

	private void clonarEvento(Evento evento, Tela novaTela) {
		Evento novoEvento = Evento.clonar(evento);
		novoEvento.setTela(novaTela);
		eventoRepository.save(novoEvento);
		
		List<Requisicao> requisicoes = requisicaoRepository.findAllByEventoIdAndRequisicaoPaiIsNull(evento.getId());
		requisicoes.forEach(requisicao -> clonarRequisicao(requisicao, novoEvento, null));
	}

	private void clonarRequisicao(Requisicao requisicao, Evento evento, Requisicao requisicaoPai) {
		Requisicao novaRequisicao = Requisicao.clonar(requisicao);
		novaRequisicao.setEvento(evento);
		novaRequisicao.setRequisicaoPai(requisicaoPai);
		requisicaoRepository.save(novaRequisicao);
		
		List<Requisicao> requisicoesFilhas = requisicao.getRequisicao();
		requisicoesFilhas.forEach(requisicaoFilha -> clonarRequisicao(requisicaoFilha, evento, requisicao));
		List<PropriedadeRequisicao> propriedades = requisicao.getPropriedades();
		propriedades.forEach(propriedade -> clonarPropriedade(propriedade, novaRequisicao));
	}

	private void clonarPropriedade(PropriedadeRequisicao propriedade, Requisicao requisicao) {
		PropriedadeRequisicao novaPropriedade = PropriedadeRequisicao.clonar(propriedade);
		novaPropriedade.setRequisicao(requisicao);
		propriedadeRequisicaoRepository.save(novaPropriedade);
	}
	
}
