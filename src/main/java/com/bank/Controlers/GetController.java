package com.bank.Controlers;

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

    @GetMapping("/{id}")
    public ResponseEntity<ED807> getED807ById(@PathVariable BigInteger id) {
        ED807 ed807 = ed807Service.getED807ById(id);
        if (ed807 != null) {
            return ResponseEntity.ok(ed807);
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

