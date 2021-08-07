package br.com.devschool.sistemaDocumentacao.domain.internal.service.tipoEvento;

import br.com.devschool.sistemaDocumentacao.domain.internal.model.tipoEvento.TipoEvento;
import br.com.devschool.sistemaDocumentacao.infraestructure.exception.DeleteEntityWithDependentsException;
import br.com.devschool.sistemaDocumentacao.infraestructure.exception.NoContentException;

import java.util.List;

public interface TipoEventoService {

    List<TipoEvento> getAllEventTypes() throws NoContentException;

    TipoEvento getEventTypeById(Long id) throws NoContentException;

    TipoEvento createEventType(TipoEventoForm form);

    TipoEvento updateEventType(Long id, AtualizacaoTipoEventoForm form) throws NoContentException;

    void deleteEventType(Long id) throws DeleteEntityWithDependentsException, NoContentException;

}
