package br.com.devschool.sistemaDocumentacao.domain.internal.service.tela;

import br.com.devschool.sistemaDocumentacao.domain.internal.model.tela.Tela;
import br.com.devschool.sistemaDocumentacao.domain.internal.model.tela.form.TelaFormAtualizarDto;
import br.com.devschool.sistemaDocumentacao.domain.internal.model.tela.form.TelaFormCadastrarDto;
import br.com.devschool.sistemaDocumentacao.infraestructure.exception.DeleteEntityWithDependentsException;
import br.com.devschool.sistemaDocumentacao.infraestructure.exception.NoContentException;

import java.util.List;

public interface TelaService {
    List<Tela> listar(Long id);
    Tela cadastrar(TelaFormCadastrarDto formTela) throws NoContentException;
    Tela buscar(Long id) throws NoContentException;
    Tela atualizar(Long id, TelaFormAtualizarDto telaForm) throws NoContentException;
    void deletar(Long id) throws NoContentException, DeleteEntityWithDependentsException;
}
