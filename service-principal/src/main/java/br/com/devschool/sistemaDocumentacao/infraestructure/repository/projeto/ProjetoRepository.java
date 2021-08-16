package br.com.devschool.sistemaDocumentacao.infraestructure.repository.projeto;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.devschool.sistemaDocumentacao.domain.internal.model.projeto.Projeto;

public interface ProjetoRepository extends JpaRepository<Projeto, Long> {

	@Query("SELECT p FROM Projeto p WHERE nome LIKE %:nome%   and (:situacao IS null or situacao = :situacao)")
	List<Projeto> findByNomeContainsAndSituacao(@Param(value = "nome") String nome, @Param(value = "situacao") Boolean situacao);
}
