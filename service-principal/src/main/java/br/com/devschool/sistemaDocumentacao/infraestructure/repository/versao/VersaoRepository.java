package br.com.devschool.sistemaDocumentacao.infraestructure.repository.versao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.devschool.sistemaDocumentacao.domain.internal.model.versao.Versao;

public interface VersaoRepository extends JpaRepository<Versao, Long> {
	
	List<Versao> findByProjetoId(Long idProjeto);
}
