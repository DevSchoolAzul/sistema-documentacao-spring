package br.com.devschool.sistemaDocumentacao.infraestructure.repository.requisicao;

import br.com.devschool.sistemaDocumentacao.domain.internal.model.requisicao.Requisicao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RequisicaoRepository extends JpaRepository<Requisicao, Long> {
}
