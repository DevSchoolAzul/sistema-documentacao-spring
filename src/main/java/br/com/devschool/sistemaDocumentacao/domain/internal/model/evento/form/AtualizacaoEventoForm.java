package br.com.devschool.sistemaDocumentacao.domain.internal.model.evento.form;


import br.com.devschool.sistemaDocumentacao.domain.internal.model.evento.Evento;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AtualizacaoEventoForm {

    private Boolean situacao;
    private Integer ordem;
    private String parametros;

    public Evento updateEntity(Evento event) {
        event.setSituacao(this.situacao);
        event.setOrdem(this.ordem);
        event.setParametros(this.parametros);
        return event;
    }
}
