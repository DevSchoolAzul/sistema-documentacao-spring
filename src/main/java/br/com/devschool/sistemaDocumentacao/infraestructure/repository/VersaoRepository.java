package br.com.devschool.sistemaDocumentacao.infraestructure.repository;

import br.com.devschool.sistemaDocumentacao.domain.model.versao.Versao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VersaoRepository extends JpaRepository<Versao, Long> {
}
