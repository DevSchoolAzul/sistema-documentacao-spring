package br.com.devschool.sistemaDocumentacao.aplication.controller.projeto;

import br.com.devschool.sistemaDocumentacao.domain.internal.model.projeto.Projeto;
import br.com.devschool.sistemaDocumentacao.domain.internal.model.projeto.dto.ProjetoDto;
import br.com.devschool.sistemaDocumentacao.domain.internal.model.projeto.form.AtualizacaoProjetoForm;
import br.com.devschool.sistemaDocumentacao.domain.internal.model.projeto.form.ProjetoForm;
import br.com.devschool.sistemaDocumentacao.domain.internal.service.projeto.ProjetoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/projetos")
public class ProjetoController {

    @Autowired
    private ProjetoService projetoService;

    @GetMapping
    public ResponseEntity<List<ProjetoDto>> getAllProjects() {
        List<Projeto> projects = projetoService.getAllProjects();
        return ResponseEntity.ok(ProjetoDto.convertList(projects));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProjetoDto>  getProjectById(@PathVariable Long id) {
        Optional<Projeto> optionalProject = projetoService.getProjectById(id);
        if(optionalProject.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(new ProjetoDto(optionalProject.get()));
    }

    @PostMapping
    @Transactional
    public ResponseEntity<ProjetoDto> createProject(@Valid @RequestBody ProjetoForm form, UriComponentsBuilder uriBuilder) {
        Projeto project = form.convertFormToEntity();
        projetoService.save(project);

        URI uri = uriBuilder.path("/projetos/{id}").buildAndExpand(project.getId()).toUri();
        return ResponseEntity.created(uri).body(new ProjetoDto(project));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProjetoDto> updateProject(@PathVariable Long id,@Valid @RequestBody AtualizacaoProjetoForm form) {
        Optional<Projeto> optionalProjeto = projetoService.getProjectById(id);
        if(optionalProjeto.isPresent()) {
            Projeto project = form.convertFormToEntity(optionalProjeto.get());
            projetoService.save(project);
            return ResponseEntity.ok(new ProjetoDto(project));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteProject(@PathVariable Long id) {
        projetoService.deleteProject(id);
        return ResponseEntity.ok().build();
    }

}
