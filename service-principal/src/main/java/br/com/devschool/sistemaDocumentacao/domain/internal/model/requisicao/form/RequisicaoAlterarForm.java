package br.com.devschool.sistemaDocumentacao.domain.internal.model.requisicao.form;

import br.com.devschool.sistemaDocumentacao.domain.internal.model.requisicao.Requisicao;
import br.com.devschool.sistemaDocumentacao.domain.internal.service.evento.EventoService;
import br.com.devschool.sistemaDocumentacao.domain.internal.service.requisicao.RequisicaoService;
import br.com.devschool.sistemaDocumentacao.infraestructure.exception.NoContentException;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class RequisicaoAlterarForm {

	private Long evento;
	private String urlHomolog;
	private String uriProd;
	private String descricao;
	private Long requisicaoPai;
	private String camada;
	private Boolean situacao;
	private Integer ordem;

	public void atualizar(Requisicao requisicao, EventoService eventoService, RequisicaoService requisicaoService) throws NoContentException {
		if (evento != null)
			requisicao.setEvento(eventoService.getEventById(evento));
		if (urlHomolog != null && !urlHomolog.isBlank())
			requisicao.setUrlHomolog(urlHomolog);
		if (uriProd != null && !uriProd.isBlank())
			requisicao.setUriProd(uriProd);
		if (descricao != null && !descricao.isBlank())
			requisicao.setDescricao(descricao);
		if (requisicaoPai != null)
			requisicao.setRequisicaoPai(requisicaoService.buscar(requisicaoPai));
		if (camada != null && !camada.isBlank())
			requisicao.setCamada(camada);
		if (situacao != null)
			requisicao.setSituacao(situacao);
		if (ordem != null)
			requisicao.setOrdem(ordem);
	}

}
