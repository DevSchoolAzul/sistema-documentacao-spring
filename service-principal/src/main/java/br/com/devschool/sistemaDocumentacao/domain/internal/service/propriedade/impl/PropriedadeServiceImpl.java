package br.com.devschool.sistemaDocumentacao.domain.internal.service.propriedade.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import br.com.devschool.sistemaDocumentacao.domain.internal.model.propriedade.PropriedadeRequisicao;
import br.com.devschool.sistemaDocumentacao.domain.internal.model.propriedade.form.AtualizacaoPropriedaddeRequisicaoForm;
import br.com.devschool.sistemaDocumentacao.domain.internal.model.propriedade.form.PropriedadeRequisicaoForm;
import br.com.devschool.sistemaDocumentacao.domain.internal.service.propriedade.PropriedadeService;
import br.com.devschool.sistemaDocumentacao.domain.internal.service.requisicao.RequisicaoService;
import br.com.devschool.sistemaDocumentacao.infraestructure.exception.NoContentException;
import br.com.devschool.sistemaDocumentacao.infraestructure.repository.propriedade.PropriedadeRequisicaoRepository;

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
    public List<PropriedadeRequisicao> getAllProperties(Long requisicaoId) {
        List<PropriedadeRequisicao> propriedades;
    	if (requisicaoId != null) {
        	propriedades = propriedadeRequisicaoRepository.findAllByRequisicaoId(requisicaoId);
        } else {
        	propriedades = propriedadeRequisicaoRepository.findAll();
        }
    	if (propriedades.isEmpty()) {
    		throw new NoContentException("PropriedadeRequisicao", "GetAllProjects", "idRequisicao: " + requisicaoId, "Não foi encontrada Propriedades de Requisição");
    	}
    	return propriedades;
    }

    @Override
    public PropriedadeRequisicao getPropertieById(Long id) throws NoContentException {
        Optional<PropriedadeRequisicao> optionalPropertie = propriedadeRequisicaoRepository.findById(id);
        if(optionalPropertie.isEmpty()) {
            throw new NoContentException(this.getClass().getName(), "getPropertieById", "Id: " + id, "Não foi encontrado Propriedades com esse ID.");
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
            throw new NoContentException(this.getClass().getName(), "updatePropertie", "Id: " + id + " atributos: " + form, "Não foi encontrado Propriedades com esse ID.");
        }
        PropriedadeRequisicao propertie = form.updateEntity(optionalPropertie.get());
        return propriedadeRequisicaoRepository.save(propertie);
    }

    @Override
    public void deletePropertie(Long id) {
    	this.getPropertieById(id);
        propriedadeRequisicaoRepository.deleteById(id);
    }
}
