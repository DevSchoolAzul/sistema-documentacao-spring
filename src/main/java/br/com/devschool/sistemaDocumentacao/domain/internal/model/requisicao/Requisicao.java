package br.com.devschool.sistemaDocumentacao.domain.internal.model.requisicao;

import br.com.devschool.sistemaDocumentacao.domain.internal.model.propriedade.PropriedadeRequisicao;
import br.com.devschool.sistemaDocumentacao.domain.internal.model.evento.Evento;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "requisicoes")
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

    public String getUrlHomolog() {
        return urlHomolog;
    }

    public void setUrlHomolog(String urlHomolog) {
        this.urlHomolog = urlHomolog;
    }

    public String getUriProd() {
        return uriProd;
    }

    public void setUriProd(String uriProd) {
        this.uriProd = uriProd;
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

    public Boolean getSituacao() {
        return situacao;
    }

    public void setSituacao(Boolean situacao) {
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