package br.com.devschool.sistemaDocumentacao.domain.internal.model.tela.form;

import java.time.LocalDate;
import java.util.Optional;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import br.com.devschool.sistemaDocumentacao.domain.internal.model.tela.Tela;
import br.com.devschool.sistemaDocumentacao.domain.internal.model.versao.Versao;
import br.com.devschool.sistemaDocumentacao.infraestructure.exception.NoContentException;
import br.com.devschool.sistemaDocumentacao.infraestructure.repository.tela.TelaRepository;
import br.com.devschool.sistemaDocumentacao.infraestructure.repository.versao.VersaoRepository;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Getter
@Setter
@NoArgsConstructor
public class TelaFormCadastrarDto {

	@NotNull
	private Long versao;
	@NotBlank
	private String nomeTela;
	@NotNull
	private Integer ordem;
	@NotBlank
	private String dataCadastro;
	@NotBlank
	private String urlLog;
	@NotNull
	private Boolean situacao;
	@NotBlank
	private String imagem;
	private Long telaPai;

	public Tela toTela(TelaRepository telaRepository, VersaoRepository versaoRepository){
		Optional<Versao> versao = versaoRepository.findById(this.versao);
		if (versao.isEmpty()) throw new NoContentException("Não foi encontrada Versão com essa id");
		
		Tela tela = Tela.builder()
				.versao(versao.get())
				.telaPai((telaPai != null)? telaRepository.findById(telaPai).get() : null)
				.nomeTela(nomeTela)
				.ordem(ordem)
				.dataCadastro(LocalDate.parse(dataCadastro))
				.urlLog(urlLog)
				.situacao(situacao)
				.imagem(imagem)
				.build();
		return tela;
	}
	
}
