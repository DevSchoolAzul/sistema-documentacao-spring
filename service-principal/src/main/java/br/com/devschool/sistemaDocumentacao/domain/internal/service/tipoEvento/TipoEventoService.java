package br.com.devschool.sistemaDocumentacao.domain.internal.service.tipoEvento;

import br.com.devschool.sistemaDocumentacao.domain.internal.model.tipoEvento.TipoEvento;
import br.com.devschool.sistemaDocumentacao.domain.internal.model.tipoEvento.form.AtualizacaoTipoEventoForm;
import br.com.devschool.sistemaDocumentacao.domain.internal.model.tipoEvento.form.TipoEventoForm;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;

import java.util.List;

public interface TipoEventoService {

    @Cacheable(value = "listEventTypes")
    List<TipoEvento> getAllEventTypes();

    @CacheEvict(value = "listEventTypes", allEntries = true)
    TipoEvento getEventTypeById(Long id);

    @CacheEvict(value = "listEventTypes", allEntries = true)
    TipoEvento createEventType(TipoEventoForm form);

    @CacheEvict(value = "listEventTypes", allEntries = true)
    TipoEvento updateEventType(Long id, AtualizacaoTipoEventoForm form);

    @CacheEvict(value = "listEventTypes", allEntries = true)
    void deleteEventType(Long id);

	List<TipoEvento> getTypeEventsByNameAndSituation(String nome, Boolean situacao);

}
