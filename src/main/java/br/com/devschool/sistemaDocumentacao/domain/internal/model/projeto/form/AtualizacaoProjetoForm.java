package br.com.devschool.sistemaDocumentacao.domain.internal.model.projeto.form;

import br.com.devschool.sistemaDocumentacao.domain.internal.model.projeto.Projeto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AtualizacaoProjetoForm {

    private String nome;
    private Boolean situacao;

    public Projeto convertFormToEntity(Projeto project) {
        project.setNome(this.nome);
        project.setSituacao(this.situacao);
        return project;
    }

}
