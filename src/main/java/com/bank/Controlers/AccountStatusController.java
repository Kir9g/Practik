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
@RequestMapping("/AccountStatus")
@Tag(name = "AccountStatusController", description = "Контроллер для управления справочником AccountStatus")
@SecurityRequirement(name = "basicAuth")
public class AccountStatusController {

    @Autowired
    private AccountStatusService service;

    @PostMapping
    public ResponseEntity<AccountStatusDTO> createSrvcs(@RequestBody AccountStatusDTO accRstrDTO) {
        AccountStatusDTO created = service.create(accRstrDTO);
        return ResponseEntity.ok(created);
    }

    @GetMapping
    public ResponseEntity<List<AccountStatusDTO>> getAll() {
        List<AccountStatusDTO> dtos = service.getAll();
        return ResponseEntity.ok(dtos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AccountStatusDTO> getById(@PathVariable BigInteger id) {
        AccountStatusDTO dto = service.getById(id);
        return ResponseEntity.ok(dto);
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<AccountStatusDTO> getByName(@PathVariable String name) {
        AccountStatusDTO dto = service.getByName(name);
        return ResponseEntity.ok(dto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AccountStatusDTO> update(@PathVariable BigInteger id, @RequestBody AccountStatusDTO dto) {
        AccountStatusDTO updated = service.update(id, dto);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable BigInteger id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}