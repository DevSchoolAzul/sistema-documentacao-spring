package br.com.devschool.sistemaDocumentacao.domain.internal.service.propriedade;

import br.com.devschool.sistemaDocumentacao.domain.internal.model.propriedade.PropriedadeRequisicao;
import br.com.devschool.sistemaDocumentacao.domain.internal.model.propriedade.form.AtualizacaoPropriedaddeRequisicaoForm;
import br.com.devschool.sistemaDocumentacao.domain.internal.model.propriedade.form.PropriedadeRequisicaoForm;
import br.com.devschool.sistemaDocumentacao.infraestructure.exception.NoContentException;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;

import java.util.List;

public interface PropriedadeService {
    @Cacheable(value = "listProperties")
    List<PropriedadeRequisicao> getAllProperties(Long requisicaoId);

    @CacheEvict(value = "listProperties", allEntries = true)
    PropriedadeRequisicao getPropertieById(Long id);

    @CacheEvict(value = "listProperties", allEntries = true)
    PropriedadeRequisicao createPropertie(PropriedadeRequisicaoForm form);

    @CacheEvict(value = "listProperties", allEntries = true)
    PropriedadeRequisicao updatePropertie(Long id, AtualizacaoPropriedaddeRequisicaoForm form);

    @CacheEvict(value = "listProperties", allEntries = true)
    void deletePropertie(Long id);

}
