package br.com.devschool.sistemaDocumentacao.aplication.controller.tipoEvento;

import br.com.devschool.sistemaDocumentacao.domain.internal.model.tipoEvento.TipoEvento;
import br.com.devschool.sistemaDocumentacao.domain.internal.model.tipoEvento.dto.TipoEventoDto;
import br.com.devschool.sistemaDocumentacao.domain.internal.model.tipoEvento.form.AtualizacaoTipoEventoForm;
import br.com.devschool.sistemaDocumentacao.domain.internal.model.tipoEvento.form.TipoEventoForm;
import br.com.devschool.sistemaDocumentacao.domain.internal.service.tipoEvento.TipoEventoService;
import br.com.devschool.sistemaDocumentacao.infraestructure.exception.DeleteEntityWithDependentsException;
import br.com.devschool.sistemaDocumentacao.infraestructure.exception.NoContentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.w3c.dom.events.Event;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/tiposEvento")
public class TipoEventoController {

    private TipoEventoService tipoEventoService;

    @Autowired
    public TipoEventoController(TipoEventoService eventoService) {
        this.tipoEventoService = eventoService;
    }

    @GetMapping
    public ResponseEntity<List<TipoEventoDto>> getAllEventTypes(@RequestParam(required = false, defaultValue = "") String nome, @RequestParam(required = false) Boolean situacao) {
        List<TipoEvento> eventTypes;
        if (!nome.isBlank() || situacao != null) {
        	eventTypes = tipoEventoService.getTypeEventsByNameAndSituation(nome, situacao);
        } else {
        	eventTypes = tipoEventoService.getAllEventTypes();
        }
        return ResponseEntity.ok(TipoEventoDto.convertList(eventTypes));
    }

    @GetMapping("{id}")
    public ResponseEntity<TipoEventoDto> getEventTypeById(@PathVariable Long id) {
        TipoEventoDto eventTypeDto = new TipoEventoDto(tipoEventoService.getEventTypeById(id));
        return ResponseEntity.ok(eventTypeDto);
    }

    @PostMapping
    public ResponseEntity<TipoEventoDto> createEventType(@Valid @RequestBody TipoEventoForm form) {
        TipoEventoDto eventTypeDto = new TipoEventoDto(tipoEventoService.createEventType(form));
        return ResponseEntity.ok(eventTypeDto);
    }

    @PutMapping("{id}")
    public ResponseEntity<TipoEventoDto> updateEventType(@PathVariable Long id, @Valid @RequestBody AtualizacaoTipoEventoForm form) {
        TipoEventoDto eventTypeDto = new TipoEventoDto(tipoEventoService.updateEventType(id,form));
        return ResponseEntity.ok(eventTypeDto);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteEventType(@PathVariable Long id) {
        tipoEventoService.deleteEventType(id);
        return ResponseEntity.ok().build();
    }

}
