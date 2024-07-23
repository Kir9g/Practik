package com.bank.Controlers;

import com.bank.DB.*;
import com.bank.DTO.ru.cbr.ed.v2.*;
import com.bank.Repository.*;
import com.bank.Service.*;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/ED807")
public class PostController {
    @Autowired
    private ED807Service ed807Service;
    @Autowired
    private BICDirectoryService bicDirectoryService;
    @Autowired
    private BICDirectoryEntity bicDirectoryEntity;
    @Autowired
    private ED807EntityRepository entityRepository;
    @Autowired
    private AccountsService accountsService;
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
    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private InitialEDRepository initialEDRepository;
    @Autowired
    private ParticipantInfoRepository participantInfoRepository;



    @Value("${file.upload-dir}")
    private String uploadDir;
    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping(value = "/upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<?> uploadFile(@RequestParam("file") MultipartFile file,
                                        @RequestParam(required = false) String name) {
        if (file.isEmpty()) {
            return new ResponseEntity<>("File is empty", HttpStatus.BAD_REQUEST);
        }

        try (InputStream inputStream = file.getInputStream()) {

            String filePath = uploadDir +file.getOriginalFilename();
            File destFile = new File(filePath);
            file.transferTo(destFile);

            JAXBContext jaxb2Context = JAXBContext.newInstance(ED807.class);
            Unmarshaller unmarshaller = jaxb2Context.createUnmarshaller();
            JAXBElement<ED807> root = (JAXBElement<ED807>) unmarshaller.unmarshal(inputStream);
            ED807 ed807 = root.getValue();

            ed807.setFilePath(filePath);
            List<BICDirectoryEntryType> bicDirectoryEntryTypes = ed807.getBICDirectoryEntry();
            if(name == null){
                name = file.getOriginalFilename();
                ed807.setName(name);
            }
            ed807.setName(name);
            Date date = new Date();
            ed807.setCreationDate(date);
            ed807Service.saveED807(ed807);

            return new ResponseEntity<>(ed807, HttpStatus.OK);
        } catch (IOException | JAXBException e) {
            e.printStackTrace();
            return new ResponseEntity<>("Error processing file", HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @PreAuthorize("hasAuthority('USER')")
    @PostMapping("Create/BIC/{id}")
    public ResponseEntity<BICDirectoryEntryType> createBic(@PathVariable(value = "id") BigInteger id,
                                                           @RequestBody BICDirectoryEntryType bicDirectoryEntryType){
        Optional<ED807Entity> entity = entityRepository.findById(id);//id от ed807
        if(entity.isPresent()){
            BICDirectoryEntry bicDirectoryEntry = bicDirectoryService.createBIC(entity.get(),bicDirectoryEntryType);
            BICDirectoryEntryType bicDirectoryEntryType1 = ed807Service.convertToDTO(bicDirectoryEntry);
            return ResponseEntity.ok(bicDirectoryEntryType1);
        }else {
            return ResponseEntity.notFound().build();
        }
    }
    @PreAuthorize("hasAuthority('USER')")
    @PostMapping("Create/Account/{id}")
    public ResponseEntity<AccountsType> createAccount(@PathVariable(value = "id") BigInteger id,
                                                           @RequestBody AccountsType accountsType) throws Exception {
        Optional<BICDirectoryEntry> entity = bicDirectoryEntity.findById(id);//id от BIC
        if(entity.isPresent()){
            Accounts accounts = accountsService.createAcc(entity.get(),accountsType);
            AccountsType accounts1 = ed807Service.convertToDTO(accounts);
            return ResponseEntity.ok(accounts1);
        }else {
            return ResponseEntity.notFound().build();
        }
    }
    @PreAuthorize("hasAuthority('USER')")
    @PostMapping("Create/AccRstr/{id}")
    public ResponseEntity<AccRstrListType> createAccRstr(@PathVariable(value = "id") BigInteger id,
                                                      @RequestBody AccRstrListType accRstrListType){
        Optional<Accounts> entity = accountRepository.findById(id);//id от BIC
        if(entity.isPresent()){
            AccRstrListEntity accounts = accRstrListService.createAcc(entity.get(),accRstrListType);
            AccRstrListType accounts1 = ed807Service.convertToDTO(accounts);
            return ResponseEntity.ok(accounts1);
        }else {
            return ResponseEntity.notFound().build();
        }
    }
    @PreAuthorize("hasAuthority('USER')")
    @PostMapping("Create/InitialED/{id}")
    public ResponseEntity<ED807> createInitial(@PathVariable(value = "id") BigInteger id,
                                                         @RequestBody InitialEDInfo initialEDInfo){
        Optional<ED807Entity> entity = ed807EntityRepository.findById(id);//id от BIC
        if(entity.isPresent()){
            InitialED accounts = initialEDService.createInitial(entity.get(),initialEDInfo);
            ED807 ed807 = ed807Service.convertToDTO(entity.get());
            return ResponseEntity.ok(ed807);
        }else {
            return ResponseEntity.notFound().build();
        }
    }
    @PreAuthorize("hasAuthority('USER')")
    @PostMapping("Create/PartInfo/{id}")
    public ResponseEntity<ED807> createPartInfo(@PathVariable(value = "id") BigInteger id,
                                               @RequestBody PartInfo partInfo){
        Optional<ED807Entity> entity = ed807EntityRepository.findById(id);//id от BIC
        if(entity.isPresent()){
            PartInfoEntity partInfoEntity = partInfoSerivce.createPart(entity.get(),partInfo);
            ED807 ed807 = ed807Service.convertToDTO(entity.get());
            return ResponseEntity.ok(ed807);
        }else {
            return ResponseEntity.notFound().build();
        }
    }
    @PreAuthorize("hasAuthority('USER')")
    @PostMapping("Create/ParticipantInfo/{id}")
    public ResponseEntity<BICDirectoryEntryType> createPartInfo(@PathVariable(value = "id") BigInteger id,
                                                @RequestBody ParticipantInfoType participantInfoType){
        Optional<BICDirectoryEntry> entity = bicDirectoryEntity.findById(id);//id от BIC
        if(entity.isPresent()){
            ParticipantInfoType participantInfoType1 = participantInfoService.createPart(entity.get(),participantInfoType);
            BICDirectoryEntryType bicDirectoryEntryType = ed807Service.convertToDTO(entity.get());
            return ResponseEntity.ok(bicDirectoryEntryType);
        }else {
            return ResponseEntity.notFound().build();
        }
    }
    @PreAuthorize("hasAuthority('USER')")
    @PostMapping("Create/Rstr/{id}")
    public ResponseEntity<RstrListType> createRstr(@PathVariable(value = "id") BigInteger id,
                                                                @RequestBody RstrListType rstrListType){
        Optional<ParticipantInfoEntity> entity = participantInfoRepository.findById(id);
        if(entity.isPresent()){
            RstrListEntity rstrListEntity = rstrListService.createRstr(entity.get(),rstrListType);
            RstrListType rstrListType1 = ed807Service.convertToDTO(rstrListEntity);
            return ResponseEntity.ok(rstrListType1);
        }else {
            return ResponseEntity.notFound().build();
        }
    }
    @PreAuthorize("hasAuthority('USER')")
    @PostMapping("Create/SWBIC/{id}")
    public ResponseEntity<SWBICList> createSWBIC(@PathVariable(value = "id") BigInteger id,
                                                                @RequestBody SWBICList swbicList){
        Optional<BICDirectoryEntry> entity = bicDirectoryEntity.findById(id);//id от BIC
        if(entity.isPresent()){
            SWBICSEntity swbicsEntity = swbicsService.createSwbic(entity.get(),swbicList);
            SWBICList swbicList1 = ed807Service.convertToDTO(swbicsEntity);
            return ResponseEntity.ok(swbicList1);
        }else {
            return ResponseEntity.notFound().build();
        }
    }

}

