package br.com.devschool.sistemaDocumentacao.domain.internal.model.versao.form;

import br.com.devschool.sistemaDocumentacao.domain.internal.model.projeto.Projeto;
import br.com.devschool.sistemaDocumentacao.domain.internal.model.versao.Versao;
import br.com.devschool.sistemaDocumentacao.domain.internal.service.projeto.ProjetoService;
import br.com.devschool.sistemaDocumentacao.infraestructure.repository.projeto.ProjetoRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Optional;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VersaoForm {

    private String gmud;
    private String descricao;
    private Boolean situacao;
    private Integer ordem;
    private String numeroVersao;
    private Long projetoId;

    public Versao convertFormToEntity(ProjetoRepository projetoRepository) {
        Projeto project = projetoRepository.findById(this.projetoId).get();
        return new Versao(this.gmud, this.descricao, this.situacao, this.ordem, this.numeroVersao, project);
    }
}
