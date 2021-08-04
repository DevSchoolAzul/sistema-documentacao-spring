package br.com.devschool.sistemaDocumentacao.domain.internal.model.projeto.form;

import br.com.devschool.sistemaDocumentacao.domain.internal.model.projeto.Projeto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProjetoForm {
    private String nome;
    private Boolean situacao;

    public Projeto convertFormToEntity() {
        return new Projeto(this.nome, this.situacao);
    }
}
