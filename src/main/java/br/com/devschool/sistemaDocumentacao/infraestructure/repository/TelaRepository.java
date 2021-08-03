package br.com.devschool.sistemaDocumentacao.infraestructure.repository;

import br.com.devschool.sistemaDocumentacao.domain.model.Tela;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TelaRepository extends JpaRepository<Tela, Long> {
}
