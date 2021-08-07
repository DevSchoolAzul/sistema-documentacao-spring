package br.com.devschool.sistemaDocumentacao.domain.internal.model.requisicao.form;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import br.com.devschool.sistemaDocumentacao.domain.internal.model.requisicao.Requisicao;
import br.com.devschool.sistemaDocumentacao.domain.internal.service.evento.EventoService;
import br.com.devschool.sistemaDocumentacao.domain.internal.service.requisicao.impl.RequisicaoServiceImpl;

public class RequisicaoCadastrarForm {

	@NotNull
	private Long evento;
	@NotBlank
	private String urlHomolog;
	@NotBlank
	private String uriProd;
	@NotBlank
	private String descricao;

	private Long requisicaoPai;
	@NotBlank
	private String camada;
	@NotNull
	private Boolean situacao;
	@NotNull
	private Integer ordem;

	public Requisicao toRequisicao(EventoService eventoService, RequisicaoServiceImpl requisicaoService) {
		Requisicao requisicao = new Requisicao();
		requisicao.setEvento(eventoService.buscar(evento));
		requisicao.setUrlHomolog(urlHomolog);
		requisicao.setUriProd(uriProd);
		requisicao.setDescricao(descricao);
		if (requisicaoPai != null) requisicao.setRequisicaoPai(requisicaoService.buscar(requisicaoPai));			
		requisicao.setCamada(camada);
		requisicao.setSituacao(situacao);
		requisicao.setOrdem(ordem);
		return requisicao;
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
