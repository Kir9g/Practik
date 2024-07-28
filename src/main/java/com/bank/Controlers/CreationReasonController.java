package com.bank.Controlers;

import com.bank.DTO.Models.CreationReasonDTO;
import com.bank.Repository.CreationReasonRepository;
import com.bank.Service.CreationReasonService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.List;

@RestController
@RequestMapping("/Reason")
@Tag(name = "CreationReasonController", description = "Контроллер для управления справочником CreationReason")
@SecurityRequirement(name = "basicAuth")
public class CreationReasonController {
    @Autowired
    private CreationReasonService creationReasonService;

    @PostMapping("/create")
    public ResponseEntity<CreationReasonDTO> createCreationReason(@RequestBody CreationReasonDTO creationReasonDTO) {
        CreationReasonDTO created = creationReasonService.createCreationReason(creationReasonDTO);
        return ResponseEntity.ok(created);
    }

    @GetMapping("/all")
    public ResponseEntity<List<CreationReasonDTO>> getAllCreationReasons() {
        List<CreationReasonDTO> creationReasons = creationReasonService.getAllCreationReasons();
        return ResponseEntity.ok(creationReasons);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CreationReasonDTO> getCreationReasonById(@PathVariable BigInteger id) {
        CreationReasonDTO creationReason = creationReasonService.getCreationReasonById(id);
        return ResponseEntity.ok(creationReason);
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<CreationReasonDTO> getCreationReasonByName(@PathVariable String name) {
        CreationReasonDTO creationReason = creationReasonService.getCreationReasonByName(name);
        return ResponseEntity.ok(creationReason);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CreationReasonDTO> updateCreationReason(@PathVariable BigInteger id, @RequestBody CreationReasonDTO creationReasonDTO) {
        CreationReasonDTO updated = creationReasonService.updateCreationReason(id, creationReasonDTO);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCreationReason(@PathVariable BigInteger id) {
        creationReasonService.deleteCreationReason(id);
        return ResponseEntity.noContent().build();
    }
}
