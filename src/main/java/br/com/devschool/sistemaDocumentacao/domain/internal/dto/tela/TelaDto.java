package br.com.devschool.sistemaDocumentacao.domain.internal.dto.tela;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import br.com.devschool.sistemaDocumentacao.domain.internal.model.tela.Tela;

public class TelaDto {

	private Long id;
	private String nomeTela;
	private String imagemTela;
	private TelaDto telaPai;
	private Integer ordem;
	private LocalDate dataCadastro;
	private String urlLog;
	private Boolean situacao;
	
	
	public TelaDto() {}
	
	public TelaDto(Tela tela) {
		this.id = tela.getId();
		this.nomeTela = tela.getNomeTela();
		this.imagemTela = tela.getImagem();
		if (tela.getTelaPai() != null) this.setTelaPai(tela.getTelaPai());
		this.ordem = tela.getOrdem();
		this.dataCadastro = tela.getDataCadastro();
		this.urlLog = tela.getUrlLog();
		this.situacao = tela.isSituacao();
	}



	public static List<TelaDto> converter(List<Tela> telas) {
		return telas.stream().map(TelaDto::new).collect(Collectors.toList());
	}
	
	public static TelaDto converter(Tela tela) {
		return new TelaDto(tela);
	}

	public String getNomeTela() {
		return nomeTela;
	}

	public void setNomeTela(String nomeTela) {
		this.nomeTela = nomeTela;
	}

	public String getImagemTela() {
		return imagemTela;
	}

	public void setImagemTela(String imagemTela) {
		this.imagemTela = imagemTela;
	}

	public TelaDto getTelaPai() {
		return telaPai;
	}

	public void setTelaPai(Tela telaPai) {
		this.telaPai = new TelaDto(telaPai);
	}

	public Integer getOrdem() {
		return ordem;
	}

	public void setOrdem(Integer ordem) {
		this.ordem = ordem;
	}

	public LocalDate getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(LocalDate dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public String getUrlLog() {
		return urlLog;
	}

	public void setUrlLog(String urlLog) {
		this.urlLog = urlLog;
	}

	public Boolean getSituacao() {
		return situacao;
	}

	public void setSituacao(Boolean situacao) {
		this.situacao = situacao;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setTelaPai(TelaDto telaPai) {
		this.telaPai = telaPai;
	}


}
