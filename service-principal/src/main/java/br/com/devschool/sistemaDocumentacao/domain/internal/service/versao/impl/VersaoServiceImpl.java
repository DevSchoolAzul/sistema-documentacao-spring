package br.com.devschool.sistemaDocumentacao.domain.internal.service.versao.impl;

import br.com.devschool.sistemaDocumentacao.domain.internal.model.versao.Versao;
import br.com.devschool.sistemaDocumentacao.domain.internal.model.versao.form.AtualizacaoVersaoForm;
import br.com.devschool.sistemaDocumentacao.domain.internal.model.versao.form.VersaoForm;
import br.com.devschool.sistemaDocumentacao.domain.internal.service.versao.VersaoService;
import br.com.devschool.sistemaDocumentacao.infraestructure.exception.DeleteEntityWithDependentsException;
import br.com.devschool.sistemaDocumentacao.infraestructure.exception.NoContentException;
import br.com.devschool.sistemaDocumentacao.infraestructure.repository.projeto.ProjetoRepository;
import br.com.devschool.sistemaDocumentacao.infraestructure.repository.versao.VersaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VersaoServiceImpl implements VersaoService {

    private VersaoRepository versaoRepository;
    private ProjetoRepository projetoRepository;

    @Autowired
    public VersaoServiceImpl(VersaoRepository versaoRepository, ProjetoRepository projetoRepository) {
        this.versaoRepository = versaoRepository;
        this.projetoRepository = projetoRepository;
    }


    @Override
    public List<Versao> getAllVersions() throws NoContentException {
        List<Versao> versions = versaoRepository.findAll();

        if (versions.isEmpty()) {
            throw new NoContentException("VersoService","getAllVersoes","none","Nenhuma versão encontrada");
        }

        return versions;
    }

    @Override
    public Versao getVersionById(Long id) throws NoContentException {
        Optional<Versao> optionalVersion= versaoRepository.findById(id);

        if(optionalVersion.isEmpty()) {
            throw new NoContentException("VersoService","getVersionById","ID: " + id,"Nenhuma versão cadastrado com ID " + id);
        }

        return optionalVersion.get();
    }

    @Override
    public Versao createVersion(VersaoForm form) {
        Versao version = form.convertFormToEntity(projetoRepository);
        return versaoRepository.save(version);
    }

    @Override
    public Versao updateVersion(Long id, AtualizacaoVersaoForm form) throws NoContentException {
        Optional<Versao> optionalVersion = versaoRepository.findById(id);

        if(optionalVersion.isPresent()) {
            throw new NoContentException("VersoService","updateVersion","ID: " + id,"Nenhuma versão cadastrada com ID " + id);
        }
        Versao version = form.updateEntity(optionalVersion.get());

        return versaoRepository.save(version);
    }

    @Override
    public void deleteVersion(Long id) throws NoContentException, DeleteEntityWithDependentsException {
        Versao versao = this.getVersionById(id);
        if(!versao.getTelas().isEmpty()) {
            throw new DeleteEntityWithDependentsException("VersoService","deleVersion","ID: " + id,"Essa Versão não pode ser excluída pois já possui tela cadastrada.");
        }
        versaoRepository.deleteById(id);
    }
}
