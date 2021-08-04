package br.com.devschool.sistemaDocumentacao.domain.internal.service.versao.impl;

import br.com.devschool.sistemaDocumentacao.domain.internal.model.projeto.Projeto;
import br.com.devschool.sistemaDocumentacao.domain.internal.model.versao.Versao;
import br.com.devschool.sistemaDocumentacao.domain.internal.service.versao.VersaoService;
import br.com.devschool.sistemaDocumentacao.infraestructure.repository.versao.VersaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VersaoServiceImpl implements VersaoService {

    @Autowired
    private VersaoRepository versaoRepository;

    @Override
    public List<Versao> getAllVersions() {
        return versaoRepository.findAll();
    }

    @Override
    public Optional<Versao> getVersionById(Long id) {
        return versaoRepository.findById(id);
    }

    @Override
    public Versao save(Versao version) {
        return versaoRepository.save(version);
    }

    @Override
    public void deleteVersion(Long id) {
        versaoRepository.deleteById(id);
    }
}
