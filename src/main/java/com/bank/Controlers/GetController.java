package com.bank.Controlers;

import com.bank.DB.ED807Entity;
import com.bank.DTO.ru.cbr.ed.v2.ED807;
import com.bank.Service.ED807Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigInteger;
import java.util.List;

@RestController
@RequestMapping("/get")
public class GetController {
    @Autowired
    private ED807Service ed807Service;

    @GetMapping("/{name}")
    public ResponseEntity<List<ED807>> getALLByName(@PathVariable String name) {
        List<ED807> ed807List = ed807Service.getAllED807ByName(name);
        if (ed807List != null && !ed807List.isEmpty()) {
            return ResponseEntity.ok(ed807List);
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    @GetMapping("/all")
    public ResponseEntity<List<ED807>> getAllED807() {
        List<ED807> ed807List = ed807Service.getAllED807();
        return ResponseEntity.ok(ed807List);
    }
}

