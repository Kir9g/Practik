package com.bank.Controlers;


import com.bank.DTO.Models.ChangeTypeDTO;
import com.bank.Service.ChangeTypeService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.List;

@RestController
@RequestMapping("/ChangeTypeController")
@Tag(name = "ChangeTypeController", description = "Контроллер для управления справочником ChangeTyp")
@SecurityRequirement(name = "basicAuth")
public class ChangeTypeController {

    @Autowired
    private ChangeTypeService changeTypeService;

    @PostMapping
    public ResponseEntity<ChangeTypeDTO> createChangeType(@RequestBody ChangeTypeDTO changeTypeDTO) {
        ChangeTypeDTO created = changeTypeService.createChangeType(changeTypeDTO);
        return ResponseEntity.ok(created);
    }

    @GetMapping
    public ResponseEntity<List<ChangeTypeDTO>> getAllChangeTypes() {
        List<ChangeTypeDTO> changeTypes = changeTypeService.getAllChangeTypes();
        return ResponseEntity.ok(changeTypes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ChangeTypeDTO> getChangeTypeById(@PathVariable BigInteger id) {
        ChangeTypeDTO changeType = changeTypeService.getChangeTypeById(id);
        return ResponseEntity.ok(changeType);
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<ChangeTypeDTO> getChangeTypeByName(@PathVariable String name) {
        ChangeTypeDTO changeType = changeTypeService.getChangeTypeByName(name);
        return ResponseEntity.ok(changeType);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ChangeTypeDTO> updateChangeType(@PathVariable BigInteger id, @RequestBody ChangeTypeDTO changeTypeDTO) {
        ChangeTypeDTO updated = changeTypeService.updateChangeType(id, changeTypeDTO);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteChangeType(@PathVariable BigInteger id) {
        changeTypeService.deleteChangeType(id);
        return ResponseEntity.noContent().build();
    }
}