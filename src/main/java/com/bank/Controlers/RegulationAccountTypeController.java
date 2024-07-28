package com.bank.Controlers;



import com.bank.DTO.Models.*;
import com.bank.Service.*;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.List;

@RestController
@RequestMapping("/RegulationAccountType")
@Tag(name = "RegulationAccountTypeController", description = "Контроллер для управления справочником RegulationAccountType")
@SecurityRequirement(name = "basicAuth")
public class RegulationAccountTypeController {

    @Autowired
    private RegulationAccountTypeSerivce service;

    @PostMapping
    public ResponseEntity<RegulationAccountTypeDTO> createSrvcs(@RequestBody RegulationAccountTypeDTO accRstrDTO) {
        RegulationAccountTypeDTO created = service.create(accRstrDTO);
        return ResponseEntity.ok(created);
    }

    @GetMapping
    public ResponseEntity<List<RegulationAccountTypeDTO>> getAll() {
        List<RegulationAccountTypeDTO> dtos = service.getAll();
        return ResponseEntity.ok(dtos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RegulationAccountTypeDTO> getById(@PathVariable BigInteger id) {
        RegulationAccountTypeDTO dto = service.getById(id);
        return ResponseEntity.ok(dto);
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<RegulationAccountTypeDTO> getByName(@PathVariable String name) {
        RegulationAccountTypeDTO dto = service.getByName(name);
        return ResponseEntity.ok(dto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<RegulationAccountTypeDTO> update(@PathVariable BigInteger id, @RequestBody RegulationAccountTypeDTO dto) {
        RegulationAccountTypeDTO updated = service.update(id, dto);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable BigInteger id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}