package br.com.devschool.sistemaDocumentacao.aplication.controller.propriedade;

import java.util.List;

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

import br.com.devschool.sistemaDocumentacao.domain.internal.model.propriedade.dto.PropriedadeRequisicaoDto;
import br.com.devschool.sistemaDocumentacao.domain.internal.model.propriedade.form.AtualizacaoPropriedaddeRequisicaoForm;
import br.com.devschool.sistemaDocumentacao.domain.internal.model.propriedade.form.PropriedadeRequisicaoForm;
import br.com.devschool.sistemaDocumentacao.domain.internal.service.propriedade.PropriedadeService;

@RestController
@RequestMapping("/propriedades")
public class PropriedadeRequisicaoController {

    private PropriedadeService propriedadeService;

    @Autowired
    public PropriedadeRequisicaoController(PropriedadeService propriedadeService) {
        this.propriedadeService = propriedadeService;
    }

    @GetMapping
    public ResponseEntity<List<PropriedadeRequisicaoDto>> getAllProperties(@RequestParam(required = false) Long requisicaoId) {
        List<PropriedadeRequisicaoDto> propertiesDto = PropriedadeRequisicaoDto.covertList(propriedadeService.getAllProperties(requisicaoId));
        return ResponseEntity.ok(propertiesDto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PropriedadeRequisicaoDto> getPropertieByid(@PathVariable Long id) {
        PropriedadeRequisicaoDto propertieDto = new PropriedadeRequisicaoDto(propriedadeService.getPropertieById(id));
        return ResponseEntity.ok(propertieDto);
    }

    @PostMapping
    public ResponseEntity<PropriedadeRequisicaoDto> createPropertie(@RequestBody PropriedadeRequisicaoForm form) {
        PropriedadeRequisicaoDto propertieDto = new PropriedadeRequisicaoDto(propriedadeService.createPropertie(form));
        return ResponseEntity.ok(propertieDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PropriedadeRequisicaoDto> updatePropertie(@PathVariable Long id, @RequestBody AtualizacaoPropriedaddeRequisicaoForm form) {
        PropriedadeRequisicaoDto propertieDto = new PropriedadeRequisicaoDto(propriedadeService.updatePropertie(id, form));
        return ResponseEntity.ok(propertieDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePropertie(@PathVariable Long id) {
        propriedadeService.deletePropertie(id);
        return ResponseEntity.ok().build();
    }

}
