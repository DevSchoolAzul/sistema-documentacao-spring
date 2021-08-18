package br.com.devschool.sistemaDocumentacao.infraestructure.repository.tela;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.devschool.sistemaDocumentacao.domain.internal.model.tela.Tela;

public interface TelaRepository extends JpaRepository<Tela, Long> {

	List<Tela> findAllByVersaoId(Long idVersao);

	List<Tela> findAllByVersaoIdAndTelaPaiIsNull(Long idVersao);
}
