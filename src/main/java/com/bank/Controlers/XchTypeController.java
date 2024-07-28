package com.bank.Controlers;


import com.bank.DTO.Models.SrvcsDTO;
import com.bank.DTO.Models.XchTypeDTO;
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
@RequestMapping("/Xch")
@Tag(name = "XchTypeController", description = "Контроллер для управления справочником XchType")
@SecurityRequirement(name = "basicAuth")
public class XchTypeController {

    @Autowired
    private XchTypeService service;

    @PostMapping
    public ResponseEntity<XchTypeDTO> createSrvcs(@RequestBody XchTypeDTO xchTypeDTO) {
        XchTypeDTO created = service.createXch(xchTypeDTO);
        return ResponseEntity.ok(created);
    }

    @GetMapping
    public ResponseEntity<List<XchTypeDTO>> getAllXch() {
        List<XchTypeDTO> xchTypeDTOS = service.getAllXch();
        return ResponseEntity.ok(xchTypeDTOS);
    }

    @GetMapping("/{id}")
    public ResponseEntity<XchTypeDTO> getXchById(@PathVariable BigInteger id) {
        XchTypeDTO xchTypeDTO = service.getXchById(id);
        return ResponseEntity.ok(xchTypeDTO);
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<XchTypeDTO> getXchByName(@PathVariable Integer name) {
        XchTypeDTO srvcs = service.getXchByName(name);
        return ResponseEntity.ok(srvcs);
    }

    @PutMapping("/{id}")
    public ResponseEntity<XchTypeDTO> updateSrvcs(@PathVariable BigInteger id, @RequestBody XchTypeDTO dto) {
        XchTypeDTO updated = service.updateXch(id, dto);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSrvcs(@PathVariable BigInteger id) {
        service.deleteXch(id);
        return ResponseEntity.noContent().build();
    }
}