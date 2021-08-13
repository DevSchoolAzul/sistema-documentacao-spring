package br.com.devschool.sistemaDocumentacao.domain.internal.service.versao;

import br.com.devschool.sistemaDocumentacao.domain.internal.model.versao.Versao;
import br.com.devschool.sistemaDocumentacao.domain.internal.model.versao.form.AtualizacaoVersaoForm;
import br.com.devschool.sistemaDocumentacao.domain.internal.model.versao.form.VersaoForm;
import br.com.devschool.sistemaDocumentacao.infraestructure.exception.DeleteEntityWithDependentsException;
import br.com.devschool.sistemaDocumentacao.infraestructure.exception.NoContentException;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;

import java.util.List;

public interface VersaoService {

    @Cacheable(value = "listVersions")
    List<Versao> getAllVersions() throws NoContentException;

    @CacheEvict(value = "listVersions", allEntries = true)
    Versao getVersionById(Long id) throws NoContentException;

    @CacheEvict(value = "listVersions", allEntries = true)
    Versao createVersion(VersaoForm form);

    @CacheEvict(value = "listVersions", allEntries = true)
    Versao updateVersion(Long id, AtualizacaoVersaoForm form) throws NoContentException;

    @CacheEvict(value = "listVersions", allEntries = true)
    void deleteVersion(Long id) throws NoContentException, DeleteEntityWithDependentsException;

}
