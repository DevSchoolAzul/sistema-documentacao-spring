package br.com.devschool.sistemaDocumentacao.infraestructure.repository.propriedade;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.devschool.sistemaDocumentacao.domain.internal.model.propriedade.PropriedadeRequisicao;

public interface PropriedadeRequisicaoRepository extends JpaRepository<PropriedadeRequisicao, Long> {

	List<PropriedadeRequisicao> findAllByRequisicaoId(Long requisicaoId);
}
