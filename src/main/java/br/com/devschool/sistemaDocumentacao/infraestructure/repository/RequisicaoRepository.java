package br.com.devschool.sistemaDocumentacao.infraestructure.repository;

import br.com.devschool.sistemaDocumentacao.domain.model.requisicao.Requisicao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RequisicaoRepository extends JpaRepository<Requisicao, Long> {
}
