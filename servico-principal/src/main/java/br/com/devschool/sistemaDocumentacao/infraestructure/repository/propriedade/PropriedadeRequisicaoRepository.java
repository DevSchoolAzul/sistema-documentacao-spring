package br.com.devschool.sistemaDocumentacao.infraestructure.repository.propriedade;

import br.com.devschool.sistemaDocumentacao.domain.internal.model.propriedade.PropriedadeRequisicao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PropriedadeRequisicaoRepository extends JpaRepository<PropriedadeRequisicao, Long> {
}
