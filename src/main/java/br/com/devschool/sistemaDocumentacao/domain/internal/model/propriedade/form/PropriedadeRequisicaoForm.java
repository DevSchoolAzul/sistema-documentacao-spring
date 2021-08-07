package br.com.devschool.sistemaDocumentacao.domain.internal.model.propriedade.form;

import br.com.devschool.sistemaDocumentacao.domain.internal.model.propriedade.PropriedadeRequisicao;
import br.com.devschool.sistemaDocumentacao.domain.internal.model.requisicao.Requisicao;
import br.com.devschool.sistemaDocumentacao.domain.internal.service.requisicao.RequisicaoService;
import br.com.devschool.sistemaDocumentacao.infraestructure.exception.NoContentException;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PropriedadeRequisicaoForm {

    private Long id;
    private String chave;
    private String valor;
    private Integer ordem;
    private Long requisicaoId;

    public PropriedadeRequisicao convertFormToEntity(RequisicaoService requisicaoService) throws NoContentException {
        Requisicao requisition = requisicaoService.buscar(requisicaoId);
        return PropriedadeRequisicao.builder()
                .id(this.id)
                .chave(this.chave)
                .valor(this.valor)
                .ordem(this.ordem)
                .requisicao(requisition)
                .build();
    }
}
