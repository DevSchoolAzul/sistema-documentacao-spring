package br.com.devschool.sistemaDocumentacao.infraestructure.repository;

import br.com.devschool.sistemaDocumentacao.domain.model.PropriedadeRequisicao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PropriedadeRequisicaoRepository extends JpaRepository<PropriedadeRequisicao, Long> {
}
