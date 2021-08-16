package br.com.devschool.sistemaDocumentacao.domain.internal.model.propriedade.dto;

import br.com.devschool.sistemaDocumentacao.domain.internal.model.propriedade.PropriedadeRequisicao;
import br.com.devschool.sistemaDocumentacao.domain.internal.model.requisicao.Requisicao;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.ManyToOne;
import java.util.List;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PropriedadeRequisicaoDto {

    private Long id;
    private String chave;
    private String valor;
    private Integer ordem;
    private Long requisicaoId;

    public PropriedadeRequisicaoDto(PropriedadeRequisicao propriedadeRequisicao) {
        this.id = propriedadeRequisicao.getId();
        this.chave = propriedadeRequisicao.getChave();
        this.valor = propriedadeRequisicao.getValor();
        this.ordem = propriedadeRequisicao.getOrdem();
        this.requisicaoId = propriedadeRequisicao.getRequisicao().getId();
    }

    public static List<PropriedadeRequisicaoDto> covertList(List<PropriedadeRequisicao> allProperties) {
        return allProperties.stream().map(PropriedadeRequisicaoDto::new).collect(Collectors.toList());
    }
}
