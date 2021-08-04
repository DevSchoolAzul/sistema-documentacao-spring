package br.com.devschool.sistemaDocumentacao.aplication.controller.versao;

import br.com.devschool.sistemaDocumentacao.domain.internal.model.projeto.Projeto;
import br.com.devschool.sistemaDocumentacao.domain.internal.model.projeto.dto.ProjetoDto;
import br.com.devschool.sistemaDocumentacao.domain.internal.model.projeto.form.AtualizacaoProjetoForm;
import br.com.devschool.sistemaDocumentacao.domain.internal.model.versao.Versao;
import br.com.devschool.sistemaDocumentacao.domain.internal.model.versao.dto.VersaoDto;
import br.com.devschool.sistemaDocumentacao.domain.internal.model.versao.form.AtualizacaoVersaoForm;
import br.com.devschool.sistemaDocumentacao.domain.internal.model.versao.form.VersaoForm;
import br.com.devschool.sistemaDocumentacao.domain.internal.service.projeto.ProjetoService;
import br.com.devschool.sistemaDocumentacao.domain.internal.service.versao.VersaoService;
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
@RequestMapping("/versoes")
public class VersaoController {

    @Autowired
    private VersaoService versaoService;

    @Autowired
    private ProjetoService projetoService;

    @GetMapping
    public ResponseEntity<List<VersaoDto>> getAllVersions() {
        List<Versao> versions = versaoService.getAllVersions();
        return ResponseEntity.ok(VersaoDto.convertList(versions));
    }

    @GetMapping("/{id}")
    public ResponseEntity<VersaoDto> getVersionById(@PathVariable Long id) {
        Optional<Versao> optionalVersion = versaoService.getVersionById(id);
        if(optionalVersion.isPresent()) {
            return ResponseEntity.ok(new VersaoDto(optionalVersion.get()));
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    @Transactional
    public ResponseEntity<VersaoDto> createVersion(@Valid @RequestBody VersaoForm form, UriComponentsBuilder uriBuilder) {
        Versao version = form.convertFormToEntity(projetoService);
        versaoService.save(version);

        URI uri = uriBuilder.path("/versoes/{id}").buildAndExpand(version.getId()).toUri();
        return ResponseEntity.created(uri).body(new VersaoDto(version));
    }

    @PutMapping("/{id}")
    public ResponseEntity<VersaoDto> updateProject(@PathVariable Long id, @Valid @RequestBody AtualizacaoVersaoForm form) {
        Optional<Versao> optionalVersion = versaoService.getVersionById(id);
        if(optionalVersion.isPresent()) {
            Versao version = form.convertFormToEntity(optionalVersion.get());
            versaoService.save(version);
            return ResponseEntity.ok(new VersaoDto(version));
        }
        return ResponseEntity.notFound().build();
    }


    @DeleteMapping("/{id}")
    public ResponseEntity deleteVersion(@PathVariable Long id) {
        versaoService.deleteVersion(id);
        return ResponseEntity.ok().build();
    }

}
