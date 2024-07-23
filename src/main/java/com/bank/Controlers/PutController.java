package com.bank.Controlers;

import com.bank.DB.*;
import com.bank.DTO.ru.cbr.ed.v2.*;
import com.bank.Repository.AccountRepository;
import com.bank.Repository.ED807EntityRepository;
import com.bank.Service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.Optional;

@RestController
@RequestMapping("/Edit")
@PreAuthorize("hasAuthority('USER')")
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
    @Autowired
    private PartInfoSerivce partInfoSerivce;
    @Autowired
    private SWBICSService swbicsService;
    @Autowired
    private RstrListService rstrListService;
    @Autowired
    private ED807EntityRepository ed807EntityRepository;


    @PutMapping("ed807/{id}")
    public ResponseEntity<ED807> updateED807(@PathVariable(value = "id") BigInteger id,
                                                   @RequestBody ED807 ed807) {
        ED807 ed807Entity = ed807Service.updateED807(id, ed807);

        return ResponseEntity.ok(ed807Entity);
    }

    @PutMapping("bic/{id}")
    public ResponseEntity<BICDirectoryEntryType> updateBIC(@PathVariable(value = "id") BigInteger id,
                                                 @RequestBody BICDirectoryEntryType bicDirectoryEntry) {
        BICDirectoryEntry bicDirectoryEntry1 = bicDirectoryService.updateBIC(id, bicDirectoryEntry);
        BICDirectoryEntryType bicDirectoryEntryType = ed807Service.convertToDTO(bicDirectoryEntry1);
        return ResponseEntity.ok(bicDirectoryEntryType);
    }

    @PutMapping("Account/{id}")
    public ResponseEntity<AccountsType> updateAccount(@PathVariable(value = "id") BigInteger id,
                                                     @RequestBody AccountsType accounts) throws Exception {
        Accounts account = accountsService.updateAccount(id,accounts);
        AccountsType accountsType = ed807Service.convertToDTO(account);
        return ResponseEntity.ok(accountsType);
    }
    @PutMapping("AccRstrList/{id}")
    public ResponseEntity<AccRstrListType> updateAccRstrList(@PathVariable(value = "id") BigInteger id,
                                                         @RequestBody AccRstrListType accRstrListEntity) {
        AccRstrListEntity accRstrList = accRstrListService.updateAccount(id,accRstrListEntity);
        AccRstrListType AccRstrListType = ed807Service.convertToDTO(accRstrList);
        return ResponseEntity.ok(AccRstrListType);
    }
    @PutMapping("InitialED/{id}")
    public ResponseEntity<ED807> updateInitial(@PathVariable(value = "id") BigInteger id,
                                                   @RequestBody EDRefID edRefID){
        InitialED initialED1 = initialEDService.updateInitial(id, edRefID);
        Optional<ED807Entity> ed807Entity = ed807EntityRepository.findByInitialED(initialED1);
        if(ed807Entity.isPresent()){
            ED807Entity entity = ed807Entity.get();
            ED807 ed807 = ed807Service.convertToDTO(entity);
            return ResponseEntity.ok(ed807);
        }
        return ResponseEntity.notFound().build();
    }
    @PutMapping("ParticipantInfo/{id}")
    public ResponseEntity<ParticipantInfoType> updateParticipant(@PathVariable(value = "id") BigInteger id,
                                                   @RequestBody ParticipantInfoType participantInfoType){
        ParticipantInfoEntity participantInfoEntity = participantInfoService.updateParticipant(id, participantInfoType);
        if(participantInfoEntity != null) {
            ParticipantInfoType participantInfoType1 = ed807Service.convertToDTO(participantInfoEntity);
            return ResponseEntity.ok(participantInfoType1);
        }else {
            return ResponseEntity.notFound().build();
        }
    }
    @PutMapping("PartInfo/{id}")
    public ResponseEntity<ED807> updatePartInfo(@PathVariable(value = "id") BigInteger id,
                                                   @RequestBody PartInfo partInfo){
        ED807Entity entity = partInfoSerivce.updatePartInfo(id,partInfo);
        if(entity!=null) {
            ED807 ed807 = ed807Service.convertToDTO(entity);
            return ResponseEntity.ok(ed807);
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }
    @PutMapping("SWIC/{id}")
    public ResponseEntity<SWBICList> partialUpdateSWBIC(@PathVariable BigInteger id, @RequestBody SWBICList updateDTO) {
        SWBICSEntity updatedEntity = swbicsService.updateSwbic(id,updateDTO);
        if (updatedEntity != null) {
            SWBICList swbicList = ed807Service.convertToDTO(updatedEntity);
            return ResponseEntity.ok(swbicList);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @PutMapping("RstrList/{id}")
    public ResponseEntity<RstrListType> updateRstr(@PathVariable(value = "id") BigInteger id,
                                                         @RequestBody RstrListType rstrListType){
        RstrListEntity rstrListEntity = rstrListService.updateRstr(id,rstrListType);
        if(rstrListEntity!=null) {
            RstrListType rstrListType1 = ed807Service.convertToDTO(rstrListEntity);
            return ResponseEntity.ok(rstrListType1);
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }
}
