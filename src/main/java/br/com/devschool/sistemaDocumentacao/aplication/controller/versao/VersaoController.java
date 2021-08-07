package br.com.devschool.sistemaDocumentacao.aplication.controller.versao;

import br.com.devschool.sistemaDocumentacao.domain.internal.model.versao.dto.VersaoDto;
import br.com.devschool.sistemaDocumentacao.domain.internal.model.versao.form.AtualizacaoVersaoForm;
import br.com.devschool.sistemaDocumentacao.domain.internal.model.versao.form.VersaoForm;
import br.com.devschool.sistemaDocumentacao.domain.internal.service.versao.VersaoService;
import br.com.devschool.sistemaDocumentacao.infraestructure.exception.DeleteEntityWithDependentsException;
import br.com.devschool.sistemaDocumentacao.infraestructure.exception.NoContentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/versoes")
public class VersaoController {

    private VersaoService versaoService;

    @Autowired
    public VersaoController(VersaoService versaoService) {
        this.versaoService = versaoService;
    }

    @GetMapping
    public ResponseEntity<List<VersaoDto>> getAllVersions() throws NoContentException {
        List<VersaoDto> versionsDto = VersaoDto.convertList(versaoService.getAllVersions());
        return ResponseEntity.ok(versionsDto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<VersaoDto> getVersionById(@PathVariable Long id) throws NoContentException {
        VersaoDto versionDto = new VersaoDto(versaoService.getVersionById(id));
        return ResponseEntity.ok(versionDto);
    }

    @PostMapping
    public ResponseEntity<VersaoDto> createVersion(@Valid @RequestBody VersaoForm form) {
        VersaoDto versionDto = new VersaoDto(versaoService.createVersion(form));
        return ResponseEntity.ok(versionDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<VersaoDto> updateProject(@PathVariable Long id, @Valid @RequestBody AtualizacaoVersaoForm form) throws NoContentException {
        VersaoDto versaoDto = new VersaoDto(versaoService.updateVersion(id, form));
        return ResponseEntity.ok(versaoDto);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteVersion(@PathVariable Long id) throws DeleteEntityWithDependentsException, NoContentException {
        versaoService.deleteVersion(id);
        return ResponseEntity.ok().build();
    }

}
