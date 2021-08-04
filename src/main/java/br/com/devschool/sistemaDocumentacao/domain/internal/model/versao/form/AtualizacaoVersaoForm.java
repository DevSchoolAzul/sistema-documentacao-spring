package br.com.devschool.sistemaDocumentacao.domain.internal.model.versao.form;

import br.com.devschool.sistemaDocumentacao.domain.internal.model.projeto.Projeto;
import br.com.devschool.sistemaDocumentacao.domain.internal.model.versao.Versao;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AtualizacaoVersaoForm {

    private String gmud;
    private String descricao;
    private Boolean situacao;
    private Integer ordem;
    private String numeroVersao;

    public Versao convertFormToEntity(Versao versao) {
        versao.setGmud(this.gmud);
        versao.setDescricao(this.descricao);
        versao.setSituacao(this.situacao);
        versao.setOrdem(this.ordem);
        versao.setNumeroVersao(this.numeroVersao);
        return versao;
    }
}
