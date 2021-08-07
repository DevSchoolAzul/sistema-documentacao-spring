package br.com.devschool.sistemaDocumentacao.aplication.controller.propriedade;

import br.com.devschool.sistemaDocumentacao.domain.internal.model.propriedade.dto.PropriedadeRequisicaoDto;
import br.com.devschool.sistemaDocumentacao.domain.internal.model.propriedade.form.AtualizacaoPropriedaddeRequisicaoForm;
import br.com.devschool.sistemaDocumentacao.domain.internal.model.propriedade.form.PropriedadeRequisicaoForm;
import br.com.devschool.sistemaDocumentacao.domain.internal.service.propriedade.PropriedadeService;
import br.com.devschool.sistemaDocumentacao.infraestructure.exception.NoContentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/propriedades")
public class PropriedadeRequisicaoController {

    private PropriedadeService propriedadeService;

    @Autowired
    public PropriedadeRequisicaoController(PropriedadeService propriedadeService) {
        this.propriedadeService = propriedadeService;
    }

    @GetMapping
    public ResponseEntity<List<PropriedadeRequisicaoDto>> getAllProperties() {
        List<PropriedadeRequisicaoDto> propertiesDto = PropriedadeRequisicaoDto.covertList(propriedadeService.getAllProperties());
        return ResponseEntity.ok(propertiesDto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PropriedadeRequisicaoDto> getPropertieByid(@PathVariable Long id) throws NoContentException {
        PropriedadeRequisicaoDto propertieDto = new PropriedadeRequisicaoDto(propriedadeService.getPropertieById(id));
        return ResponseEntity.ok(propertieDto);
    }

    @PostMapping
    public ResponseEntity<PropriedadeRequisicaoDto> createPropertie(@RequestBody PropriedadeRequisicaoForm form) throws NoContentException {
        PropriedadeRequisicaoDto propertieDto = new PropriedadeRequisicaoDto(propriedadeService.createPropertie(form));
        return ResponseEntity.ok(propertieDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PropriedadeRequisicaoDto> updatePropertie(@PathVariable Long id, @RequestBody AtualizacaoPropriedaddeRequisicaoForm form) throws NoContentException {
        PropriedadeRequisicaoDto propertieDto = new PropriedadeRequisicaoDto(propriedadeService.updatePropertie(id, form));
        return ResponseEntity.ok(propertieDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePropertie(@PathVariable Long id) throws NoContentException {
        propriedadeService.deletePropertie(id);
        return ResponseEntity.ok().build();
    }

}
