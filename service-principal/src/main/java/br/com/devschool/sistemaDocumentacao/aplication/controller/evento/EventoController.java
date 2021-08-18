package br.com.devschool.sistemaDocumentacao.aplication.controller.evento;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.devschool.sistemaDocumentacao.domain.internal.model.evento.Evento;
import br.com.devschool.sistemaDocumentacao.domain.internal.model.evento.dto.EventoDto;
import br.com.devschool.sistemaDocumentacao.domain.internal.model.evento.form.AtualizacaoEventoForm;
import br.com.devschool.sistemaDocumentacao.domain.internal.model.evento.form.EventoForm;
import br.com.devschool.sistemaDocumentacao.domain.internal.service.evento.EventoService;

@RestController
@RequestMapping("/eventos")
public class EventoController {

    private EventoService eventoService;

    @Autowired
    public EventoController(EventoService eventoService) {
        this.eventoService = eventoService;
    }

    @GetMapping
    public ResponseEntity<List<EventoDto>> getAllEvents(@RequestParam(required = false) Long idTela) {
        List<Evento> events;
        if (idTela == null) {
        	events = eventoService.getAllEvents();
        } else {
        	events = eventoService.getEventByTela(idTela);
        }
        return ResponseEntity.ok(EventoDto.convertList(events));
    }

    @GetMapping("/{id}")
    public ResponseEntity<EventoDto> getEventById(@PathVariable Long id) {
        EventoDto eventoDto = new EventoDto(eventoService.getEventById(id));
        return ResponseEntity.ok(eventoDto);
    }

    @PostMapping
    public ResponseEntity<EventoDto> createEvent(@Valid @RequestBody EventoForm form) {
        EventoDto eventDto = new EventoDto(eventoService.createEvent(form));
        return ResponseEntity.ok(eventDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EventoDto> updateEvent(@PathVariable Long id, @Valid @RequestBody AtualizacaoEventoForm form) {
        EventoDto eventoDto = new EventoDto(eventoService.updateEvent(id, form));
        return ResponseEntity.ok(eventoDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteEvent(@PathVariable Long id) {
        eventoService.deleteEvent(id);
        return ResponseEntity.ok().build();
    }
}
