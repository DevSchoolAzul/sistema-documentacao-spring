package br.com.devschool.sistemaDocumentacao.domain.internal.service.projeto.impl;

import br.com.devschool.sistemaDocumentacao.domain.internal.model.projeto.Projeto;
import br.com.devschool.sistemaDocumentacao.domain.internal.service.projeto.ProjetoService;
import br.com.devschool.sistemaDocumentacao.infraestructure.repository.projeto.ProjetoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProjetoServiceImpl implements ProjetoService {

    @Autowired
    private ProjetoRepository projetoRepository;


    @Override
    public List<Projeto> getAllProjects() {
        return projetoRepository.findAll();
    }

    @Override
    public Optional<Projeto> getProjectById(Long id) {
        return projetoRepository.findById(id);
    }

    @Override
    public Projeto save(Projeto projeto) {
        return projetoRepository.save(projeto);
    }

    @Override
    public void deleteProject(Long id) {
        projetoRepository.deleteById(id);
    }
}
