package br.com.devschool.sistemaDocumentacao.domain.internal.service.evento;

import br.com.devschool.sistemaDocumentacao.domain.internal.model.evento.Evento;
import br.com.devschool.sistemaDocumentacao.domain.internal.model.evento.form.AtualizacaoEventoForm;
import br.com.devschool.sistemaDocumentacao.domain.internal.model.evento.form.EventoForm;
import br.com.devschool.sistemaDocumentacao.infraestructure.exception.DeleteEntityWithDependentsException;
import br.com.devschool.sistemaDocumentacao.infraestructure.exception.NoContentException;

import java.util.List;

public interface EventoService {
    List<Evento> getAllEvents() throws NoContentException;
    Evento getEventById(Long id) throws NoContentException;
    Evento createEvent(EventoForm form);
    Evento updateEvent(Long id, AtualizacaoEventoForm form) throws NoContentException;
    void deleteEvent(Long id) throws NoContentException, DeleteEntityWithDependentsException;
}
