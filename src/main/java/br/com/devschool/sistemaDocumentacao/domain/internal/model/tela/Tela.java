package br.com.devschool.sistemaDocumentacao.domain.internal.model.tela;

import br.com.devschool.sistemaDocumentacao.domain.internal.model.evento.Evento;
import br.com.devschool.sistemaDocumentacao.domain.internal.model.versao.Versao;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "telas")
public class Tela {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Versao versao;
    private LocalDate dataCadastro;
    private String nomeTela;
    private String imagem;
    private Boolean situacao;
    @ManyToOne
    private Tela telaPai;
    private Integer ordem;
    private String urlLog;
    @ManyToOne
    private Versao versaoOrigem;
    @OneToMany(mappedBy = "tela")
    private List<Evento> eventos;
    @OneToMany(mappedBy = "telaPai")
    private List<Tela> telasFilhas;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Versao getVersao() {
        return versao;
    }

    public void setVersao(Versao versao) {
        this.versao = versao;
    }

    public LocalDate getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(LocalDate dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public String getNomeTela() {
        return nomeTela;
    }

    public void setNomeTela(String nomeTela) {
        this.nomeTela = nomeTela;
    }

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }

    public boolean isSituacao() {
        return situacao;
    }

    public void setSituacao(boolean situacao) {
        this.situacao = situacao;
    }

    public Tela getTelaPai() {
        return telaPai;
    }

    public void setTelaPai(Tela telaPai) {
        this.telaPai = telaPai;
    }

    public int getOrdem() {
        return ordem;
    }

    public void setOrdem(int ordem) {
        this.ordem = ordem;
    }

    public String getUrlLog() {
        return urlLog;
    }

    public void setUrlLog(String urlLog) {
        this.urlLog = urlLog;
    }

    public Versao getVersaoOrigem() {
        return versaoOrigem;
    }

    public void setVersaoOrigem(Versao versaoOrigem) {
        this.versaoOrigem = versaoOrigem;
    }

    public List<Evento> getEventos() {
        return eventos;
    }

    public void setEventos(List<Evento> eventos) {
        this.eventos = eventos;
    }

    public List<Tela> getTelasFilhas() {
        return telasFilhas;
    }

    public void setTelasFilhas(List<Tela> telasFilhas) {
        this.telasFilhas = telasFilhas;
    }
}
