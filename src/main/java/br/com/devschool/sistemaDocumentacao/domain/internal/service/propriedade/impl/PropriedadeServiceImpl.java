package br.com.devschool.sistemaDocumentacao.domain.internal.service.propriedade.impl;

import br.com.devschool.sistemaDocumentacao.domain.internal.model.propriedade.PropriedadeRequisicao;
import br.com.devschool.sistemaDocumentacao.domain.internal.model.propriedade.form.AtualizacaoPropriedaddeRequisicaoForm;
import br.com.devschool.sistemaDocumentacao.domain.internal.model.propriedade.form.PropriedadeRequisicaoForm;
import br.com.devschool.sistemaDocumentacao.domain.internal.service.propriedade.PropriedadeService;
import br.com.devschool.sistemaDocumentacao.domain.internal.service.requisicao.RequisicaoService;
import br.com.devschool.sistemaDocumentacao.infraestructure.exception.NoContentException;
import br.com.devschool.sistemaDocumentacao.infraestructure.repository.propriedade.PropriedadeRequisicaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Service
public class PropriedadeServiceImpl implements PropriedadeService {

    private PropriedadeRequisicaoRepository propriedadeRequisicaoRepository;
    private RequisicaoService  requisicaoService;

    @Autowired
    public PropriedadeServiceImpl(PropriedadeRequisicaoRepository propriedadeRequisicaoRepository, RequisicaoService requisicaoService) {
        this.propriedadeRequisicaoRepository = propriedadeRequisicaoRepository;
        this.requisicaoService = requisicaoService;
    }

    @Override
    public List<PropriedadeRequisicao> getAllProperties() {
        return propriedadeRequisicaoRepository.findAll();
    }

    @Override
    public PropriedadeRequisicao getPropertieById(Long id) throws NoContentException {
        Optional<PropriedadeRequisicao> optionalPropertie = propriedadeRequisicaoRepository.findById(id);
        if(optionalPropertie.isEmpty()) {
            throw new NoContentException("");
        }
        return optionalPropertie.get();
    }

    @Override
    public PropriedadeRequisicao createPropertie(PropriedadeRequisicaoForm form) throws NoContentException {
        PropriedadeRequisicao propertie = form.convertFormToEntity(this.requisicaoService);
        return propriedadeRequisicaoRepository.save(propertie);
    }

    @Override
    public PropriedadeRequisicao updatePropertie(@PathVariable Long id, AtualizacaoPropriedaddeRequisicaoForm form) throws NoContentException {
        Optional<PropriedadeRequisicao> optionalPropertie = propriedadeRequisicaoRepository.findById(id);
        if(optionalPropertie.isEmpty()) {
            throw new NoContentException("");
        }
        PropriedadeRequisicao propertie = form.updateEntity(optionalPropertie.get());
        return propriedadeRequisicaoRepository.save(propertie);
    }

    @Override
    public void deletePropertie(Long id) throws NoContentException {
        propriedadeRequisicaoRepository.deleteById(id);
    }
}
