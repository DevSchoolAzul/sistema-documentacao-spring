package br.com.devschool.sistemaDocumentacao.domain.internal.model.requisicao.form;

import br.com.devschool.sistemaDocumentacao.domain.internal.model.requisicao.Requisicao;
import br.com.devschool.sistemaDocumentacao.domain.internal.service.evento.EventoService;
import br.com.devschool.sistemaDocumentacao.domain.internal.service.requisicao.impl.RequisicaoServiceImpl;

public class RequisicaoAlterarForm {

	private Long evento;
	private String urlHomolog;
	private String uriProd;
	private String descricao;
	private Long requisicaoPai;
	private String camada;
	private Boolean situacao;
	private Integer ordem;

	public void atualizar(Requisicao requisicao, EventoService eventoService, RequisicaoServiceImpl requisicaoService) {
		if (evento != null)
			requisicao.setEvento(eventoService.buscar(evento));
		if (!urlHomolog.isBlank())
			requisicao.setUrlHomolog(urlHomolog);
		if (!uriProd.isBlank())
			requisicao.setUriProd(uriProd);
		if (!descricao.isBlank())
			requisicao.setDescricao(descricao);
		if (requisicaoPai != null)
			requisicao.setRequisicaoPai(requisicaoService.buscar(requisicaoPai));
		if (!camada.isBlank())
			requisicao.setCamada(camada);
		if (situacao != null)
			requisicao.setSituacao(situacao);
		if (ordem != null)
			requisicao.setOrdem(ordem);
	}

	public Long getEvento() {
		return evento;
	}

	public void setEvento(Long evento) {
		this.evento = evento;
	}

	public String getUrlHomolog() {
		return urlHomolog;
	}

	public void setUrlHomolog(String urlHomolog) {
		this.urlHomolog = urlHomolog;
	}

	public String getUriProd() {
		return uriProd;
	}

	public void setUriProd(String uriProd) {
		this.uriProd = uriProd;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Long getRequisicaoPai() {
		return requisicaoPai;
	}

	public void setRequisicaoPai(Long requisicaoPai) {
		this.requisicaoPai = requisicaoPai;
	}

	public String getCamada() {
		return camada;
	}

	public void setCamada(String camada) {
		this.camada = camada;
	}

	public Boolean getSituacao() {
		return situacao;
	}

	public void setSituacao(Boolean situacao) {
		this.situacao = situacao;
	}

	public Integer getOrdem() {
		return ordem;
	}

	public void setOrdem(Integer ordem) {
		this.ordem = ordem;
	}

}
