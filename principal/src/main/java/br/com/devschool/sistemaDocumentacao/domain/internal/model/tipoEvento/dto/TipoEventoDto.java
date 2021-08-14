package br.com.devschool.sistemaDocumentacao.domain.internal.model.tipoEvento.dto;

import br.com.devschool.sistemaDocumentacao.domain.internal.model.tipoEvento.TipoEvento;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TipoEventoDto {

    private Long id;
    private String nome;
    private Boolean situacao;

    public TipoEventoDto(TipoEvento eventType) {
        this.id = eventType.getId();
        this.nome = eventType.getNome();
        this.situacao = eventType.getSituacao();
    }

    public static List<TipoEventoDto> convertList(List<TipoEvento> eventTypes) {
        return eventTypes.stream().map(TipoEventoDto::new).collect(Collectors.toList());
    }
}
