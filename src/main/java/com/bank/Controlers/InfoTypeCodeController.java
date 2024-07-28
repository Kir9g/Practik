package com.bank.Controlers;


import com.bank.DTO.Models.InfoTypeCodeDTO;
import com.bank.Service.InfoTypeCodeService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.List;

@RestController
@RequestMapping("/InfoTypeCode")
@Tag(name = "InfoTypeCodeController", description = "Контроллер для управления справочником InfoTypeCode")
@SecurityRequirement(name = "basicAuth")
public class InfoTypeCodeController {

    @Autowired
    private InfoTypeCodeService infoTypeCodeService;

    @PostMapping("/Create")
    public ResponseEntity<InfoTypeCodeDTO> createInfoTypeCode(@RequestBody InfoTypeCodeDTO infoTypeCodeDTO) {
        InfoTypeCodeDTO created = infoTypeCodeService.createInfoTypeCode(infoTypeCodeDTO);
        return ResponseEntity.ok(created);
    }

    @GetMapping("/all")
    public ResponseEntity<List<InfoTypeCodeDTO>> getAllInfoTypeCodes() {
        List<InfoTypeCodeDTO> infoTypeCodes = infoTypeCodeService.getAllInfoTypeCodes();
        return ResponseEntity.ok(infoTypeCodes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<InfoTypeCodeDTO> getInfoTypeCodeById(@PathVariable BigInteger id) {
        InfoTypeCodeDTO infoTypeCode = infoTypeCodeService.getInfoTypeCodeById(id);
        return ResponseEntity.ok(infoTypeCode);
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<InfoTypeCodeDTO> getInfoTypeCodeByName(@PathVariable String name) {
        InfoTypeCodeDTO infoTypeCode = infoTypeCodeService.getInfoTypeCodeByName(name);
        return ResponseEntity.ok(infoTypeCode);
    }

    @PutMapping("/{id}")
    public ResponseEntity<InfoTypeCodeDTO> updateInfoTypeCode(@PathVariable BigInteger id, @RequestBody InfoTypeCodeDTO infoTypeCodeDTO) {
        InfoTypeCodeDTO updated = infoTypeCodeService.updateInfoTypeCode(id, infoTypeCodeDTO);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteInfoTypeCode(@PathVariable BigInteger id) {
        infoTypeCodeService.deleteInfoTypeCode(id);
        return ResponseEntity.noContent().build();
    }
}