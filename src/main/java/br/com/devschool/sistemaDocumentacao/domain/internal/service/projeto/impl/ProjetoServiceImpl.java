package br.com.devschool.sistemaDocumentacao.domain.internal.service.projeto.impl;

import br.com.devschool.sistemaDocumentacao.domain.internal.model.projeto.Projeto;
import br.com.devschool.sistemaDocumentacao.domain.internal.service.projeto.ProjetoService;
import br.com.devschool.sistemaDocumentacao.infraestructure.repository.projeto.ProjetoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjetoServiceImpl implements ProjetoService {

    @Autowired
    private ProjetoRepository projetoRepository;



    @Override
    public List<Projeto> getAllProjects() {
        return projetoRepository.findAll();
    }

    @Override
    public Projeto getProjectById(Long id) {
        return null;
    }

    @Override
    public Projeto createProject(Projeto projeto) {
        return projetoRepository.save(projeto);
    }

    @Override
    public Projeto updateProject(Long id, Projeto projeto) {
        return null;
    }

    @Override
    public void deleteProject(Long id) {

    }
}
