package br.com.devschool.sistemaDocumentacao.domain.internal.model.projeto.form;

import br.com.devschool.sistemaDocumentacao.domain.internal.model.projeto.Projeto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AtualizacaoProjetoForm {
    @NotNull @NotEmpty
    private String nome;
    @NotNull
    private Boolean situacao;

    public Projeto convertFormToEntity(Projeto project) {
        project.setNome(this.nome);
        project.setSituacao(this.situacao);
        return project;
    }

}
