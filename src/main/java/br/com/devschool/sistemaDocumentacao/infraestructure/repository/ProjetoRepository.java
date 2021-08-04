package br.com.devschool.sistemaDocumentacao.infraestructure.repository;

import br.com.devschool.sistemaDocumentacao.domain.model.projeto.Projeto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjetoRepository extends JpaRepository<Projeto, Long> {
}
