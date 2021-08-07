package br.com.devschool.sistemaDocumentacao.domain.internal.service.tipoEvento.impl;

import br.com.devschool.sistemaDocumentacao.domain.internal.model.tipoEvento.TipoEvento;
import br.com.devschool.sistemaDocumentacao.domain.internal.model.tipoEvento.form.AtualizacaoTipoEventoForm;
import br.com.devschool.sistemaDocumentacao.domain.internal.model.tipoEvento.form.TipoEventoForm;
import br.com.devschool.sistemaDocumentacao.domain.internal.service.tipoEvento.TipoEventoService;
import br.com.devschool.sistemaDocumentacao.infraestructure.exception.DeleteEntityWithDependentsException;
import br.com.devschool.sistemaDocumentacao.infraestructure.exception.NoContentException;
import br.com.devschool.sistemaDocumentacao.infraestructure.repository.tipoEvento.TipoEventoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TipoEventoServiceImpl implements TipoEventoService {

    private TipoEventoRepository tipoEventoRepository;

    @Autowired
    public TipoEventoServiceImpl(TipoEventoRepository tipoEventoRepository) {
        this.tipoEventoRepository = tipoEventoRepository;
    }


    @Override
    public List<TipoEvento> getAllEventTypes() throws NoContentException {
        List<TipoEvento> eventTypes = tipoEventoRepository.findAll();
        if(eventTypes.isEmpty()) {
            throw new NoContentException("");
        }
        return eventTypes;
    }

    @Override
    public TipoEvento getEventTypeById(Long id) throws NoContentException {
        Optional<TipoEvento> optionalEventType = tipoEventoRepository.findById(id);
        if(optionalEventType.isEmpty()) {
            throw new NoContentException("");
        }
        return optionalEventType.get();
    }

    @Override
    public TipoEvento createEventType(TipoEventoForm form) {
        TipoEvento eventType = form.convertFormToEntity();
        return tipoEventoRepository.save(eventType);
    }

    @Override
    public TipoEvento updateEventType(Long id, AtualizacaoTipoEventoForm form) throws NoContentException {
        Optional<TipoEvento> optionalEventType = tipoEventoRepository.findById(id);
        if(optionalEventType.isEmpty()) {
            throw new NoContentException("");
        }
        TipoEvento eventType = form.updateEntity(optionalEventType.get());
        return tipoEventoRepository.save(eventType);
    }

    @Override
    public void deleteEventType(Long id) throws DeleteEntityWithDependentsException, NoContentException {
        TipoEvento eventType = this.getEventTypeById(id);
        if(!eventType.getEventos().isEmpty()) {
            throw new DeleteEntityWithDependentsException("Esse Tipo de Evento não pode ser excluído pois já possui evento cadastrado.");
        }
        tipoEventoRepository.deleteById(id);
    }
}
