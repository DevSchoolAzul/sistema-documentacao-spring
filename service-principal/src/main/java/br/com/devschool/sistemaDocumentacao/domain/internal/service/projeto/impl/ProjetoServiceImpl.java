package br.com.devschool.sistemaDocumentacao.domain.internal.service.projeto.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.devschool.sistemaDocumentacao.domain.internal.model.projeto.Projeto;
import br.com.devschool.sistemaDocumentacao.domain.internal.model.projeto.form.AtualizacaoProjetoForm;
import br.com.devschool.sistemaDocumentacao.domain.internal.model.projeto.form.ProjetoForm;
import br.com.devschool.sistemaDocumentacao.domain.internal.service.projeto.ProjetoService;
import br.com.devschool.sistemaDocumentacao.infraestructure.exception.DeleteEntityWithDependentsException;
import br.com.devschool.sistemaDocumentacao.infraestructure.exception.NoContentException;
import br.com.devschool.sistemaDocumentacao.infraestructure.repository.projeto.ProjetoRepository;

@Service
public class ProjetoServiceImpl implements ProjetoService {
	
	@Autowired
    private ProjetoRepository projetoRepository;

    @Override
    public List<Projeto> getAllProjects(){
        List<Projeto> projects= projetoRepository.findAll();
        if(projects.isEmpty()) {
            throw new NoContentException("Nenhum projeto encontrado");
        }

        return projects;
    }

    @Override
    public Projeto getProjectById(Long id){
        Optional<Projeto> optionalProject = projetoRepository.findById(id);

        if(optionalProject.isEmpty()) {
            throw new NoContentException("Nenhum projeto cadastrado com ID " + id);
        }

        return optionalProject.get();
    }

    @Override
    public Projeto createProject(ProjetoForm form) {
        Projeto project = form.convertFormToEntity();
        return projetoRepository.save(project);
    }

    @Override
    public Projeto updateProjectById(Long id, AtualizacaoProjetoForm form) {
        Optional<Projeto> optionalProjeto = projetoRepository.findById(id);

        if(optionalProjeto.isEmpty()) {
            throw new NoContentException("Nenhuma projeto cadastrado com ID " + id);
        }

        Projeto project = form.convertFormToEntity(optionalProjeto.get());
        return projetoRepository.save(project);
    }

    @Override
    public void deleteProject(Long id) {
        Projeto project = this.getProjectById(id);
        if (!project.getVersoes().isEmpty()) {
            throw new DeleteEntityWithDependentsException("Esse Projeto n??o pode ser exclu??do pois j?? possui vers??o cadastrada.");
        }
        projetoRepository.deleteById(id);
    }

	@Override
	public List<Projeto> getProjectsByNameAndSituation(String nome, Boolean situacao) {
		List<Projeto> projects = projetoRepository.findByNomeContainsAndSituacao(nome, situacao);
		if(projects.isEmpty()) {
            throw new NoContentException("Nenhum projeto encontrado");
		}
		return projects;
	}

}
