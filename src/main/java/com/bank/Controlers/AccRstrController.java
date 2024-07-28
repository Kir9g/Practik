package com.bank.Controlers;



import com.bank.DTO.Models.AccRstrDTO;
import com.bank.DTO.Models.ParticipantStatusDTO;
import com.bank.DTO.Models.SrvcsDTO;
import com.bank.DTO.Models.XchTypeDTO;
import com.bank.Service.AccRstrService;
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
@RequestMapping("/AccRstr")
@Tag(name = "AccRstrController", description = "Контроллер для управления справочником AccRstr")
@SecurityRequirement(name = "basicAuth")
public class AccRstrController {

    @Autowired
    private AccRstrService service;

    @PostMapping
    public ResponseEntity<AccRstrDTO> createSrvcs(@RequestBody AccRstrDTO accRstrDTO) {
        AccRstrDTO created = service.create(accRstrDTO);
        return ResponseEntity.ok(created);
    }

    @GetMapping
    public ResponseEntity<List<AccRstrDTO>> getAll() {
        List<AccRstrDTO> dtos = service.getAll();
        return ResponseEntity.ok(dtos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AccRstrDTO> getById(@PathVariable BigInteger id) {
        AccRstrDTO dto = service.getById(id);
        return ResponseEntity.ok(dto);
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<AccRstrDTO> getByName(@PathVariable String name) {
        AccRstrDTO dto = service.getByName(name);
        return ResponseEntity.ok(dto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AccRstrDTO> update(@PathVariable BigInteger id, @RequestBody AccRstrDTO dto) {
        AccRstrDTO updated = service.update(id, dto);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable BigInteger id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}