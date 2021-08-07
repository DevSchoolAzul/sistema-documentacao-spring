package br.com.devschool.sistemaDocumentacao.domain.internal.model.requisicao.form;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

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

	public Requisicao toRequisicao(EventoService eventoService, RequisicaoService requisicaoService) throws NoContentException {
		return Requisicao.builder()
				.evento(eventoService.buscar(evento))
				.urlHomolog(urlHomolog)
				.uriProd(uriProd)
				.descricao(descricao)
				.requisicaoPai((requisicaoPai != null) ? requisicaoService.buscar(requisicaoPai) : null)
				.camada(camada)
				.situacao(situacao)
				.ordem(ordem)
				.build();
	}

}
