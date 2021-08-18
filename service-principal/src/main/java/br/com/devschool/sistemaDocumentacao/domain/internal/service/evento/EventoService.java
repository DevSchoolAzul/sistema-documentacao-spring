package br.com.devschool.sistemaDocumentacao.domain.internal.service.evento;

import java.util.List;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;

import br.com.devschool.sistemaDocumentacao.domain.internal.model.evento.Evento;
import br.com.devschool.sistemaDocumentacao.domain.internal.model.evento.form.AtualizacaoEventoForm;
import br.com.devschool.sistemaDocumentacao.domain.internal.model.evento.form.EventoForm;

public interface EventoService {
    @Cacheable(value = "listEvents")
    List<Evento> getAllEvents();

    @CacheEvict(value = "listEvents", allEntries = true)
    Evento getEventById(Long id);

    @CacheEvict(value = "listEvents", allEntries = true)
    Evento createEvent(EventoForm form);

    @CacheEvict(value = "listEvents", allEntries = true)
    Evento updateEvent(Long id, AtualizacaoEventoForm form);

    @CacheEvict(value = "listEvents", allEntries = true)
    void deleteEvent(Long id);

	List<Evento> getEventByTela(Long idTela);
}
