package br.com.devschool.sistemaDocumentacao.domain.internal.model.evento;



import br.com.devschool.sistemaDocumentacao.domain.internal.model.requisicao.Requisicao;
import br.com.devschool.sistemaDocumentacao.domain.internal.model.tipoEvento.TipoEvento;
import br.com.devschool.sistemaDocumentacao.domain.internal.model.tela.Tela;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "eventos")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Evento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Boolean situacao;
    private Integer ordem;
    private String parametros;
    @ManyToOne
    private Tela tela;
    @ManyToOne
    private TipoEvento tipoEvento;
    @OneToMany(mappedBy = "evento")
    private List<Requisicao> requisicoes;
}
