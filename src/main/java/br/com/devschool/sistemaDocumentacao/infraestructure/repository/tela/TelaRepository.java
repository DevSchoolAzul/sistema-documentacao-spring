package br.com.devschool.sistemaDocumentacao.infraestructure.repository.tela;

import br.com.devschool.sistemaDocumentacao.domain.internal.model.tela.Tela;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TelaRepository extends JpaRepository<Tela, Long> {
}
