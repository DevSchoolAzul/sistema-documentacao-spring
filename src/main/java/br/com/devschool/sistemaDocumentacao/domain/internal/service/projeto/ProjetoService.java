package br.com.devschool.sistemaDocumentacao.domain.internal.service.projeto;

import br.com.devschool.sistemaDocumentacao.domain.internal.model.projeto.Projeto;
import br.com.devschool.sistemaDocumentacao.domain.internal.model.projeto.form.AtualizacaoProjetoForm;
import br.com.devschool.sistemaDocumentacao.domain.internal.model.projeto.form.ProjetoForm;
import br.com.devschool.sistemaDocumentacao.infraestructure.exception.DeleteEntityWithDependentsException;
import br.com.devschool.sistemaDocumentacao.infraestructure.exception.NoContentException;

import java.util.List;

public interface ProjetoService {

    List<Projeto> getAllProjects() throws NoContentException;

    Projeto getProjectById(Long id) throws NoContentException;

    Projeto createProject(ProjetoForm form);

    Projeto updateProjectById(Long id, AtualizacaoProjetoForm form) throws NoContentException;

    void deleteProject(Long id) throws DeleteEntityWithDependentsException, NoContentException;

}
