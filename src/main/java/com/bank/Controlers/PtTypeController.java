package com.bank.Controlers;


import com.bank.DTO.Models.PtTypeDTO;
import com.bank.Service.PtTypeService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.List;

@RestController
@RequestMapping("/api/pt-types")
@Tag(name = "PtTypeController", description = "Контроллер для управления справочником PtType")
@SecurityRequirement(name = "basicAuth")
public class PtTypeController {

    @Autowired
    private PtTypeService ptTypeService;

    @PostMapping
    public ResponseEntity<PtTypeDTO> createPtType(@RequestBody PtTypeDTO ptTypeDTO) {
        PtTypeDTO created = ptTypeService.createPtType(ptTypeDTO);
        return ResponseEntity.ok(created);
    }

    @GetMapping
    public ResponseEntity<List<PtTypeDTO>> getAllPtTypes() {
        List<PtTypeDTO> ptTypes = ptTypeService.getAllPtTypes();
        return ResponseEntity.ok(ptTypes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PtTypeDTO> getPtTypeById(@PathVariable BigInteger id) {
        PtTypeDTO ptType = ptTypeService.getPtTypeById(id);
        return ResponseEntity.ok(ptType);
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<PtTypeDTO> getPtTypeByName(@PathVariable String name) {
        PtTypeDTO ptType = ptTypeService.getPtTypeByName(name);
        return ResponseEntity.ok(ptType);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PtTypeDTO> updatePtType(@PathVariable BigInteger id, @RequestBody PtTypeDTO ptTypeDTO) {
        PtTypeDTO updated = ptTypeService.updatePtType(id, ptTypeDTO);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePtType(@PathVariable BigInteger id) {
        ptTypeService.deletePtType(id);
        return ResponseEntity.noContent().build();
    }
}
