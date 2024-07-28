package com.bank.Controlers;


import com.bank.DTO.Models.SrvcsDTO;
import com.bank.Service.SrvcsService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.List;

@RestController
@RequestMapping("/Srvcs")
@Tag(name = "SrvcsController", description = "Контроллер для управления справочником Srvcs")
@SecurityRequirement(name = "basicAuth")
public class SrvcsController {

    @Autowired
    private SrvcsService srvcsService;

    @PostMapping
    public ResponseEntity<SrvcsDTO> createSrvcs(@RequestBody SrvcsDTO srvcsDTO) {
        SrvcsDTO created = srvcsService.createSrvcs(srvcsDTO);
        return ResponseEntity.ok(created);
    }

    @GetMapping
    public ResponseEntity<List<SrvcsDTO>> getAllSrvcs() {
        List<SrvcsDTO> srvcs = srvcsService.getAllSrvcs();
        return ResponseEntity.ok(srvcs);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SrvcsDTO> getSrvcsById(@PathVariable BigInteger id) {
        SrvcsDTO srvcs = srvcsService.getSrvcsById(id);
        return ResponseEntity.ok(srvcs);
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<SrvcsDTO> getSrvcsByName(@PathVariable Integer name) {
        SrvcsDTO srvcs = srvcsService.getSrvcsByName(name);
        return ResponseEntity.ok(srvcs);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SrvcsDTO> updateSrvcs(@PathVariable BigInteger id, @RequestBody SrvcsDTO srvcsDTO) {
        SrvcsDTO updated = srvcsService.updateSrvcs(id, srvcsDTO);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSrvcs(@PathVariable BigInteger id) {
        srvcsService.deleteSrvcs(id);
        return ResponseEntity.noContent().build();
    }
}