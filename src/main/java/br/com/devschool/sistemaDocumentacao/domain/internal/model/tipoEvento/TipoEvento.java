package br.com.devschool.sistemaDocumentacao.domain.internal.model.tipoEvento;

import br.com.devschool.sistemaDocumentacao.domain.internal.model.evento.Evento;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "tipo_eventos")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TipoEvento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private Boolean situacao;

    @OneToMany(mappedBy = "tipoEvento")
    private List<Evento> eventos;
}
