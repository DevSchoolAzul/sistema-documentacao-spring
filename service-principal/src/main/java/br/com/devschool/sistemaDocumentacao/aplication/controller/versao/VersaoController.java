package br.com.devschool.sistemaDocumentacao.aplication.controller.versao;

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

import br.com.devschool.sistemaDocumentacao.domain.internal.model.versao.Versao;
import br.com.devschool.sistemaDocumentacao.domain.internal.model.versao.dto.VersaoDto;
import br.com.devschool.sistemaDocumentacao.domain.internal.model.versao.form.AtualizacaoVersaoForm;
import br.com.devschool.sistemaDocumentacao.domain.internal.model.versao.form.VersaoForm;
import br.com.devschool.sistemaDocumentacao.domain.internal.service.versao.VersaoService;

@RestController
@RequestMapping("/versoes")
public class VersaoController {

    private VersaoService versaoService;

    @Autowired
    public VersaoController(VersaoService versaoService) {
        this.versaoService = versaoService;
    }

    @GetMapping
    public ResponseEntity<List<VersaoDto>> getAllVersions(@RequestParam(required = false) Long projetoId) {
    	List<Versao> versions;
    	if (projetoId == null) {
    		versions = versaoService.getAllVersions();
    	} else {
    		versions = versaoService.getVersionsByProjectId(projetoId);
    	}
    	
        return ResponseEntity.ok(VersaoDto.convertList(versions));
    }

    @GetMapping("/{id}")
    public ResponseEntity<VersaoDto> getVersionById(@PathVariable Long id) {
        VersaoDto versionDto = new VersaoDto(versaoService.getVersionById(id));
        return ResponseEntity.ok(versionDto);
    }

    @PostMapping
    public ResponseEntity<VersaoDto> createVersion(@Valid @RequestBody VersaoForm form) {
        VersaoDto versionDto = new VersaoDto(versaoService.createVersion(form));
        return ResponseEntity.ok(versionDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<VersaoDto> updateProject(@PathVariable Long id, @Valid @RequestBody AtualizacaoVersaoForm form){
        VersaoDto versaoDto = new VersaoDto(versaoService.updateVersion(id, form));
        return ResponseEntity.ok(versaoDto);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteVersion(@PathVariable Long id) {
        versaoService.deleteVersion(id);
        return ResponseEntity.ok().build();
    }

}
