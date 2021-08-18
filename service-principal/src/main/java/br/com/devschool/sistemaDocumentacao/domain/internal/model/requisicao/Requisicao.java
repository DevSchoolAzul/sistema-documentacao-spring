package br.com.devschool.sistemaDocumentacao.domain.internal.model.requisicao;

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
import br.com.devschool.sistemaDocumentacao.domain.internal.model.propriedade.PropriedadeRequisicao;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "requisicoes")
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Requisicao {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Evento evento;
    private String urlHomolog;
    private String uriProd;
    private String descricao;
    @ManyToOne
    private Requisicao requisicaoPai;
    private String camada;
    private Boolean situacao;
    private Integer ordem;
    @OneToMany(mappedBy = "requisicao", fetch = FetchType.LAZY)
    private List<PropriedadeRequisicao> propriedades;
    @OneToMany(mappedBy = "requisicaoPai", fetch = FetchType.LAZY)
    private List<Requisicao> requisicao;
    
	public static Requisicao clonar(Requisicao requisicaoOriginal) {
		return Requisicao.builder()
				.urlHomolog(requisicaoOriginal.getUrlHomolog())
				.uriProd(requisicaoOriginal.getUriProd())
				.descricao(requisicaoOriginal.getDescricao())
				.camada(requisicaoOriginal.getCamada())
				.situacao(requisicaoOriginal.getSituacao())
				.ordem(requisicaoOriginal.getOrdem())
				.requisicaoPai(requisicaoOriginal.getRequisicaoPai())
				.build();
	}

}
