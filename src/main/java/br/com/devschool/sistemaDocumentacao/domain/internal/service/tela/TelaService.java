package br.com.devschool.sistemaDocumentacao.domain.internal.service.tela;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.devschool.sistemaDocumentacao.domain.internal.dto.tela.TelaFormAtualizarDto;
import br.com.devschool.sistemaDocumentacao.domain.internal.dto.tela.TelaFormCadastrarDto;
import br.com.devschool.sistemaDocumentacao.domain.internal.model.tela.Tela;
import br.com.devschool.sistemaDocumentacao.infraestructure.repository.tela.TelaRepository;
import br.com.devschool.sistemaDocumentacao.infraestructure.repository.versao.VersaoRepository;

@Service
public class TelaService {

	@Autowired
	private TelaRepository telaRepository;
	@Autowired
	private VersaoRepository versaoRepository;

	public List<Tela> listar() {
		return telaRepository.findAll();
	}

	public Tela cadastrar(TelaFormCadastrarDto formTela) {
		Tela tela = formTela.toTela(this, versaoRepository);
		return telaRepository.save(tela);
	}

	public Tela buscar(Long id) {
		Optional<Tela> optional = telaRepository.findById(id);
		if (optional.isPresent()) {
			return optional.get();
		}
		// TODO exception de Tela
		throw new RuntimeException("Tela não encontrada");

	}

	public Tela atualizar(Long id, TelaFormAtualizarDto telaForm) {
		Tela tela = this.buscar(id);
		telaForm.atualizar(tela, this);
		return telaRepository.save(tela);
	}

	public void deletar(Long id) {
		Tela tela = this.buscar(id);
		telaRepository.delete(tela);
	}

}
