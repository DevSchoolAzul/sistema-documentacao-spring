package br.com.devschool.sistemaDocumentacao.domain.internal.model.tipoEvento.form;

import br.com.devschool.sistemaDocumentacao.domain.internal.model.tipoEvento.TipoEvento;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AtualizacaoTipoEventoForm {

    private String nome;
    private Boolean situacao;

    public TipoEvento updateEntity(TipoEvento eventType) {
        eventType.setNome(this.nome);
        eventType.setSituacao(this.situacao);
        return eventType;
    }
}
