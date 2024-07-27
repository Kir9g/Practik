package com.bank.Controlers;

import com.bank.DB.*;
import com.bank.DTO.Models.*;
import com.bank.DTO.ru.cbr.ed.v2.*;
import com.bank.Repository.AccountRepository;
import com.bank.Repository.ED807EntityRepository;
import com.bank.Service.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.Optional;

@RestController
@RequestMapping("/Edit")
@Tag(name = "PutController", description = "Контроллер для обновленния уже созданных сущностей в бд")
@SecurityRequirement(name = "basicAuth")
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
    @Operation(
            summary = "Обновление ed807",
            description = "Позволяет обновлять ed807 по id который передается, и по полям который передал пользователь"
    )
    public ResponseEntity<ED807DTO> updateED807(@Parameter(description = "Идентификатор ED807, который надо обновить")@PathVariable(value = "id") BigInteger id,
                                             @Parameter(description = "Поля которые надо обновить")@RequestBody ED807 ed807) {
        ED807DTO ed807Entity = ed807Service.updateED807(id, ed807);

        return ResponseEntity.ok(ed807Entity);
    }
    @Operation(
            summary = "Обновление bic",
            description = "Позволяет обновлять bic по id который передается, и по полям который передал пользователь"
    )
    @PutMapping("bic/{id}")
    public ResponseEntity<BicDirectoryDTO> updateBIC(@Parameter(description = "Идентификатор bic, который надо обновить")@PathVariable(value = "id") BigInteger id,
                                                     @Parameter(description = "Поля которые надо обновить")@RequestBody BicDirectoryDTO bicDirectoryDTO) {
        BICDirectoryEntry bicDirectoryEntry1 = bicDirectoryService.updateBIC(id, bicDirectoryDTO);
        BicDirectoryDTO bicDirectoryEntryType = ed807Service.convertToDTO(bicDirectoryEntry1);
        return ResponseEntity.ok(bicDirectoryEntryType);
    }
    @Operation(
            summary = "Обновление Account",
            description = "Позволяет обновлять Account по id который передается, и по полям который передал пользователь"
    )
    @PutMapping("Account/{id}")
    public ResponseEntity<AccountsDTO> updateAccount(@Parameter(description = "Идентификатор Account, который надо обновить")@PathVariable(value = "id") BigInteger id,
                                                      @Parameter(description = "Поля которые надо обновить")@RequestBody AccountsDTO accounts) throws Exception {
        Accounts account = accountsService.updateAccount(id,accounts);
        AccountsDTO accountsType = ed807Service.convertToDTO(account);
        return ResponseEntity.ok(accountsType);
    }
    @PutMapping("AccRstrList/{id}")
    @Operation(
            summary = "Обновление AccRstrLis",
            description = "Позволяет обновлять AccRstrLis по id который передается, и по полям который передал пользователь"
    )
    public ResponseEntity<AccRstrListDTO> updateAccRstrList(@Parameter(description = "Идентификатор AccRstrLis, который надо обновить")@PathVariable(value = "id") BigInteger id,
                                                             @Parameter(description = "Поля которые надо обновить")@RequestBody AccRstrListDTO accRstrListDTO) {
        AccRstrListEntity accRstrList = accRstrListService.updateAccount(id,accRstrListDTO);
        AccRstrListDTO AccRstrListType = ed807Service.convertToDTO(accRstrList);
        return ResponseEntity.ok(AccRstrListType);
    }
    @PutMapping("InitialED/{id}")
    @Operation(
            summary = "Обновление InitialED",
            description = "Позволяет обновлять InitialED по id который передается, и по полям который передал пользователь"
    )
    public ResponseEntity<ED807DTO> updateInitial(@Parameter(description = "Идентификатор ED807, у которого надо обновить Initial")@PathVariable(value = "id") BigInteger id,
                                               @Parameter(description = "Поля которые надо обновить")@RequestBody InitialEDDTO initialEDDTO) throws Exception {
        Optional<ED807Entity> ed807 = ed807EntityRepository.findById(id);
        if( ed807!= null) {
            if(ed807.get().getInitialED()!= null) {
                InitialED initialED1 = initialEDService.updateInitial(id, initialEDDTO);
                if (initialED1 != null) {
                    Optional<ED807Entity> ed807Entity = ed807EntityRepository.findByInitialED(initialED1);
                    if (ed807Entity.isPresent()) {
                        ED807Entity entity = ed807Entity.get();
                        ED807DTO ed8071 = ed807Service.convertToDTO(entity);
                        return ResponseEntity.ok(ed8071);
                    }
                    return ResponseEntity.notFound().build();
                } else {
                    return ResponseEntity.notFound().build();
                }
            }else {
                return ResponseEntity.notFound().build();
            }
        }else {
            return ResponseEntity.notFound().build();
        }
    }
    @PutMapping("ParticipantInfo/{id}")
    @Operation(
            summary = "Обновление ParticipantInfo",
            description = "Позволяет обновлять ParticipantInfo по id который передается, и по полям который передал пользователь"
    )
    public ResponseEntity<ParticipantInfoDTO> updateParticipant(@Parameter(description = "Идентификатор ParticipantInfo, который надо обновить")@PathVariable(value = "id") BigInteger id,
                                                                 @Parameter(description = "Поля которые надо обновить")@RequestBody ParticipantInfoDTO participantInfoDTO){
        ParticipantInfoEntity participantInfoEntity = participantInfoService.updateParticipant(id, participantInfoDTO);
        if(participantInfoEntity != null) {
            ParticipantInfoDTO participantInfoType1 = ed807Service.convertToDTO(participantInfoEntity);
            return ResponseEntity.ok(participantInfoType1);
        }else {
            return ResponseEntity.notFound().build();
        }
    }
    @PutMapping("PartInfo/{id}")
    @Operation(
            summary = "Обновление PartInfo",
            description = "Позволяет обновлять PartInfo по id у ED807 который передается, и по полям который передал пользователь"
    )
    public ResponseEntity<ED807DTO> updatePartInfo(@Parameter(description = "Идентификатор Ed807, который надо обновить")@PathVariable(value = "id") BigInteger id,
                                                @Parameter(description = "Поля которые надо обновить")@RequestBody PartInfo partInfo){
        Optional<ED807Entity> entity = ed807EntityRepository.findById(id);
        if(entity.get()!= null) {
            if (entity.get().getPartInfoEntity()!= null) {
                ED807Entity ed807Entity = partInfoSerivce.updatePartInfo(entity.get(), partInfo);
                if (ed807Entity != null) {
                    ED807DTO ed807 = ed807Service.convertToDTO(ed807Entity);
                    return ResponseEntity.ok(ed807);
                } else {
                    return ResponseEntity.notFound().build();
                }
            }else {
                return ResponseEntity.notFound().build();
            }
        }else {
            return ResponseEntity.notFound().build();}
    }
    @PutMapping("SWIC/{id}")
    @Operation(
            summary = "Обновление SWBIC",
            description = "Позволяет обновлять SWBIC по id который передается, и по полям который передал пользователь"
    )
    public ResponseEntity<SWBICSDTO> partialUpdateSWBIC(@Parameter(description = "Идентификатор SWBIC, который надо обновить")@PathVariable BigInteger id,
                                                        @Parameter(description = "Поля которые надо обновить")@RequestBody SWBICList updateDTO) {
        SWBICSEntity updatedEntity = swbicsService.updateSwbic(id,updateDTO);
        if (updatedEntity != null) {
            SWBICSDTO swbicList = ed807Service.convertToDTO(updatedEntity);
            return ResponseEntity.ok(swbicList);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @PutMapping("RstrList/{id}")
    @Operation(
            summary = "Обновление RstrList",
            description = "Позволяет обновлять RstrList по id который передается, и по полям который передал пользователь"
    )
    public ResponseEntity<RstrListDTO> updateRstr(@Parameter(description = "Идентификатор RstrList, который надо обновить")@PathVariable(value = "id") BigInteger id,
                                                   @Parameter(description = "Поля которые надо обновить")@RequestBody RstrListDTO rstrListDTO){
        RstrListEntity rstrListEntity = rstrListService.updateRstr(id,rstrListDTO);
        if(rstrListEntity!=null) {
            RstrListDTO rstrListType1 = ed807Service.convertToDTO(rstrListEntity);
            return ResponseEntity.ok(rstrListType1);
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }
}
