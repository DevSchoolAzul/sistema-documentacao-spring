package br.com.devschool.sistemaDocumentacao.domain.internal.model.tela.form;

import java.time.LocalDate;

import br.com.devschool.sistemaDocumentacao.domain.internal.model.tela.Tela;
import br.com.devschool.sistemaDocumentacao.domain.internal.service.tela.TelaService;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
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

}
