package br.com.devschool.sistemaDocumentacao.infraestructure.repository.projeto;

import br.com.devschool.sistemaDocumentacao.domain.internal.model.projeto.Projeto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjetoRepository extends JpaRepository<Projeto, Long> {
}
