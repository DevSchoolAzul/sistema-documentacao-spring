package br.com.devschool.sistemaDocumentacao.domain.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Requisicao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Evento evento;
    private String url_homolog;
    private String uri_prod;
    private String descricao;
    @ManyToOne
    private Requisicao requisicaoPai;
    private String camada;
    private boolean situacao;
    private Integer ordem;
    @OneToMany(mappedBy = "requisicao")
    private List<PropriedadeRequisicao> propriedades;
    @OneToMany(mappedBy = "requisicaoPai")
    private List<Requisicao> requisicao;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }

    public String getUrl_homolog() {
        return url_homolog;
    }

    public void setUrl_homolog(String url_homolog) {
        this.url_homolog = url_homolog;
    }

    public String getUri_prod() {
        return uri_prod;
    }

    public void setUri_prod(String uri_prod) {
        this.uri_prod = uri_prod;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Requisicao getRequisicaoPai() {
        return requisicaoPai;
    }

    public void setRequisicaoPai(Requisicao requisicaoPai) {
        this.requisicaoPai = requisicaoPai;
    }

    public String getCamada() {
        return camada;
    }

    public void setCamada(String camada) {
        this.camada = camada;
    }

    public boolean isSituacao() {
        return situacao;
    }

    public void setSituacao(boolean situacao) {
        this.situacao = situacao;
    }

    public Integer getOrdem() {
        return ordem;
    }

    public void setOrdem(Integer ordem) {
        this.ordem = ordem;
    }

    public List<PropriedadeRequisicao> getPropriedades() {
        return propriedades;
    }

    public void setPropriedades(List<PropriedadeRequisicao> propriedades) {
        this.propriedades = propriedades;
    }

    public List<Requisicao> getRequisicao() {
        return requisicao;
    }

    public void setRequisicao(List<Requisicao> requisicao) {
        this.requisicao = requisicao;
    }
}
