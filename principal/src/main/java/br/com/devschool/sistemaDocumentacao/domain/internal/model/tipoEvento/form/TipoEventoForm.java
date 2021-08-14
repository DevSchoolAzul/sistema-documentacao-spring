package br.com.devschool.sistemaDocumentacao.domain.internal.model.tipoEvento.form;

import br.com.devschool.sistemaDocumentacao.domain.internal.model.tipoEvento.TipoEvento;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TipoEventoForm {
    @NotNull
    private String nome;
    @NotNull
    private Boolean situacao;

    public TipoEvento convertFormToEntity() {
        return TipoEvento.builder()
                .nome(this.nome)
                .situacao(this.situacao)
                .build();
    }
}
