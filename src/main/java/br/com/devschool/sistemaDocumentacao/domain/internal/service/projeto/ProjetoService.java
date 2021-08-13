package br.com.devschool.sistemaDocumentacao.domain.internal.service.projeto;

import br.com.devschool.sistemaDocumentacao.domain.internal.model.projeto.Projeto;
import br.com.devschool.sistemaDocumentacao.domain.internal.model.projeto.form.AtualizacaoProjetoForm;
import br.com.devschool.sistemaDocumentacao.domain.internal.model.projeto.form.ProjetoForm;
import br.com.devschool.sistemaDocumentacao.infraestructure.exception.DeleteEntityWithDependentsException;
import br.com.devschool.sistemaDocumentacao.infraestructure.exception.NoContentException;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;

import java.util.List;

public interface ProjetoService {

    @Cacheable(value = "listProjects")
    List<Projeto> getAllProjects();

    @CacheEvict(value = "listProjects", allEntries = true)
    Projeto getProjectById(Long id);

    @CacheEvict(value = "listProjects", allEntries = true)
    Projeto createProject(ProjetoForm form);

    @CacheEvict(value = "listProjects", allEntries = true)
    Projeto updateProjectById(Long id, AtualizacaoProjetoForm form);


    void deleteProject(Long id);

}
