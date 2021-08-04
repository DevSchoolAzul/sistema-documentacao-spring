package br.com.devschool.sistemaDocumentacao.domain.internal.model.propriedade;

import br.com.devschool.sistemaDocumentacao.domain.internal.model.requisicao.Requisicao;

import javax.persistence.*;


@Entity
@Table(name = "propriedades")
public class PropriedadeRequisicao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Requisicao requisicao;
    private String chave;
    private String valor;
    private Integer ordem;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Requisicao getRequisicao() {
        return requisicao;
    }

    public void setRequisicao(Requisicao requisicao) {
        this.requisicao = requisicao;
    }

    public String getChave() {
        return chave;
    }

    public void setChave(String chave) {
        this.chave = chave;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public Integer getOrdem() {
        return ordem;
    }

    public void setOrdem(Integer ordem) {
        this.ordem = ordem;
    }
}
