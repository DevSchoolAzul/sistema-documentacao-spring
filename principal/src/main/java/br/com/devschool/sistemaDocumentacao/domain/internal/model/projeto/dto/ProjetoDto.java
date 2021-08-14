package br.com.devschool.sistemaDocumentacao.domain.internal.model.projeto.dto;

import br.com.devschool.sistemaDocumentacao.domain.internal.model.projeto.Projeto;
import lombok.*;

import java.util.List;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProjetoDto {

    private Long id;
    private String nome;
    private Boolean situacao;

    public ProjetoDto(Projeto projeto) {
        this.id = projeto.getId();
        this.nome = projeto.getNome();
        this.situacao = projeto.getSituacao();
    }

    public static List<ProjetoDto> convertList(List<Projeto> projects) {
        return projects.stream().map(ProjetoDto::new).collect(Collectors.toList());
    }
}
