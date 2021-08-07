package br.com.devschool.sistemaDocumentacao.domain.internal.model.evento.form;

import br.com.devschool.sistemaDocumentacao.domain.internal.model.evento.Evento;
import br.com.devschool.sistemaDocumentacao.infraestructure.repository.tela.TelaRepository;
import br.com.devschool.sistemaDocumentacao.infraestructure.repository.tipoEvento.TipoEventoRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EventoForm {
    @NotNull
    private Boolean situacao;
    @NotNull
    private Integer ordem;
    @NotNull
    private String parametros;
    @NotNull
    private Long telaId;
    @NotNull
    private Long eventTypeId;

    public Evento convertFormToEntity(TipoEventoRepository tipoEventoRepository, TelaRepository telaRepository) {
        Evento event = Evento.builder()
                .situacao(this.situacao)
                .ordem(this.ordem)
                .parametros(this.parametros)
                .tela(telaRepository.findById(telaId).get())
                .tipoEvento(tipoEventoRepository.findById(eventTypeId).get())
                .build();
        return event;
    }
}
