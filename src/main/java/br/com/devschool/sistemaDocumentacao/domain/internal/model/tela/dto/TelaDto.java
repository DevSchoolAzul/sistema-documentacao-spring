package br.com.devschool.sistemaDocumentacao.domain.internal.model.tela.dto;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import br.com.devschool.sistemaDocumentacao.domain.internal.model.tela.Tela;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TelaDto {

	private Long id;
	private String nomeTela;
	private String imagemTela;
	private TelaDto telaPai;
	private Integer ordem;
	private LocalDate dataCadastro;
	private String urlLog;
	private Boolean situacao;
	
	public TelaDto(Tela tela) {
		this.id = tela.getId();
		this.nomeTela = tela.getNomeTela();
		this.imagemTela = tela.getImagem();
		if (tela.getTelaPai() != null) this.setTelaPai(new TelaDto(tela.getTelaPai()));
		this.ordem = tela.getOrdem();
		this.dataCadastro = tela.getDataCadastro();
		this.urlLog = tela.getUrlLog();
		this.situacao = tela.getSituacao();
	}

	public static List<TelaDto> converter(List<Tela> telas) {
		return telas.stream().map(TelaDto::new).collect(Collectors.toList());
	}
	
	public static TelaDto converter(Tela tela) {
		if (tela == null) return null;
		return TelaDto.builder()
				.id(tela.getId())
				.nomeTela(tela.getNomeTela())
				.imagemTela(tela.getImagem())
				.telaPai(TelaDto.converter(tela.getTelaPai()))
				.ordem(tela.getOrdem())
				.dataCadastro(tela.getDataCadastro())
				.urlLog(tela.getUrlLog())
				.situacao(tela.getSituacao())
				.build();
	}

}
