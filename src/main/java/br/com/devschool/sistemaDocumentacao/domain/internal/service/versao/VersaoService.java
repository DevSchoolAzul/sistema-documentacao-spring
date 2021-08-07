package br.com.devschool.sistemaDocumentacao.domain.internal.service.versao;

import br.com.devschool.sistemaDocumentacao.domain.internal.model.projeto.Projeto;
import br.com.devschool.sistemaDocumentacao.domain.internal.model.versao.Versao;
import br.com.devschool.sistemaDocumentacao.domain.internal.model.versao.form.AtualizacaoVersaoForm;
import br.com.devschool.sistemaDocumentacao.domain.internal.model.versao.form.VersaoForm;
import br.com.devschool.sistemaDocumentacao.infraestructure.exception.DeleteEntityWithDependentsException;
import br.com.devschool.sistemaDocumentacao.infraestructure.exception.NoContentException;

import java.util.List;
import java.util.Optional;

public interface VersaoService {

    List<Versao> getAllVersions() throws NoContentException;

    Versao getVersionById(Long id) throws NoContentException;

    Versao createVersion(VersaoForm form);

    Versao updateVersion(Long id, AtualizacaoVersaoForm form) throws NoContentException;

    void deleteVersion(Long id) throws NoContentException, DeleteEntityWithDependentsException;

}
