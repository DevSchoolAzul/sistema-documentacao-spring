package br.com.devschool.sistemaDocumentacao.domain.internal.model.propriedade;

import br.com.devschool.sistemaDocumentacao.domain.internal.model.requisicao.Requisicao;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Entity
@Table(name = "propriedades")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PropriedadeRequisicao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Requisicao requisicao;
    private String chave;
    private String valor;
    private Integer ordem;
}
