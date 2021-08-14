package br.com.devschool.sistemaDocumentacao.domain.internal.model.versao;

import br.com.devschool.sistemaDocumentacao.domain.internal.model.projeto.Projeto;
import br.com.devschool.sistemaDocumentacao.domain.internal.model.tela.Tela;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "versoes")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Versao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String gmud;
    private String descricao;
    private LocalDate dataLancamento;
    private Boolean situacao;
    private Integer ordem;
    private String numeroVersao;

    @ManyToOne
    private Projeto projeto;

    @OneToMany(mappedBy = "versao")
    private List<Tela> telas;

    public Versao(String gmud, String descricao, Boolean situacao, Integer ordem, String numeroVersao, Projeto project) {
        this.gmud = gmud;
        this.descricao = descricao;
        this.dataLancamento = LocalDate.now();
        this.situacao = situacao;
        this.ordem = ordem;
        this.numeroVersao = numeroVersao;
        this.projeto = project;
    }
}
