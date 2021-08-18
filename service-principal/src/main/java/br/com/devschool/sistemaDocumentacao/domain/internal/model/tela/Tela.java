package br.com.devschool.sistemaDocumentacao.domain.internal.model.tela;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.*;

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
    @Lob
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


}
