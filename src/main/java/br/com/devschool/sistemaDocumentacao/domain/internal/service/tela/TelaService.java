package br.com.devschool.sistemaDocumentacao.domain.internal.service.tela;

import java.util.List;

import br.com.devschool.sistemaDocumentacao.domain.internal.model.tela.Tela;
import br.com.devschool.sistemaDocumentacao.domain.internal.model.tela.form.TelaFormAtualizarDto;
import br.com.devschool.sistemaDocumentacao.domain.internal.model.tela.form.TelaFormCadastrarDto;

public interface TelaService {
    List<Tela> listar(Long id);
    Tela cadastrar(TelaFormCadastrarDto formTela);
    Tela buscar(Long id);
    Tela atualizar(Long id, TelaFormAtualizarDto telaForm);
    void deletar(Long id);
}
