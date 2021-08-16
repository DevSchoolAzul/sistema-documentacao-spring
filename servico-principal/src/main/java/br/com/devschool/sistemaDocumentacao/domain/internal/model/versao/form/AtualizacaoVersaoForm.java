package br.com.devschool.sistemaDocumentacao.domain.internal.model.versao.form;

import br.com.devschool.sistemaDocumentacao.domain.internal.model.projeto.Projeto;
import br.com.devschool.sistemaDocumentacao.domain.internal.model.versao.Versao;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AtualizacaoVersaoForm {
    @NotNull @NotEmpty
    private String gmud;

    private String descricao;
    @NotNull @NotEmpty
    private Boolean situacao;
    @NotNull @NotEmpty
    private Integer ordem;
    @NotNull @NotEmpty
    private String numeroVersao;

    public Versao updateEntity(Versao versao) {
        versao.setGmud(this.gmud);
        versao.setDescricao(this.descricao);
        versao.setSituacao(this.situacao);
        versao.setOrdem(this.ordem);
        versao.setNumeroVersao(this.numeroVersao);
        return versao;
    }
}
