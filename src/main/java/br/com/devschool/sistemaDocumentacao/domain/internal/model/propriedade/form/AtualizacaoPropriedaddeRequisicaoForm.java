package br.com.devschool.sistemaDocumentacao.domain.internal.model.propriedade.form;

import br.com.devschool.sistemaDocumentacao.domain.internal.model.propriedade.PropriedadeRequisicao;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Optional;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AtualizacaoPropriedaddeRequisicaoForm {

    private Long id;
    private String chave;
    private String valor;
    private Integer ordem;

    public PropriedadeRequisicao updateEntity(PropriedadeRequisicao propertie) {
        propertie.setId(this.id);
        propertie.setChave(this.chave);
        propertie.setValor(this.valor);
        propertie.setOrdem(this.ordem);
        return propertie;
    }
}
