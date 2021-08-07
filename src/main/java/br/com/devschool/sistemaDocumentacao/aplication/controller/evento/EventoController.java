package br.com.devschool.sistemaDocumentacao.aplication.controller.evento;

import br.com.devschool.sistemaDocumentacao.domain.internal.model.evento.Evento;
import br.com.devschool.sistemaDocumentacao.domain.internal.model.evento.dto.EventoDto;
import br.com.devschool.sistemaDocumentacao.domain.internal.model.evento.form.AtualizacaoEventoForm;
import br.com.devschool.sistemaDocumentacao.domain.internal.model.evento.form.EventoForm;
import br.com.devschool.sistemaDocumentacao.domain.internal.service.evento.EventoService;
import br.com.devschool.sistemaDocumentacao.infraestructure.exception.DeleteEntityWithDependentsException;
import br.com.devschool.sistemaDocumentacao.infraestructure.exception.NoContentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/eventos")
public class EventoController {

    private EventoService eventoService;

    @Autowired
    public EventoController(EventoService eventoService) {
        this.eventoService = eventoService;
    }

    @GetMapping
    public ResponseEntity<List<EventoDto>> getAllEvents() throws NoContentException {
        List<EventoDto> eventsDto = EventoDto.convertList(eventoService.getAllEvents());
        return ResponseEntity.ok(eventsDto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EventoDto> getEventById(@PathVariable Long id) throws NoContentException {
        EventoDto eventoDto = new EventoDto(eventoService.getEventById(id));
        return ResponseEntity.ok(eventoDto);
    }

    @PostMapping
    public ResponseEntity<EventoDto> createEvent(@Valid @RequestBody EventoForm form) {
        EventoDto eventDto = new EventoDto(eventoService.createEvent(form));
        return ResponseEntity.ok(eventDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EventoDto> updateEvent(@PathVariable Long id, @Valid @RequestBody AtualizacaoEventoForm form) throws NoContentException {
        EventoDto eventoDto = new EventoDto(eventoService.updateEvent(id, form));
        return ResponseEntity.ok(eventoDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteEvent(@PathVariable Long id) throws DeleteEntityWithDependentsException, NoContentException {
        eventoService.deleteEvent(id);
        return ResponseEntity.ok().build();
    }
}
