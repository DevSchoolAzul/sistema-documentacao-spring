package br.com.devschool.sistemaDocumentacao.domain.internal.dto.tela;

import java.time.LocalDate;

import br.com.devschool.sistemaDocumentacao.domain.internal.model.tela.Tela;
import br.com.devschool.sistemaDocumentacao.domain.internal.service.tela.TelaService;

public class TelaFormAtualizarDto {
	
	private String nomeTela;
	private String imagem;
    private Boolean situacao;
    private Long telaPai;
    private Integer ordem;
    private String urlLog;
    private LocalDate dataCadastro;
    
    public void atualizar(Tela tela, TelaService service) {
    	if (telaPai != null && !telaPai.equals(tela.getId())) {
    		if (telaPai.equals(0l)) {
    			tela.setTelaPai(null);
    		} else {
    			tela.setTelaPai(service.buscar(telaPai));    			
    		}
    	}
    	if (!nomeTela.isBlank()) tela.setNomeTela(nomeTela);
    	if (!imagem.isBlank()) tela.setImagem(imagem);
    	if (situacao != null) tela.setSituacao(situacao);
    	if (ordem != null) tela.setOrdem(ordem);
    	if (!urlLog.isBlank()) tela.setUrlLog(urlLog);
    	if (dataCadastro != null) tela.setDataCadastro(dataCadastro);
    }

	public String getNomeTela() {
		return nomeTela;
	}

	public void setNomeTela(String nomeTela) {
		this.nomeTela = nomeTela;
	}

	public String getImagem() {
		return imagem;
	}

	public void setImagem(String imagem) {
		this.imagem = imagem;
	}

	public Boolean getSituacao() {
		return situacao;
	}

	public void setSituacao(Boolean situacao) {
		this.situacao = situacao;
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

	public String getUrlLog() {
		return urlLog;
	}

	public void setUrlLog(String urlLog) {
		this.urlLog = urlLog;
	}

	public LocalDate getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(LocalDate dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

}
