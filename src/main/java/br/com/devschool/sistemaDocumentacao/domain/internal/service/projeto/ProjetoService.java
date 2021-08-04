package br.com.devschool.sistemaDocumentacao.domain.internal.service.projeto;

import br.com.devschool.sistemaDocumentacao.domain.internal.model.projeto.Projeto;

import java.util.List;
import java.util.Optional;

public interface ProjetoService {

    List<Projeto> getAllProjects();

    Optional<Projeto> getProjectById(Long id);

    Projeto save(Projeto projeto);

    void deleteProject(Long id);

}
