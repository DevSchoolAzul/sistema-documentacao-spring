package br.com.devschool.sistemaDocumentacao.domain.internal.service.propriedade;

import br.com.devschool.sistemaDocumentacao.domain.internal.model.propriedade.PropriedadeRequisicao;
import br.com.devschool.sistemaDocumentacao.domain.internal.model.propriedade.form.AtualizacaoPropriedaddeRequisicaoForm;
import br.com.devschool.sistemaDocumentacao.domain.internal.model.propriedade.form.PropriedadeRequisicaoForm;
import br.com.devschool.sistemaDocumentacao.infraestructure.exception.NoContentException;

import java.util.List;

public interface PropriedadeService {

    List<PropriedadeRequisicao> getAllProperties();

    PropriedadeRequisicao getPropertieById(Long id);

    PropriedadeRequisicao createPropertie(PropriedadeRequisicaoForm form);

    PropriedadeRequisicao updatePropertie(Long id, AtualizacaoPropriedaddeRequisicaoForm form);

    void deletePropertie(Long id);

}
