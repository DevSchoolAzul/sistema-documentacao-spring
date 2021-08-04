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
import org.springframework.web.bind.annotation.RestController;

import br.com.devschool.sistemaDocumentacao.domain.internal.dto.tela.TelaDto;
import br.com.devschool.sistemaDocumentacao.domain.internal.dto.tela.TelaFormAtualizarDto;
import br.com.devschool.sistemaDocumentacao.domain.internal.dto.tela.TelaFormCadastrarDto;
import br.com.devschool.sistemaDocumentacao.domain.internal.model.tela.Tela;
import br.com.devschool.sistemaDocumentacao.domain.internal.service.tela.TelaService;

@RestController
@RequestMapping("/telas")
public class TelaController {

	@Autowired
	private TelaService telaService;

	@GetMapping
	public ResponseEntity<List<TelaDto>> listar() {
		List<Tela> telas = telaService.listar();
		return ResponseEntity.ok(TelaDto.converter(telas));
	}

	@PostMapping
	public ResponseEntity<TelaDto> novaTela(@RequestBody @Valid TelaFormCadastrarDto telaForm) {
		TelaDto tela = TelaDto.converter(telaService.cadastrar(telaForm));
		return ResponseEntity.ok(tela);
	}

	@GetMapping("/{id}")
	private ResponseEntity<TelaDto> detalhesTela(@PathVariable Long id) {
		TelaDto tela = TelaDto.converter(telaService.buscar(id));

		return ResponseEntity.ok(tela);
	}

	@PutMapping("/{id}")
	private ResponseEntity<TelaDto> alterar(@PathVariable Long id, @RequestBody @Valid TelaFormAtualizarDto telaForm) {
		TelaDto tela = TelaDto.converter(telaService.atualizar(id, telaForm));

		return ResponseEntity.ok(tela);
	}

	@DeleteMapping("/{id}")
	private ResponseEntity<?> deletar(@PathVariable Long id) {
		telaService.deletar(id);

		return ResponseEntity.ok().build();
	}
}
