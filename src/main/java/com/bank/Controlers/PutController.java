package com.bank.Controlers;

import com.bank.DB.*;
import com.bank.DTO.ru.cbr.ed.v2.*;
import com.bank.Repository.AccountRepository;
import com.bank.Repository.ED807EntityRepository;
import com.bank.Service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    private AccRstrListService accRstrListService;
    @Autowired
    private InitialEDService initialEDService;
    @Autowired
    private ParticipantInfoService participantInfoService;

    @PutMapping("ed807/{id}")
    public ResponseEntity<ED807Entity> updateED807(@PathVariable(value = "id") BigInteger id,
                                                   @RequestBody ED807 ed807) {
        ED807Entity updatedED807Entity = ed807Service.updateED807(id, ed807);
        return ResponseEntity.ok(updatedED807Entity);
    }

    @PutMapping("bic/{id}")
    public ResponseEntity<ED807Entity> updateBIC(@PathVariable(value = "id") BigInteger id,
                                                 @RequestBody BICDirectoryEntryType bicDirectoryEntry) {
        BICDirectoryEntry bicDirectoryEntry1 = bicDirectoryService.updateBIC(id, bicDirectoryEntry);
        return ResponseEntity.ok(bicDirectoryEntry1.getEd807Entity());
    }

    @PutMapping("Account/{id}/{bic}")
    public ResponseEntity<ED807Entity> updateAccount(@PathVariable(value = "id") BigInteger id,
                                                     @RequestBody AccountsType accounts) {
        Accounts account = accountsService.updateAccount(id,accounts);
        return ResponseEntity.ok(account.getBicDirectoryEntry().getEd807Entity());
    }
    @PutMapping("AccRstrList/{id}")
    public ResponseEntity<ED807Entity> updateAccRstrList(@PathVariable(value = "id") BigInteger id,
                                                         @RequestBody AccRstrListType accRstrListEntity) {
        AccRstrListEntity accRstrList = accRstrListService.updateAccount(id,accRstrListEntity);
        return ResponseEntity.ok(accRstrList.getAccounts().getBicDirectoryEntry().getEd807Entity());
    }
    @PutMapping("InitialED/{id}")
    public ResponseEntity<InitialED> updateInitial(@PathVariable(value = "id") BigInteger id,
                                                   @RequestBody EDRefID edRefID){
        InitialED initialED1 = initialEDService.updateInitial(id, edRefID);
        return ResponseEntity.ok(initialED1);
    }
    @PutMapping("ParticipantInfo/{id}")
    public ResponseEntity<Void> updateParticipant(@PathVariable(value = "id") BigInteger id,
                                                   @RequestBody ParticipantInfoType participantInfoType){
        ParticipantInfoEntity participantInfoEntity = participantInfoService.updateParticipant(id, participantInfoType);
        if(participantInfoEntity != null) {
            return (ResponseEntity<Void>) ResponseEntity.ok();
        }else {
            return (ResponseEntity<Void>) ResponseEntity.badRequest();
        }
    }
}
