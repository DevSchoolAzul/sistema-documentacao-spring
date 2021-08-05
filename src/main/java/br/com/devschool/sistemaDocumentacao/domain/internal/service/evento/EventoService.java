package br.com.devschool.sistemaDocumentacao.domain.internal.service.evento;

import br.com.devschool.sistemaDocumentacao.domain.internal.model.evento.Evento;

public interface EventoService {
    Evento buscar(Long evento);
}
