package br.com.devschool.sistemaDocumentacao.domain.internal.service.tela;

import java.util.List;

import br.com.devschool.sistemaDocumentacao.domain.internal.model.tela.Tela;
import br.com.devschool.sistemaDocumentacao.domain.internal.model.tela.form.TelaFormAtualizarDto;
import br.com.devschool.sistemaDocumentacao.domain.internal.model.tela.form.TelaFormCadastrarDto;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.multipart.MultipartFile;

public interface TelaService {
    @Cacheable(value = "listTelas")
    List<Tela> listar(Long id);

    @CacheEvict(value = "listTelas", allEntries = true)
    Tela cadastrar(TelaFormCadastrarDto formTela);

    @CacheEvict(value = "listTelas", allEntries = true)
    Tela buscar(Long id);

    @CacheEvict(value = "listTelas", allEntries = true)
    Tela atualizar(Long id, TelaFormAtualizarDto telaForm);

    @CacheEvict(value = "listTelas", allEntries = true)
    void deletar(Long id);

}
