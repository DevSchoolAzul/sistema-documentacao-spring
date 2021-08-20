package br.com.devschool.sistemaDocumentacao.aplication.controller.projeto;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

import br.com.devschool.sistemaDocumentacao.domain.internal.model.projeto.Projeto;
import br.com.devschool.sistemaDocumentacao.domain.internal.model.projeto.dto.ProjetoDto;
import br.com.devschool.sistemaDocumentacao.domain.internal.model.projeto.form.AtualizacaoProjetoForm;
import br.com.devschool.sistemaDocumentacao.domain.internal.model.projeto.form.ProjetoForm;
import br.com.devschool.sistemaDocumentacao.domain.internal.service.projeto.ProjetoService;
import br.com.devschool.sistemaDocumentacao.infraestructure.exception.NoContentException;

@RestController
@RequestMapping("/projetos")
public class ProjetoController {

	private static final Logger logger = LoggerFactory.getLogger(ProjetoController.class);
	
    private ProjetoService projetoService;

    @Autowired
    public ProjetoController(ProjetoService projetoService) {
        this.projetoService = projetoService;
    }

    @GetMapping
    public ResponseEntity<List<ProjetoDto>> getAllProjects(@RequestParam(required = false, defaultValue = "") String nome, @RequestParam(required = false) Boolean situacao) {
    	List<Projeto> projects = projetoService.getProjects(nome, situacao);
    	
    	if (projects.isEmpty()) {
    		RuntimeException exception = new NoContentException("","","", "Nenhum projeto encontrado");
    		logger.info(exception.getMessage(), exception);
    		throw exception;
    	}
    	
    	logger.info("Requisicao para listar projetos. [nome = {}, situacao = {}]", nome, situacao);
        return ResponseEntity.ok(ProjetoDto.convertList(projects));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProjetoDto>  getProjectById(@PathVariable Long id) {
        ProjetoDto projectDto = new ProjetoDto(projetoService.getProjectById(id));
        
        logger.info("Requisicao para buscar um projeto pelo id. [id = {}]", id);
        return ResponseEntity.ok(projectDto);
    }

    @PostMapping
    public ResponseEntity<ProjetoDto> createProject(@Valid @RequestBody ProjetoForm form) {
        ProjetoDto projectDto = new ProjetoDto(projetoService.createProject(form));
        
        logger.info("Requisicao para criar um novo projeto. [Valores = {}]", form);
        return ResponseEntity.ok(projectDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProjetoDto> updateProject(@PathVariable Long id,@Valid @RequestBody AtualizacaoProjetoForm form)  {
        ProjetoDto projetoDto = new ProjetoDto(projetoService.updateProjectById(id, form));
        
        logger.info("Requisicao para atualizar um projeto. [id do projeto = {}, novos valores = {}]", id, form);
        return ResponseEntity.ok(projetoDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteProject(@PathVariable Long id) {
        projetoService.deleteProject(id);
        
        logger.info("Requisição para deletar um projeto. [id = {}]", id);
        return ResponseEntity.ok().build();
    }

}
