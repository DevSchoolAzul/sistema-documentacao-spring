package br.com.devschool.sistemaDocumentacao.domain.internal.model.tela;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import br.com.devschool.sistemaDocumentacao.domain.internal.model.evento.Evento;
import br.com.devschool.sistemaDocumentacao.domain.internal.model.versao.Versao;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "telas")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Tela {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    private Versao versao;
    private LocalDate dataCadastro;
    private String nomeTela;
    private String imagem;
    private Boolean situacao;
    @ManyToOne(fetch = FetchType.LAZY)
    private Tela telaPai;
    private Integer ordem;
    private String urlLog;
    @ManyToOne(fetch = FetchType.LAZY)
    private Versao versaoOrigem;
    @OneToMany(mappedBy = "tela", fetch = FetchType.LAZY)
    private List<Evento> eventos;
    @OneToMany(mappedBy = "telaPai", fetch = FetchType.LAZY)
    private List<Tela> telasFilhas;

    public Tela(Tela tela) {
    	this.versao = tela.getVersao();
    	this.dataCadastro = tela.getDataCadastro();
    	this.nomeTela = tela.getNomeTela();
    	this.imagem = tela.getImagem();
    	this.situacao = tela.getSituacao();
    	this.ordem = tela.getOrdem();
    	this.urlLog = tela.getUrlLog();
    }

	public static Tela clonar(Tela tela) {
		return Tela.builder()
			.versao(tela.getVersao())
			.dataCadastro(tela.getDataCadastro())
			.nomeTela(tela.getNomeTela())
			.imagem(tela.getImagem())
			.situacao(tela.getSituacao())
			.ordem(tela.getOrdem())
			.urlLog(tela.getUrlLog())
			.versaoOrigem(tela.getVersao())
			.telaPai(tela.getTelaPai())
			.build();
	}
    
}
