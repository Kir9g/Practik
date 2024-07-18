package com.bank.Controlers;

import com.bank.DB.Accounts;
import com.bank.DB.BICDirectoryEntry;
import com.bank.DB.ED807Entity;
import com.bank.Repository.AccountRepository;
import com.bank.Repository.ED807EntityRepository;
import com.bank.Service.BICDirectoryService;
import com.bank.Service.ED807Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.bank.Service.AccountsService;

import java.math.BigInteger;
import java.util.Optional;

@RestController
@RequestMapping("/Edit")
public class PutController {
    @Autowired
    private AccountsService accountsService;
    @Autowired
    private ED807Service ed807Service;
    @Autowired
    private BICDirectoryService bicDirectoryService;
    @Autowired
    private AccountsService AccountsService;

    @PutMapping("ed807/{id}")
    public ResponseEntity<ED807Entity> updateED807(@PathVariable(value = "id") BigInteger id,
                                                   @RequestBody ED807Entity ed807EntityDetails) {
        ED807Entity updatedED807Entity = ed807Service.updateED807(id, ed807EntityDetails);
        return ResponseEntity.ok(updatedED807Entity);
    }

    @PutMapping("bic/{id}")
    public ResponseEntity<ED807Entity> updateBIC(@PathVariable(value = "id") BigInteger id,
                                                 @RequestBody BICDirectoryEntry bicDirectoryEntry) {
        BICDirectoryEntry bicDirectoryEntry1 = bicDirectoryService.updateBIC(id, bicDirectoryEntry);
        return ResponseEntity.ok(bicDirectoryEntry1.getEd807Entity());
    }

    /*@PutMapping("Account/{id}/{bic}")
    public ResponseEntity<ED807Entity> updateAccount(@PathVariable(value = "id") BigInteger id,
                                                     @PathVariable(value = "bic") String bic,
                                                     @RequestBody Accounts accounts) {
        BICDirectoryEntry bicDirectoryEntry1 = AccountsService.updateACC(id,bic, accounts);
        return ResponseEntity.ok(bicDirectoryEntry1.getEd807Entity());
    }
*/
}
