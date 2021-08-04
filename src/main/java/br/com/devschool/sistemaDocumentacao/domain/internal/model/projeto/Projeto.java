package br.com.devschool.sistemaDocumentacao.domain.internal.model.projeto;

import br.com.devschool.sistemaDocumentacao.domain.internal.model.versao.Versao;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "projetos")
public class Projeto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private Boolean situacao;

    @OneToMany(mappedBy = "projeto")
    private List<Versao> versoes;

    public Projeto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Boolean getSituacao() {
        return situacao;
    }

    public void setSituacao(Boolean situacao) {
        this.situacao = situacao;
    }
}
