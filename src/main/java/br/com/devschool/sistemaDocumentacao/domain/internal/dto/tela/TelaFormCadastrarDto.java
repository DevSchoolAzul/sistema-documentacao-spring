package br.com.devschool.sistemaDocumentacao.domain.internal.dto.tela;

import java.time.LocalDate;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import br.com.devschool.sistemaDocumentacao.domain.internal.model.tela.Tela;
import br.com.devschool.sistemaDocumentacao.domain.internal.service.tela.TelaService;
import br.com.devschool.sistemaDocumentacao.infraestructure.repository.versao.VersaoRepository;

public class TelaFormCadastrarDto {

	@NotNull
	private Long versao;
	@NotBlank
	private String nomeTela;
	@NotNull
	private Integer ordem;
	@NotBlank
	private String dataCadastro;
	@NotBlank
	private String urlLog;
	@NotNull
	private Boolean situacao;
	@NotBlank
	private String imagem;
	private Long telaPai;

	public Tela toTela(TelaService telaService, VersaoRepository versaoRepository) {
		Tela tela = new Tela();
		// Talvez fosse uma boa usar o service de versao para buscar a versao
		tela.setVersao(versaoRepository.findById(versao).get());
		if (telaPai != null)
			tela.setTelaPai(telaService.buscar(telaPai));
		tela.setNomeTela(nomeTela);
		tela.setOrdem(ordem);
		tela.setDataCadastro(LocalDate.parse(dataCadastro));
		tela.setUrlLog(urlLog);
		tela.setSituacao(situacao);
		tela.setImagem(imagem);
		
		return tela;
	}
	
	public Long getVersao() {
		return versao;
	}

	public void setVersao(Long versao) {
		this.versao = versao;
	}

	public String getNomeTela() {
		return nomeTela;
	}

	public void setNomeTela(String nomeTela) {
		this.nomeTela = nomeTela;
	}

	public Long getTelaPai() {
		return telaPai;
	}

	public void setTelaPai(Long telaPai) {
		this.telaPai = telaPai;
	}

	public Integer getOrdem() {
		return ordem;
	}

	public void setOrdem(Integer ordem) {
		this.ordem = ordem;
	}

	public String getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(String dataCadastro) {
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

	public String getImagem() {
		return imagem;
	}

	public void setImagem(String imagem) {
		this.imagem = imagem;
	}

}
