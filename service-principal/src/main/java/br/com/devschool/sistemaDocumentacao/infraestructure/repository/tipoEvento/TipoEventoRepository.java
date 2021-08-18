package br.com.devschool.sistemaDocumentacao.infraestructure.repository.tipoEvento;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.devschool.sistemaDocumentacao.domain.internal.model.tipoEvento.TipoEvento;

public interface TipoEventoRepository extends JpaRepository<TipoEvento, Long> {

	@Query("SELECT t FROM TipoEvento t WHERE nome LIKE %:nome% and (:situacao IS null or :situacao = situacao)")
	List<TipoEvento> findAllByNomeAndSituacao(@Param(value = "nome") String nome, @Param(value = "situacao") Boolean situacao);
}
