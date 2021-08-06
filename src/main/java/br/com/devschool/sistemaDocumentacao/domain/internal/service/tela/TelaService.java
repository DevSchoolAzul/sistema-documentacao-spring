package br.com.devschool.sistemaDocumentacao.domain.internal.service.tela;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.devschool.sistemaDocumentacao.domain.internal.model.tela.Tela;
import br.com.devschool.sistemaDocumentacao.domain.internal.model.tela.dto.TelaFormAtualizarDto;
import br.com.devschool.sistemaDocumentacao.domain.internal.model.tela.dto.TelaFormCadastrarDto;
import br.com.devschool.sistemaDocumentacao.infraestructure.exception.DeleteEntityWithDependentsException;
import br.com.devschool.sistemaDocumentacao.infraestructure.exception.NoContentException;
import br.com.devschool.sistemaDocumentacao.infraestructure.repository.tela.TelaRepository;
import br.com.devschool.sistemaDocumentacao.infraestructure.repository.versao.VersaoRepository;

@Service
public class TelaService {

	@Autowired
	private TelaRepository telaRepository;
	@Autowired
	private VersaoRepository versaoRepository;

	public List<Tela> listar(Long idVersao) {
		if (idVersao != null) {
			return telaRepository.findAllByVersaoId(idVersao);
		}
		return telaRepository.findAll();
	}

	public Tela cadastrar(TelaFormCadastrarDto formTela) throws NoContentException {
		Tela tela = formTela.toTela(telaRepository, versaoRepository);
		return telaRepository.save(tela);
	}

	public Tela buscar(Long id) throws NoContentException {
		Optional<Tela> optional = telaRepository.findById(id);
		if (optional.isPresent()) {
			return optional.get();
		}
		throw new NoContentException("nenhuma tela cadastrada com id " + id);
	}

	public Tela atualizar(Long id, TelaFormAtualizarDto telaForm) throws NoContentException {
		Tela tela = this.buscar(id);
		telaForm.atualizar(tela, this);
		return telaRepository.save(tela);
	}

	public void deletar(Long id) throws NoContentException, DeleteEntityWithDependentsException {
		Tela tela = this.buscar(id);
		if (tela.getEventos().size() > 0)
			throw new DeleteEntityWithDependentsException("Esta tela não pode ser excluida pois já possui telas assiciadas a ela."); 
		if (tela.getTelasFilhas().size() > 0)  
			throw new DeleteEntityWithDependentsException("Esta tela não pode ser excluida pois já possui eventos assiciadas a ela.");
		telaRepository.delete(tela);
	}

}
