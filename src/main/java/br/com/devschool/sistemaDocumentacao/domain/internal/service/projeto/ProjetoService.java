package br.com.devschool.sistemaDocumentacao.domain.internal.service.projeto;

import br.com.devschool.sistemaDocumentacao.domain.internal.model.projeto.Projeto;
import br.com.devschool.sistemaDocumentacao.domain.internal.model.projeto.form.AtualizacaoProjetoForm;
import br.com.devschool.sistemaDocumentacao.domain.internal.model.projeto.form.ProjetoForm;
import br.com.devschool.sistemaDocumentacao.infraestructure.exception.DeleteEntityWithDependentsException;
import br.com.devschool.sistemaDocumentacao.infraestructure.exception.NoContentException;

import java.util.List;

public interface ProjetoService {

    List<Projeto> getAllProjects();

    Projeto getProjectById(Long id);

    Projeto createProject(ProjetoForm form);

    Projeto updateProjectById(Long id, AtualizacaoProjetoForm form);

    void deleteProject(Long id);

}
