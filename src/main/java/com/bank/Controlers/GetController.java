package com.bank.Controlers;

import com.bank.DB.ED807Entity;
import com.bank.DTO.ru.cbr.ed.v2.ED807;
import com.bank.Service.ED807Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.Date;
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

    @GetMapping("/by-date-range")
    public ResponseEntity<List<ED807>> getAllBetweenDate(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date startDate,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date endDate){


        List<ED807> ed807List = ed807Service.getAllBetwenDate(startDate,endDate);
        if (ed807List != null && !ed807List.isEmpty()) {
            return ResponseEntity.ok(ed807List);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/by_id")
    public ResponseEntity<ED807> getById(@RequestParam BigInteger id){
        ED807 ed807 = ed807Service.getById(id);
        if(ed807 != null){
            return ResponseEntity.ok(ed807);
        }else {
            return ResponseEntity.notFound().build();
        }
    }

}

