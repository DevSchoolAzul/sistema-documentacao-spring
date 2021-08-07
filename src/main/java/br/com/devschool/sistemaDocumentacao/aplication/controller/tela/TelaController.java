package br.com.devschool.sistemaDocumentacao.aplication.controller.tela;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.devschool.sistemaDocumentacao.domain.internal.model.tela.Tela;
import br.com.devschool.sistemaDocumentacao.domain.internal.model.tela.dto.TelaDto;
import br.com.devschool.sistemaDocumentacao.domain.internal.model.tela.form.TelaFormAtualizarDto;
import br.com.devschool.sistemaDocumentacao.domain.internal.model.tela.form.TelaFormCadastrarDto;
import br.com.devschool.sistemaDocumentacao.domain.internal.service.tela.impl.TelaServiceImpl;
import br.com.devschool.sistemaDocumentacao.infraestructure.exception.DeleteEntityWithDependentsException;
import br.com.devschool.sistemaDocumentacao.infraestructure.exception.NoContentException;

@RestController
@RequestMapping("/telas")
public class TelaController {

	@Autowired
	private TelaServiceImpl telaService;

	@GetMapping
	public ResponseEntity<List<TelaDto>> listar(@RequestParam(required = false) Long idVersao) throws NoContentException {
		List<Tela> telas = telaService.listar(idVersao);
		if (telas.isEmpty()) {
			throw new NoContentException("Não foi encontrado telas para essa versão");
		}
		return ResponseEntity.ok(TelaDto.converter(telas));
	}

	@PostMapping
	public ResponseEntity<TelaDto> novaTela(@RequestBody @Valid TelaFormCadastrarDto telaForm) throws NoContentException {
		TelaDto tela = TelaDto.converter(telaService.cadastrar(telaForm));
		return ResponseEntity.ok(tela);
	}

	@GetMapping("/{id}")
	private ResponseEntity<TelaDto> detalhesTela(@PathVariable Long id) throws NoContentException {
		TelaDto tela = TelaDto.converter(telaService.buscar(id));

		return ResponseEntity.ok(tela);
	}

	@PutMapping("/{id}")
	private ResponseEntity<TelaDto> alterar(@PathVariable Long id, @RequestBody @Valid TelaFormAtualizarDto telaForm) throws NoContentException {
		TelaDto tela = TelaDto.converter(telaService.atualizar(id, telaForm));

		return ResponseEntity.ok(tela);
	}

	@DeleteMapping("/{id}")
	private ResponseEntity<?> deletar(@PathVariable Long id) throws NoContentException, DeleteEntityWithDependentsException {
		telaService.deletar(id);

		return ResponseEntity.ok().build();
	}
}
