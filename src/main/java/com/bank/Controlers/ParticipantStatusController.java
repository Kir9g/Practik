package com.bank.Controlers;


import com.bank.DTO.Models.ParticipantStatusDTO;
import com.bank.DTO.Models.SrvcsDTO;
import com.bank.DTO.Models.XchTypeDTO;
import com.bank.Service.ParticipantStatusService;
import com.bank.Service.SrvcsService;
import com.bank.Service.XchTypeService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.List;

@RestController
@RequestMapping("/ParticipantStatus")
@Tag(name = "ParticipantStatusController", description = "Контроллер для управления справочником ParticipantStatus")
@SecurityRequirement(name = "basicAuth")
public class ParticipantStatusController {

    @Autowired
    private ParticipantStatusService service;

    @PostMapping
    public ResponseEntity<ParticipantStatusDTO> createSrvcs(@RequestBody ParticipantStatusDTO participantStatusDTO) {
        ParticipantStatusDTO created = service.create(participantStatusDTO);
        return ResponseEntity.ok(created);
    }

    @GetMapping
    public ResponseEntity<List<ParticipantStatusDTO>> getAll() {
        List<ParticipantStatusDTO> dtos = service.getAll();
        return ResponseEntity.ok(dtos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ParticipantStatusDTO> getById(@PathVariable BigInteger id) {
        ParticipantStatusDTO dto = service.getById(id);
        return ResponseEntity.ok(dto);
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<ParticipantStatusDTO> getXchByName(@PathVariable String name) {
        ParticipantStatusDTO dto = service.getByName(name);
        return ResponseEntity.ok(dto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ParticipantStatusDTO> updateSrvcs(@PathVariable BigInteger id, @RequestBody ParticipantStatusDTO dto) {
        ParticipantStatusDTO updated = service.update(id, dto);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSrvcs(@PathVariable BigInteger id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}