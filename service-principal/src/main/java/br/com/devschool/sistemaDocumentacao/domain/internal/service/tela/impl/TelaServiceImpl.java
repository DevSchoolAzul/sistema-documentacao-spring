package br.com.devschool.sistemaDocumentacao.domain.internal.service.tela.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.devschool.sistemaDocumentacao.domain.internal.model.tela.Tela;
import br.com.devschool.sistemaDocumentacao.domain.internal.model.tela.form.TelaFormAtualizarDto;
import br.com.devschool.sistemaDocumentacao.domain.internal.model.tela.form.TelaFormCadastrarDto;
import br.com.devschool.sistemaDocumentacao.domain.internal.service.tela.TelaService;
import br.com.devschool.sistemaDocumentacao.infraestructure.exception.DeleteEntityWithDependentsException;
import br.com.devschool.sistemaDocumentacao.infraestructure.exception.NoContentException;
import br.com.devschool.sistemaDocumentacao.infraestructure.repository.tela.TelaRepository;
import br.com.devschool.sistemaDocumentacao.infraestructure.repository.versao.VersaoRepository;

@Service
public class TelaServiceImpl implements TelaService {

	@Autowired
	private TelaRepository telaRepository;
	@Autowired
	private VersaoRepository versaoRepository;

	@Override
	public List<Tela> listar(Long idVersao) {
		if (idVersao != null){
			return telaRepository.findByVersaoId(idVersao);
		}
		return telaRepository.findAll();
	}

	@Override
	public Tela cadastrar(TelaFormCadastrarDto formTela) {
		Tela tela = formTela.toTela(telaRepository, versaoRepository);
		return telaRepository.save(tela);
	}

	@Override
	public Tela buscar(Long id) {
		Optional<Tela> optional = telaRepository.findById(id);
		if (optional.isPresent()) {
			return optional.get();
		}
		throw new NoContentException("nenhuma tela cadastrada com id " + id);
	}

	@Override
	public Tela atualizar(Long id, TelaFormAtualizarDto telaForm) {
		Tela tela = this.buscar(id);
		telaForm.atualizar(tela, this);
		return telaRepository.save(tela);
	}

	@Override
	public void deletar(Long id) {
		Tela tela = this.buscar(id);
		if (tela.getTelasFilhas().size() > 0)  
			throw new DeleteEntityWithDependentsException("Esta tela n??o pode ser excluida pois j?? possui telas assiciadas a ela.");
		if (tela.getEventos().size() > 0)
			throw new DeleteEntityWithDependentsException("Esta tela n??o pode ser excluida pois j?? possui eventos assiciadas a ela.");
		telaRepository.delete(tela);
	}



}
