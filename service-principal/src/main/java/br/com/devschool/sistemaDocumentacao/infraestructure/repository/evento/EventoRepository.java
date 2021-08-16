package br.com.devschool.sistemaDocumentacao.infraestructure.repository.evento;

import br.com.devschool.sistemaDocumentacao.domain.internal.model.evento.Evento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventoRepository extends JpaRepository<Evento, Long> {
}
