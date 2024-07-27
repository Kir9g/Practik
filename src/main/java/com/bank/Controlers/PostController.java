package com.bank.Controlers;

import com.bank.DB.*;
import com.bank.DTO.Models.*;
import com.bank.DTO.ru.cbr.ed.v2.*;
import com.bank.Repository.*;
import com.bank.Service.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
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
@Tag(name = "PostController", description = "Контроллер для создания сущностей в бд")
@SecurityRequirement(name = "basicAuth")
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
    @PostMapping(value = "/upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    @Operation(
            summary = "Загрузка xml файла ed807",
            description = "Позволяет парсерит загруженный через данный api файл для дальнейшего преобразования его в экземпляр сущности ED807"
    )
    public ResponseEntity<?> uploadFile(@Parameter(description = "Файл xml, который следует загрузить")@RequestParam("file") MultipartFile file,
                                        @Parameter(description = "Название файла в базе, если его нет ставится имя файла")@RequestParam(required = false) String name) {
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
            ED807Entity entity= ed807Service.saveED807(ed807);
            ED807DTO ed807DTO = ed807Service.convertToDTO(entity);
            return ResponseEntity.ok(ed807DTO);
        } catch (IOException | JAXBException e) {
            e.printStackTrace();
            return new ResponseEntity<>("Error processing file", HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @PostMapping("Create/BIC/{id}")
    @Operation(
            summary = "Создание bic",
            description = "Позволяет создавать бик для ed807, id которого передается в данный метод, создается без связанных сущностей"
    )
    public ResponseEntity<BicDirectoryDTO> createBic(@Parameter(description = "Идентификатор ed807")@PathVariable(value = "id") BigInteger id,
                                                           @Parameter(description = "Поля для создания")@RequestBody BicDirectoryDTO bicDirectoryDTO){
        Optional<ED807Entity> entity = entityRepository.findById(id);//id от ed807
        if(entity.isPresent()){
            BICDirectoryEntry bicDirectoryEntry = bicDirectoryService.createBIC(entity.get(),bicDirectoryDTO);
            BicDirectoryDTO bicDirectoryEntryType1 = ed807Service.convertToDTO(bicDirectoryEntry);
            return ResponseEntity.ok(bicDirectoryEntryType1);
        }else {
            return ResponseEntity.notFound().build();
        }
    }
    @PostMapping("Create/Account/{id}")
    @Operation(
            summary = "Создание Account",
            description = "Позволяет создавать Account для bic, id которого передается в данный метод, создается без связанных сущностей"
    )
    public ResponseEntity<AccountsDTO> createAccount(@Parameter(description = "Идентификатор BIC")@PathVariable(value = "id") BigInteger id,
                                                      @Parameter(description = "Поля для создания")@RequestBody AccountsDTO accountsType) throws Exception {
        Optional<BICDirectoryEntry> entity = bicDirectoryEntity.findById(id);//id от BIC
        if(entity.isPresent()){
            Accounts accounts = accountsService.createAcc(entity.get(),accountsType);
            AccountsDTO accounts1 = ed807Service.convertToDTO(accounts);
            return ResponseEntity.ok(accounts1);
        }else {
            return ResponseEntity.notFound().build();
        }
    }
    @PostMapping("Create/AccRstr/{id}")
    @Operation(
            summary = "Создание AccRstr",
            description = "Позволяет создавать AccRstr для Account, id которого передается в данный метод, создается без связанных сущностей"
    )
    public ResponseEntity<AccRstrListDTO> createAccRstr(@Parameter(description = "Идентификатор Аккаунта")@PathVariable(value = "id") BigInteger id,
                                                         @Parameter(description = "Поля для создания")@RequestBody AccRstrListDTO accRstrListDTO){
        Optional<Accounts> entity = accountRepository.findById(id);//id от BIC
        if(entity.isPresent()){
            AccRstrListEntity accounts = accRstrListService.createAcc(entity.get(),accRstrListDTO);
            AccRstrListDTO accounts1 = ed807Service.convertToDTO(accounts);
            return ResponseEntity.ok(accounts1);
        }else {
            return ResponseEntity.notFound().build();
        }
    }
    @PostMapping("Create/InitialED/{id}")
    @Operation(
            summary = "Создание InitialED",
            description = "Позволяет создавать InitialED для ed807, id которого передается в данный метод, создается без связанных сущностей"
    )
    public ResponseEntity<ED807DTO> createInitial(@Parameter(description = "Идентификатор ed807")@PathVariable(value = "id") BigInteger id,
                                                  @Parameter(description = "Поля для создания")@RequestBody InitialEDInfo initialEDInfo){
        Optional<ED807Entity> entity = ed807EntityRepository.findById(id);//id от BIC
        if(entity.isPresent()){
            InitialED accounts = initialEDService.createInitial(entity.get(),initialEDInfo);
            ED807DTO ed807 = ed807Service.convertToDTO(entity.get());
            return ResponseEntity.ok(ed807);
        }else {
            return ResponseEntity.notFound().build();
        }
    }
    @PostMapping("Create/PartInfo/{id}")
    @Operation(
            summary = "Создание PartInfo",
            description = "Позволяет создавать PartInfo для ed807, id которого передается в данный метод, создается без связанных сущностей"
    )
    public ResponseEntity<ED807DTO> createPartInfo(@Parameter(description = "Идентификатор ED807")@PathVariable(value = "id") BigInteger id,
                                                @Parameter(description = "Поля для создания")@RequestBody PartInfo partInfo){
        Optional<ED807Entity> entity = ed807EntityRepository.findById(id);
        if(entity.isPresent()){
            PartInfoEntity partInfoEntity = partInfoSerivce.createPart(entity.get(),partInfo);
            ED807DTO ed807 = ed807Service.convertToDTO(entity.get());
            return ResponseEntity.ok(ed807);
        }else {
            return ResponseEntity.notFound().build();
        }
    }
    @PostMapping("Create/ParticipantInfo/{id}")
    @Operation(
            summary = "Создание ParticipantInfo",
            description = "Позволяет создавать ParticipantInfo для BIC, id которого передается в данный метод, создается без связанных сущностей"
    )
    public ResponseEntity<BicDirectoryDTO> createPartInfo(@Parameter(description = "Идентификатор ED807")@PathVariable(value = "id") BigInteger id,
                                                          @Parameter(description = "Поля для создания")@RequestBody ParticipantInfoDTO participantInfoDTO){
        Optional<BICDirectoryEntry> entity = bicDirectoryEntity.findById(id);//id от BIC
        if(entity.isPresent()){
            participantInfoService.createPart(entity.get(),participantInfoDTO);
            BicDirectoryDTO bicDirectoryEntryType = ed807Service.convertToDTO(entity.get());
            return ResponseEntity.ok(bicDirectoryEntryType);
        }else {
            return ResponseEntity.notFound().build();
        }
    }
    @PostMapping("Create/Rstr/{id}")
    @Operation(
            summary = "Создание RstrList",
            description = "Позволяет создавать RstrList для ParticipantInfo, id которого передается в данный метод, создается без связанных сущностей"
    )
    public ResponseEntity<RstrListDTO> createRstr(@Parameter(description = "Идентификатор ParticipantInfo")@PathVariable(value = "id") BigInteger id,
                                                   @Parameter(description = "Поля для создания")@RequestBody RstrListDTO rstrListDTO){
        Optional<ParticipantInfoEntity> entity = participantInfoRepository.findById(id);
        if(entity.isPresent()){
            RstrListEntity rstrListEntity = rstrListService.createRstr(entity.get(),rstrListDTO);
            RstrListDTO rstrListType1 = ed807Service.convertToDTO(rstrListEntity);
            return ResponseEntity.ok(rstrListType1);
        }else {
            return ResponseEntity.notFound().build();
        }
    }
    @PostMapping("Create/SWBIC/{id}")
    @Operation(
            summary = "Создание SWBIC",
            description = "Позволяет создавать SWBIC для BIC, id которого передается в данный метод, создается без связанных сущностей"
    )
    public ResponseEntity<SWBICSDTO> createSWBIC(@Parameter(description = "Идентификатор BIC")@PathVariable(value = "id") BigInteger id,
                                                 @Parameter(description = "Поля для создания")@RequestBody SWBICList swbicList){
        Optional<BICDirectoryEntry> entity = bicDirectoryEntity.findById(id);//id от BIC
        if(entity.isPresent()){
            SWBICSEntity swbicsEntity = swbicsService.createSwbic(entity.get(),swbicList);
            SWBICSDTO swbicList1 = ed807Service.convertToDTO(swbicsEntity);
            return ResponseEntity.ok(swbicList1);
        }else {
            return ResponseEntity.notFound().build();
        }
    }

}

