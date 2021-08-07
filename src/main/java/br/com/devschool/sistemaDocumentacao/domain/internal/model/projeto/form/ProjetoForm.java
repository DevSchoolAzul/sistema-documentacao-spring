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
public class ProjetoForm {
    @NotNull @NotEmpty
    private String nome;
    @NotNull @NotEmpty
    private Boolean situacao;

    public Projeto convertFormToEntity() {
        return new Projeto(this.nome, this.situacao);
    }
}
