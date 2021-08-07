package br.com.devschool.sistemaDocumentacao.aplication.controller.requisicao;

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

import br.com.devschool.sistemaDocumentacao.domain.internal.model.requisicao.Requisicao;
import br.com.devschool.sistemaDocumentacao.domain.internal.model.requisicao.dto.RequisicaoDto;
import br.com.devschool.sistemaDocumentacao.domain.internal.model.requisicao.form.RequisicaoAlterarForm;
import br.com.devschool.sistemaDocumentacao.domain.internal.model.requisicao.form.RequisicaoCadastrarForm;
import br.com.devschool.sistemaDocumentacao.domain.internal.service.evento.EventoService;
import br.com.devschool.sistemaDocumentacao.domain.internal.service.requisicao.RequisicaoService;
import br.com.devschool.sistemaDocumentacao.infraestructure.exception.DeleteEntityWithDependentsException;
import br.com.devschool.sistemaDocumentacao.infraestructure.exception.NoContentException;



@RestController
@RequestMapping("/requisicoes")
public class RequisicaoController {
	
	@Autowired
	private RequisicaoService requisicaoService;
	@Autowired
	private EventoService eventoService;
	
	@GetMapping
	public ResponseEntity<List<RequisicaoDto>> listar(@RequestParam(name = "idEvento", required = false) Long idEvento) throws NoContentException {
		List<Requisicao> requisicoes = requisicaoService.listar(idEvento);
		if (requisicoes.isEmpty()) {
			throw new NoContentException("Nenhuma requisicao cadastrada para este evento.");
		}
		return ResponseEntity.ok(RequisicaoDto.converter(requisicoes));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<RequisicaoDto> detalhes(@PathVariable Long id) throws NoContentException {
		Requisicao requisicao = requisicaoService.buscar(id);
		return ResponseEntity.ok(new RequisicaoDto(requisicao));
	}
	
	@PostMapping
	public ResponseEntity<RequisicaoDto> novo(@RequestBody @Valid RequisicaoCadastrarForm requisicaoForm) throws NoContentException {
		Requisicao requisicao = requisicaoService.cadastrar(requisicaoForm.toRequisicao(eventoService, requisicaoService));
		return ResponseEntity.ok(new RequisicaoDto(requisicao));
	
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<RequisicaoDto> alterar(@PathVariable Long id, @RequestBody RequisicaoAlterarForm requisicaoForm) throws NoContentException {
		Requisicao requisicao = requisicaoService.alterar(id, requisicaoForm);
		return ResponseEntity.ok(new RequisicaoDto(requisicao));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> excluir(@PathVariable Long id) throws NoContentException, DeleteEntityWithDependentsException {
		requisicaoService.excluir(id);
		return ResponseEntity.ok().build();
	}
}
