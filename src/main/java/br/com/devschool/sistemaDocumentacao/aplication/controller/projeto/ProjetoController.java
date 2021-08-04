package br.com.devschool.sistemaDocumentacao.aplication.controller.projeto;

import br.com.devschool.sistemaDocumentacao.domain.internal.model.projeto.Projeto;
import br.com.devschool.sistemaDocumentacao.domain.internal.model.projeto.dto.ProjetoDto;
import br.com.devschool.sistemaDocumentacao.domain.internal.service.projeto.ProjetoService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/projetos")
public class ProjetoController {

    @Autowired
    private ProjetoService projetoService;

    @GetMapping
    public ResponseEntity<List<Projeto>> getAllProjects() {
        return ResponseEntity.ok(projetoService.getAllProjects());
    }

    @PostMapping
    @Transactional
    public ResponseEntity<ProjetoDto> createProject(@RequestBody ProjetoDto dto) {
        Projeto project = dto.convertDtoToEntity();
        projetoService.createProject(project);

        return ResponseEntity.ok(new ProjetoDto(project));
    }

}
