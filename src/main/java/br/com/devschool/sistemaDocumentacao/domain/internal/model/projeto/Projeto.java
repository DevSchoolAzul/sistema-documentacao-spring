package br.com.devschool.sistemaDocumentacao.domain.internal.model.projeto;

import br.com.devschool.sistemaDocumentacao.domain.internal.model.versao.Versao;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "projetos")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Projeto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private Boolean situacao;

    @OneToMany(mappedBy = "projeto")
    private List<Versao> versoes;

    public Projeto(String nome, Boolean situacao) {
        this.nome = nome;
        this.situacao = situacao;
    }
}
