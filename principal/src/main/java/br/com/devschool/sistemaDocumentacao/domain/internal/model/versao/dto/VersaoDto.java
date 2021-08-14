package br.com.devschool.sistemaDocumentacao.domain.internal.model.versao.dto;

import br.com.devschool.sistemaDocumentacao.domain.internal.model.versao.Versao;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VersaoDto {

    private Long id;
    private String gmud;
    private String descricao;
    private LocalDate dataLancamento;
    private Boolean situacao;
    private Integer ordem;
    private String numeroVersao;
    private Long projetoId;

    public VersaoDto(Versao v) {
        this.id = v.getId();
        this.gmud = v.getGmud();
        this.descricao = v.getDescricao();
        this.dataLancamento = v.getDataLancamento();
        this.situacao = v.getSituacao();
        this.ordem = v.getOrdem();
        this.numeroVersao = v.getNumeroVersao();
        this.projetoId = v.getProjeto().getId();
    }

    public static List<VersaoDto> convertList(List<Versao> versions) {
        return versions.stream().map(VersaoDto::new).collect(Collectors.toList());
    }
}
