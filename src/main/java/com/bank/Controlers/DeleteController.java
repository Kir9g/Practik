package com.bank.Controlers;

import com.bank.DTO.ru.cbr.ed.v2.ED807;
import com.bank.Repository.ED807EntityRepository;
import com.bank.Service.ED807Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;



@RestController
@PreAuthorize("hasAuthority('ADMIN')")
@RequestMapping("/Delete")
public class DeleteController {

    @Autowired
    private ED807EntityRepository ed807EntityRepository;

    @Autowired
    private ED807Service ed807Service;

    @DeleteMapping("/ed807")
    public ResponseEntity<Void> deleteById(@RequestParam BigInteger id) {
        boolean isDeleted = ed807Service.deletByid(id);
        if (isDeleted) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/all")
    public ResponseEntity<Void> deleteAll() {
        boolean isDeleted = ed807Service.deleteAll();
        if (isDeleted) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.status(500).build();
        }
    }
    @DeleteMapping("/bic")
    public ResponseEntity<Void> deleteBICbyBIC(@RequestParam String BIC, @RequestParam BigInteger EDID){
        boolean isDeleted = ed807Service.deleteBicByBic(BIC,EDID);
        if (isDeleted) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.status(500).build();
        }
    }
}
