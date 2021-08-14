package br.com.devschool.sistemaDocumentacao.domain.internal.model.requisicao.dto;

import java.util.List;
import java.util.stream.Collectors;

import br.com.devschool.sistemaDocumentacao.domain.internal.model.requisicao.Requisicao;

public class RequisicaoDto {

	private Long id;
//	private EventoDto evento;
	private String urlHomolog;
	private String uriProd;
	private String descricao;
	private RequisicaoDto requisicaoPai;
	private String camada;
	private Boolean situacao;
	private Integer ordem;
	
	public RequisicaoDto() {}
	public RequisicaoDto(Requisicao requisicao) {
		this.id = requisicao.getId();
//		this.evento = new EventoDto(requisicao.getEvento());
		this.urlHomolog = requisicao.getUrlHomolog();
		this.uriProd = requisicao.getUriProd();
		this.descricao = requisicao.getDescricao();
		if (requisicao.getRequisicaoPai() != null) {
			this.requisicaoPai = new RequisicaoDto(requisicao.getRequisicaoPai());
		}
		this.camada = requisicao.getCamada();
		this.situacao = requisicao.getSituacao();
		this.ordem = requisicao.getOrdem();
	}



	public static List<RequisicaoDto> converter(List<Requisicao> requisicoes) {
		return requisicoes.stream().map(RequisicaoDto::new).collect(Collectors.toList());
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
//	public EventoDto getEvento() {
//		return evento;
//	}
//	public void setEvento(EventoDto evento) {
//		this.evento = evento;
//	}
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
	public RequisicaoDto getRequisicaoPai() {
		return requisicaoPai;
	}
	public void setRequisicaoPai(RequisicaoDto requisicaoPai) {
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
