package br.com.devschool.sistemaDocumentacao.domain.internal.service.tipoEvento.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.devschool.sistemaDocumentacao.domain.internal.model.tipoEvento.TipoEvento;
import br.com.devschool.sistemaDocumentacao.domain.internal.model.tipoEvento.form.AtualizacaoTipoEventoForm;
import br.com.devschool.sistemaDocumentacao.domain.internal.model.tipoEvento.form.TipoEventoForm;
import br.com.devschool.sistemaDocumentacao.domain.internal.service.tipoEvento.TipoEventoService;
import br.com.devschool.sistemaDocumentacao.infraestructure.exception.DeleteEntityWithDependentsException;
import br.com.devschool.sistemaDocumentacao.infraestructure.exception.NoContentException;
import br.com.devschool.sistemaDocumentacao.infraestructure.repository.tipoEvento.TipoEventoRepository;

@Service
public class TipoEventoServiceImpl implements TipoEventoService {

    private TipoEventoRepository tipoEventoRepository;

    @Autowired
    public TipoEventoServiceImpl(TipoEventoRepository tipoEventoRepository) {
        this.tipoEventoRepository = tipoEventoRepository;
    }


    @Override
    public List<TipoEvento> getAllEventTypes() {
        List<TipoEvento> eventTypes = tipoEventoRepository.findAll();
        if(eventTypes.isEmpty()) {
            throw new NoContentException("Nenhum Tipo de Evento encontrado");
        }
        return eventTypes;
    }

    @Override
    public TipoEvento getEventTypeById(Long id) {
        Optional<TipoEvento> optionalEventType = tipoEventoRepository.findById(id);
        if(optionalEventType.isEmpty()) {
            throw new NoContentException("Nenhum tipo de evento cadastrado com ID " + id);
        }
        return optionalEventType.get();
    }

    @Override
    public TipoEvento createEventType(TipoEventoForm form) {
        TipoEvento eventType = form.convertFormToEntity();
        return tipoEventoRepository.save(eventType);
    }

    @Override
    public TipoEvento updateEventType(Long id, AtualizacaoTipoEventoForm form) {
        Optional<TipoEvento> optionalEventType = tipoEventoRepository.findById(id);
        if(optionalEventType.isEmpty()) {
            throw new NoContentException("Nenhum tipo de evento cadastrado com ID " + id);
        }
        TipoEvento eventType = form.updateEntity(optionalEventType.get());
        return tipoEventoRepository.save(eventType);
    }

    @Override
    public void deleteEventType(Long id) {
        TipoEvento eventType = this.getEventTypeById(id);
        if(!eventType.getEventos().isEmpty()) {
            throw new DeleteEntityWithDependentsException("Esse Tipo de Evento não pode ser excluído pois já possui evento cadastrado.");
        }
        tipoEventoRepository.deleteById(id);
    }


	@Override
	public List<TipoEvento> getTypeEventsByNameAndSituation(String nome, Boolean situacao) {
		List<TipoEvento> eventTypes = tipoEventoRepository.findAllByNomeAndSituacao(nome, situacao);
		if (eventTypes.isEmpty()) {
			throw new NoContentException("Nenhum tipo de evento cadastrado com nome: " + nome + " e Situação: " + situacao);
		}
		return eventTypes;
	}
}
