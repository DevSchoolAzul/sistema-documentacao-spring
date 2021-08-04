package br.com.devschool.sistemaDocumentacao.domain.internal.service.projeto;

import br.com.devschool.sistemaDocumentacao.domain.internal.model.projeto.Projeto;

import java.util.List;

public interface ProjetoService {

    List<Projeto> getAllProjects();

    Projeto getProjectById(Long id);

    Projeto createProject(Projeto projeto);

    Projeto updateProject(Long id, Projeto projeto);

    void deleteProject(Long id);

}
