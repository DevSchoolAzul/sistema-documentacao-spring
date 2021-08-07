package br.com.devschool.sistemaDocumentacao.aplication.controller.projeto;

import br.com.devschool.sistemaDocumentacao.domain.internal.model.projeto.dto.ProjetoDto;
import br.com.devschool.sistemaDocumentacao.domain.internal.model.projeto.form.AtualizacaoProjetoForm;
import br.com.devschool.sistemaDocumentacao.domain.internal.model.projeto.form.ProjetoForm;
import br.com.devschool.sistemaDocumentacao.domain.internal.service.projeto.ProjetoService;
import br.com.devschool.sistemaDocumentacao.infraestructure.exception.DeleteEntityWithDependentsException;
import br.com.devschool.sistemaDocumentacao.infraestructure.exception.NoContentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/projetos")
public class ProjetoController {

    private ProjetoService projetoService;

    @Autowired
    public ProjetoController(ProjetoService projetoService) {
        this.projetoService = projetoService;
    }

    @GetMapping
    public ResponseEntity<List<ProjetoDto>> getAllProjects() throws NoContentException {
        List<ProjetoDto> projects = ProjetoDto.convertList(projetoService.getAllProjects());
        return ResponseEntity.ok(projects);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProjetoDto>  getProjectById(@PathVariable Long id) throws NoContentException {
        ProjetoDto projectDto = new ProjetoDto(projetoService.getProjectById(id));
        return ResponseEntity.ok(projectDto);
    }

    @PostMapping
    public ResponseEntity<ProjetoDto> createProject(@Valid @RequestBody ProjetoForm form) {
        ProjetoDto projectDto = new ProjetoDto(projetoService.createProject(form));
        return ResponseEntity.ok(projectDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProjetoDto> updateProject(@PathVariable Long id,@Valid @RequestBody AtualizacaoProjetoForm form) throws NoContentException {
        ProjetoDto projetoDto = new ProjetoDto(projetoService.updateProjectById(id, form));
        return ResponseEntity.ok(projetoDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteProject(@PathVariable Long id) throws DeleteEntityWithDependentsException, NoContentException {
        projetoService.deleteProject(id);
        return ResponseEntity.ok().build();
    }

}
