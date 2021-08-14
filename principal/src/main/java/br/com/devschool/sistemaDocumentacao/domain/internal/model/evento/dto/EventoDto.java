package br.com.devschool.sistemaDocumentacao.domain.internal.model.evento.dto;

import br.com.devschool.sistemaDocumentacao.domain.internal.model.evento.Evento;
import br.com.devschool.sistemaDocumentacao.domain.internal.model.tela.Tela;
import br.com.devschool.sistemaDocumentacao.domain.internal.model.tipoEvento.TipoEvento;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.ManyToOne;
import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EventoDto {
    private Long id;
    private Boolean situacao;
    private Integer ordem;
    private String parametros;
    private Long telaId;
    private Long eventTypeId;

    public EventoDto(Evento event) {
        this.id = event.getId();
        this.situacao = event.getSituacao();
        this.ordem = event.getOrdem();
        this.parametros = event.getParametros();
        this.telaId = event.getTela().getId();
        this.eventTypeId = event.getTipoEvento().getId();
    }

    public static List<EventoDto> convertList(List<Evento> events) {
        return events.stream().map(EventoDto::new).collect(Collectors.toList());
    }
}
