package br.com.devschool.sistemaDocumentacao.domain.internal.model.requisicao.dto;

import java.util.List;
import java.util.stream.Collectors;

import br.com.devschool.sistemaDocumentacao.domain.internal.model.requisicao.Requisicao;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
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
		
}
