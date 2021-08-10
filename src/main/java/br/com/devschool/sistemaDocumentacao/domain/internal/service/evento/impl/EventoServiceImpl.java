package br.com.devschool.sistemaDocumentacao.domain.internal.service.evento.impl;

import br.com.devschool.sistemaDocumentacao.domain.internal.model.evento.Evento;
import br.com.devschool.sistemaDocumentacao.domain.internal.model.evento.form.AtualizacaoEventoForm;
import br.com.devschool.sistemaDocumentacao.domain.internal.model.evento.form.EventoForm;
import br.com.devschool.sistemaDocumentacao.domain.internal.service.evento.EventoService;
import br.com.devschool.sistemaDocumentacao.infraestructure.exception.DeleteEntityWithDependentsException;
import br.com.devschool.sistemaDocumentacao.infraestructure.exception.NoContentException;
import br.com.devschool.sistemaDocumentacao.infraestructure.repository.evento.EventoRepository;
import br.com.devschool.sistemaDocumentacao.infraestructure.repository.tela.TelaRepository;
import br.com.devschool.sistemaDocumentacao.infraestructure.repository.tipoEvento.TipoEventoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EventoServiceImpl implements EventoService {

    private TelaRepository telaRepository;
    private TipoEventoRepository tipoEventoRepository;
    private EventoRepository eventoRepository;

    @Autowired
    public EventoServiceImpl(TelaRepository telaRepository, TipoEventoRepository tipoEventoRepository, EventoRepository eventoRepository) {
        this.telaRepository = telaRepository;
        this.tipoEventoRepository = tipoEventoRepository;
        this.eventoRepository = eventoRepository;
    }

    @Override
    public List<Evento> getAllEvents() {
        List<Evento> events = eventoRepository.findAll();

        if(events.isEmpty()) {
            throw new NoContentException("EventoService","getAllEvents","none", "Nenhum evento encontrado");
        }

        return events;
    }

    @Override
    public Evento getEventById(Long id) {
        Optional<Evento> optionalEvent = eventoRepository.findById(id);

        if(optionalEvent.isEmpty()) {
            throw new NoContentException("EventoService","getEventById","ID: " + id, "Nenhum evento cadastrado com ID " + id);
        }

        return optionalEvent.get();
    }

    @Override
    public Evento createEvent(EventoForm form) {
        Evento event = form.convertFormToEntity(this.tipoEventoRepository, this.telaRepository);
        return eventoRepository.save(event);
    }

    @Override
    public Evento updateEvent(Long id, AtualizacaoEventoForm form) {
        Optional<Evento> optionalEvent = eventoRepository.findById(id);

        if(optionalEvent.isEmpty()) {
            throw new NoContentException("EventoService","updateEvent","ID: " + id, "Nenhum evento cadastrado com ID " + id);
        }

        Evento event = form.updateEntity(optionalEvent.get());

        return eventoRepository.save(event);
    }

    @Override
    public void deleteEvent(Long id) {
        Evento event = this.getEventById(id);

        if (!event.getRequisicoes().isEmpty()) {
            throw new DeleteEntityWithDependentsException("EventoService","deleteEvent","ID: " + id,"Esse Evento não pode ser excluído pois já possui requisição cadastrada.");
        }

    }
}
