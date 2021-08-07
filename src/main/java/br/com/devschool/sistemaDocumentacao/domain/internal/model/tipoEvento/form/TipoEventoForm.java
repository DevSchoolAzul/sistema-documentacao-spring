package br.com.devschool.sistemaDocumentacao.domain.internal.model.tipoEvento.form;

import br.com.devschool.sistemaDocumentacao.domain.internal.model.tipoEvento.TipoEvento;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TipoEventoForm {

    private String nome;
    private Boolean situacao;

    public TipoEvento convertFormToEntity() {
        return TipoEvento.builder()
                .nome(this.nome)
                .situacao(this.situacao)
                .build();
    }
}
