package br.com.devschool.sistemaDocumentacao.infraestructure.repository.versao;

import br.com.devschool.sistemaDocumentacao.domain.internal.model.versao.Versao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VersaoRepository extends JpaRepository<Versao, Long> {
}
