package br.com.devschool.sistemaDocumentacao.infraestructure.repository.tela;

import java.util.List;

import br.com.devschool.sistemaDocumentacao.domain.internal.model.tela.dto.TelaDto;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.devschool.sistemaDocumentacao.domain.internal.model.tela.Tela;
import org.springframework.http.ResponseEntity;

public interface TelaRepository extends JpaRepository<Tela, Long> {

	List<Tela> findByVersaoId(Long idVersao);

	List<Tela> findAllByVersaoId(Long idVersao);
}
