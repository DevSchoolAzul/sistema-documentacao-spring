package br.com.devschool.sistemaDocumentacao.domain.internal.service.versao;

import br.com.devschool.sistemaDocumentacao.domain.internal.model.projeto.Projeto;
import br.com.devschool.sistemaDocumentacao.domain.internal.model.versao.Versao;

import java.util.List;
import java.util.Optional;

public interface VersaoService {

    List<Versao> getAllVersions();

    Optional<Versao> getVersionById(Long id);

    Versao save(Versao version);

    void deleteVersion(Long id);

}
