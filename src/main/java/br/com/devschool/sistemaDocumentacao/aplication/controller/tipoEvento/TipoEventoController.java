package br.com.devschool.sistemaDocumentacao.aplication.controller.tipoEvento;

import br.com.devschool.sistemaDocumentacao.domain.internal.model.tipoEvento.TipoEvento;
import br.com.devschool.sistemaDocumentacao.domain.internal.service.tipoEvento.TipoEventoService;
import br.com.devschool.sistemaDocumentacao.infraestructure.exception.NoContentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tiposEvento")
public class TipoEventoController {

    private TipoEventoService eventoService;

    @Autowired
    public TipoEventoController(TipoEventoService eventoService) {
        this.eventoService = eventoService;
    }

    @GetMapping
    public ResponseEntity<List<TipoEventoDto>> getAllEventTypes() throws NoContentException {
        List<TipoEventoDto> eventTypesDto = TipoEventoDto.convertList(eventoService.getAllEventTypes());
        return ResponseEntity.ok(eventTypesDto);
    }

    @GetMapping("{id}")

    @PostMapping

    @PutMapping("{id}")

    @DeleteMapping("{id}")

}
