package com.bank.Controlers;


import com.bank.DTO.Models.RstrDTO;
import com.bank.DTO.Models.SrvcsDTO;
import com.bank.DTO.Models.XchTypeDTO;
import com.bank.Service.RstrService;
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
@RequestMapping("/Rstr")
@Tag(name = "RstrController", description = "Контроллер для управления справочником Rstr")
@SecurityRequirement(name = "basicAuth")
public class RstrController {

    @Autowired
    private RstrService service;

    @PostMapping
    public ResponseEntity<RstrDTO> createSrvcs(@RequestBody RstrDTO dto) {
        RstrDTO created = service.createRstr(dto);
        return ResponseEntity.ok(created);
    }

    @GetMapping
    public ResponseEntity<List<RstrDTO>> getAllRstr() {
        List<RstrDTO> rstrDTOS = service.getRstrAll();
        return ResponseEntity.ok(rstrDTOS);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RstrDTO> getRstrById(@PathVariable BigInteger id) {
        RstrDTO rstrDTO = service.getRstrById(id);
        return ResponseEntity.ok(rstrDTO);
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<RstrDTO> getRstrByName(@PathVariable String name) {
        RstrDTO srvcs = service.getRstrByName(name);
        return ResponseEntity.ok(srvcs);
    }

    @PutMapping("/{id}")
    public ResponseEntity<RstrDTO> updateRstr(@PathVariable BigInteger id, @RequestBody RstrDTO dto) {
        RstrDTO updated = service.updateRstr(id, dto);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSrvcs(@PathVariable BigInteger id) {
        service.deleteRstr(id);
        return ResponseEntity.noContent().build();
    }
}