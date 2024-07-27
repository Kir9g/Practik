package com.bank.Service;

import com.bank.DB.*;
import com.bank.DTO.Models.*;
import com.bank.DTO.ru.cbr.ed.v2.*;
import com.bank.Repository.*;
import com.bank.Repository.XchTypeRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class ED807Service {
    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private AccRstrListRepository accRstrListRepository;

    @Autowired
    private BICDirectoryEntity bicDirectoryEntity;

    @Autowired
    private ED807EntityRepository ed807EntityRepository;

    @Autowired
    private InitialEDRepository initialEDRepository;

    @Autowired
    private ParticipantInfoRepository participantInfoRepository;

    @Autowired
    private PartInfoRepository partInfoRepository;

    @Autowired
    private RstrListRepository rstrListRepository;

    @Autowired
    private SWBICSRepository swbicsRepository;
    @Autowired
    private CreationReasonRepository creationReasonRepository;
    @Autowired
    private InfoTypeCodeRepository infoTypeCodeRepository;
    @Autowired
    private ChangeTypeRepository changeTypeRepository;
    @Autowired
    private PtTypeRepository ptTypeRepository;
    @Autowired
    private SrvcsRepository srvcsRepository;
    @Autowired
    private XchTypeRepository xchTypeRepository;
    @Autowired
    private RstrRepository rstrRepository;
    @Autowired
    private ParticipantStatusRepository statusRepository;
    @Autowired
    private AccRstrRepository accRstrRepository;
    @Autowired
    private AccountStatusRepository accountStatusRepository;
    @Autowired
    private RegulationAccountTypeRepository regulationAccountTypeRepository;


    @Transactional
    public ED807Entity saveED807(ED807 ed807) throws Exception {
        ED807Entity ed807Entity = new ED807Entity();
        ed807Entity.setEdno(ed807.getEDNo());
        ed807Entity.setName(ed807.getName());

        ed807Entity.setFilePath(ed807.getFilePath());

        ed807Entity.setCreationDate(ed807.getCreationDate());
        ed807Entity.setEDDate(ed807.getEDDate().toGregorianCalendar().getTime());
        ed807Entity.setEDAuthor(ed807.getEDAuthor());
        if (ed807.getEDReceiver() != null) {
            ed807Entity.setEDReceiver(BigInteger.valueOf(Long.parseLong(ed807.getEDReceiver())));
        } else {
            ed807Entity.setEDReceiver(null);
        }
        Optional<CreationReasonEntity> creationReason = creationReasonRepository.findByName(ed807.getCreationReason().name());
        if(creationReason.get() !=null) {
            ed807Entity.setCreationReason(creationReason.get());
        }else {
            ed807Entity.setCreationReason(null);
        }
        ed807Entity.setCreationDateTime(ed807.getCreationDateTime().toGregorianCalendar().getTime());
        Optional<InfoTypeCodeEntity> infoTypeCodeEntity = infoTypeCodeRepository.findByName(ed807.getInfoTypeCode().name());
        if(infoTypeCodeEntity.get() !=null) {
            ed807Entity.setInfoTypeCodeEntity(infoTypeCodeEntity.get());
        }else {
            ed807Entity.setInfoTypeCodeEntity(null);
        }
        ed807Entity.setBusinessDay(ed807.getBusinessDay().toGregorianCalendar().getTime());
        if(ed807.getDirectoryVersion() !=null) {
            ed807Entity.setDirectoryVersion(ed807.getDirectoryVersion());
        }else {
            ed807Entity.setDirectoryVersion(null);
        }


        if(ed807.getPartInfo() != null) {
            PartInfoEntity partInfoEntity = new PartInfoEntity();
            partInfoEntity.setEd807Entity(ed807Entity);
            partInfoEntity.setPartNo(ed807.getPartInfo().getPartNo());
            partInfoEntity.setPartQuantity(ed807.getPartInfo().getPartQuantity());
            partInfoEntity.setPartAggregateID(ed807.getPartInfo().getPartAggregateID());

            partInfoRepository.save(partInfoEntity);
            ed807Entity.setPartInfoEntity(partInfoEntity);
        }else {
            ed807Entity.setPartInfoEntity(null);
        }

        if(ed807.getInitialED() != null) {
            InitialED initialED = new InitialED();
            initialED.setEDAuthor(ed807.getInitialED().getEDAuthor());
            initialED.setEDDate(ed807.getInitialED().getEDDate().toGregorianCalendar().getTime());
            initialED.setEDNo(ed807.getInitialED().getEDNo());

            initialEDRepository.save(initialED);
            ed807Entity.setInitialED(initialED);
        }else {
            ed807Entity.setInitialED(null);
        }
        ed807EntityRepository.save(ed807Entity);
        if(ed807.getBICDirectoryEntry() != null) {
            List<BICDirectoryEntryType> bicDirectoryEntryTypes = ed807.getBICDirectoryEntry();
            Set<BICDirectoryEntry> bicDirectoryEntries = new HashSet<>();
            for (BICDirectoryEntryType bicDirectoryEntryType: bicDirectoryEntryTypes){
                BICDirectoryEntry bicDirectoryEntry = new BICDirectoryEntry();
                bicDirectoryEntry.setEd807Entity(ed807Entity);
                bicDirectoryEntry.setBIC(bicDirectoryEntryType.getBIC());
                if (bicDirectoryEntryType.getChangeType() != null) {
                    ChangeTypeEntity changeTypeEntity = changeTypeRepository.findByName(bicDirectoryEntryType.getChangeType().name());
                    bicDirectoryEntry.setChangeType(changeTypeEntity);
                } else {
                    bicDirectoryEntry.setChangeType(null);
                }
                if(bicDirectoryEntryType.getParticipantInfo() !=null) {
                    ParticipantInfoEntity participantInfoEntity = new ParticipantInfoEntity();
                    participantInfoEntity.setNameP(bicDirectoryEntryType.getParticipantInfo().getNameP());
                    if (bicDirectoryEntryType.getParticipantInfo().getEnglName() != null) {
                        participantInfoEntity.setEnglName(bicDirectoryEntryType.getParticipantInfo().getEnglName());
                    } else {
                        participantInfoEntity.setEnglName(null);
                    }
                    if (bicDirectoryEntryType.getParticipantInfo().getRegN() != null) {
                        participantInfoEntity.setRegN(bicDirectoryEntryType.getParticipantInfo().getRegN());
                    } else {
                        participantInfoEntity.setRegN(null);
                    }
                    if (bicDirectoryEntryType.getParticipantInfo().getCntrCd() != null) {
                        participantInfoEntity.setCntrCd(bicDirectoryEntryType.getParticipantInfo().getCntrCd());
                    } else {
                        participantInfoEntity.setCntrCd(null);
                    }

                    participantInfoEntity.setRgn(bicDirectoryEntryType.getParticipantInfo().getRgn());

                    if (bicDirectoryEntryType.getParticipantInfo().getInd() != null) {
                        participantInfoEntity.setInd(bicDirectoryEntryType.getParticipantInfo().getInd());
                    } else {
                        participantInfoEntity.setInd(null);
                    }

                    if (bicDirectoryEntryType.getParticipantInfo().getTnp() != null) {
                        participantInfoEntity.setTnp(bicDirectoryEntryType.getParticipantInfo().getTnp());
                    } else {
                        participantInfoEntity.setTnp(null);
                    }

                    if (bicDirectoryEntryType.getParticipantInfo().getNnp() != null) {
                        participantInfoEntity.setNnp(bicDirectoryEntryType.getParticipantInfo().getNnp());
                    } else {
                        participantInfoEntity.setNnp(null);
                    }

                    if (bicDirectoryEntryType.getParticipantInfo().getAdr() != null) {
                        participantInfoEntity.setAdr(bicDirectoryEntryType.getParticipantInfo().getAdr());
                    } else {
                        participantInfoEntity.setAdr(null);
                    }
                    if (bicDirectoryEntryType.getParticipantInfo().getPrntBIC() != null) {
                        participantInfoEntity.setPrntBIC(bicDirectoryEntryType.getParticipantInfo().getPrntBIC());
                    } else {
                        participantInfoEntity.setPrntBIC(null);
                    }
                    participantInfoEntity.setDateIn(bicDirectoryEntryType.getParticipantInfo().getDateIn().toGregorianCalendar().getTime());
                    if (bicDirectoryEntryType.getParticipantInfo().getDateOut() != null) {
                        participantInfoEntity.setDateOut(bicDirectoryEntryType.getParticipantInfo().getDateOut().toGregorianCalendar().getTime());
                    } else {
                        participantInfoEntity.setDateOut(null);
                    }
                    participantInfoEntity.setPtTypeEntity(ptTypeRepository.findByName(bicDirectoryEntryType.getParticipantInfo().getPtType()));
                    participantInfoEntity.setSrvcsEntity(srvcsRepository.findByName(Integer.valueOf(bicDirectoryEntryType.getParticipantInfo().getSrvcs())));
                    participantInfoEntity.setXchTypeEntity(xchTypeRepository.findByName(Integer.valueOf(bicDirectoryEntryType.getParticipantInfo().getXchType())));
                    if (bicDirectoryEntryType.getParticipantInfo().getUID() != null) {
                        participantInfoEntity.setUID(bicDirectoryEntryType.getParticipantInfo().getUID());
                    } else {
                        participantInfoEntity.setUID(null);
                    }
                    if (bicDirectoryEntryType.getParticipantInfo().getParticipantStatus() != null) {
                        participantInfoEntity.setParticipantStatus(statusRepository.findByName(bicDirectoryEntryType.getParticipantInfo().getParticipantStatus().name()));
                    } else {
                        participantInfoEntity.setParticipantStatus(null);
                    }


                    List<RstrListType> rstrList = bicDirectoryEntryType.getParticipantInfo().getRstrList();
                    if (rstrList != null) {
                        Set<RstrListEntity> rstrListEntities = new HashSet<>();
                        for (RstrListType rstr : rstrList) {

                            RstrListEntity rstrListEntity = new RstrListEntity();
                            rstrListEntity.setRstrEntity(rstrRepository.findByName(rstr.getRstr().name()));
                            rstrListEntity.setRstrDate(rstr.getRstrDate().toGregorianCalendar().getTime());
                            rstrListEntity.setParticipantInfoEntity(participantInfoEntity);
                            rstrListRepository.save(rstrListEntity);


                            rstrListEntities.add(rstrListEntity);
                        }
                        participantInfoEntity.setRstrListEntity(rstrListEntities);
                    } else {
                        participantInfoEntity.setRstrListEntity(null);
                    }
                    bicDirectoryEntry.setParticipantInfo(participantInfoEntity);
                    participantInfoEntity.setBicDirectoryEntry(bicDirectoryEntry);
                    participantInfoRepository.save(participantInfoEntity);
                }else {
                    bicDirectoryEntryType.setParticipantInfo(null);
                }
                if (bicDirectoryEntryType.getSWBICS() != null){

                    List<SWBICList> swbicLists = bicDirectoryEntryType.getSWBICS();
                    if (swbicLists != null) {
                        Set<SWBICSEntity> swbicsEntities = new HashSet<>();
                        for (SWBICList swbicList : swbicLists) {

                            SWBICSEntity swbicsEntity = new SWBICSEntity();
                            swbicsEntity.setSWBIC(swbicList.getSWBIC());
                            swbicsEntity.setDefaultSWBIC(swbicList.isDefaultSWBIC());
                            swbicsEntity.setBicDirectoryEntry(bicDirectoryEntry);
                            swbicsRepository.save(swbicsEntity);

                            swbicsEntities.add(swbicsEntity);
                        }
                        bicDirectoryEntry.setSwbics(swbicsEntities);
                    } else {
                        bicDirectoryEntry.setSwbics(null);
                    }
                }
                if(bicDirectoryEntryType.getAccounts() != null){
                    List<AccountsType> accountsTypes = bicDirectoryEntryType.getAccounts();
                    if(accountsTypes != null){
                        Set<Accounts> accounts = new HashSet<>();
                        for (AccountsType accountsType: accountsTypes){
                            Accounts accountsEntity = new Accounts();

                            accountsEntity.setAccount(accountsType.getAccount());
                            accountsEntity.setRegulationAccountType(regulationAccountTypeRepository.findByName(accountsType.getRegulationAccountType().name()));
                            if(accountsType.getAccount() != null) {
                                accountsEntity.setCk(accountsType.getCK());
                            }else {accountsEntity.setCk(null);}
                            accountsEntity.setAccountCBRBIC(accountsType.getAccountCBRBIC());
                            accountsEntity.setDateIn(accountsType.getDateIn().toGregorianCalendar().getTime());
                            if(accountsType.getDateOut() != null) {
                                accountsEntity.setDateOut(accountsType.getDateOut().toGregorianCalendar().getTime());
                            }else {accountsEntity.setDateOut(null);}
                            if(accountsType.getAccountStatus() != null){
                                accountsEntity.setAccountStatusEntity(accountStatusRepository.findByName(accountsType.getAccountStatus().name()));
                            }else {
                                accountsEntity.setAccountStatusEntity(null);
                            }
                            accountsEntity.setBicDirectoryEntry(bicDirectoryEntry);
                            if (accountsType.getAccRstrList()!= null){
                                List<AccRstrListType> accRstrListTypeList = accountsType.getAccRstrList();
                                Set<AccRstrListEntity> accRstrListEntities = new HashSet<>();
                                for (AccRstrListType accRstrListType: accRstrListTypeList){
                                    AccRstrListEntity accRstrListEntity = new AccRstrListEntity();
                                    accRstrListEntity.setAccounts(accountsEntity);
                                    accRstrListEntity.setAccRstrEntity(accRstrRepository.findByName(accRstrListType.getAccRstr().name()));
                                    accRstrListEntity.setAccRstrDate(accRstrListType.getAccRstrDate().toGregorianCalendar().getTime());
                                    if(accRstrListType.getSuccessorBIC()!=null){
                                        accRstrListEntity.setSuccessorBIC(accRstrListType.getSuccessorBIC());
                                    }else {accRstrListEntity.setSuccessorBIC(null);}
                                    accRstrListEntities.add(accRstrListEntity);
                                }
                                accountsEntity.setAccRstrListEntity(accRstrListEntities);
                                accountRepository.save(accountsEntity);
                            }
                            accounts.add(accountsEntity);

                        }
                        bicDirectoryEntry.setAccounts(accounts);
                    }
                }
                bicDirectoryEntry.setEd807Entity(ed807Entity);
                bicDirectoryEntries.add(bicDirectoryEntry);

                ed807Entity.setBicDirectoryEntries(bicDirectoryEntries);
                ed807EntityRepository.save(ed807Entity);
                bicDirectoryEntity.save(bicDirectoryEntry);

            }
        }
        return ed807Entity;

    }


    public List<ED807DTO> getAllED807ByName(String name){
        List<ED807Entity> ed807Entities = ed807EntityRepository.findByName(name);
        return ed807Entities.stream()
                .map(this::convertDTOPreview)
                .collect(Collectors.toList());
    }

    public List<ED807DTO> getAllBetwenDate(Date startDate, Date endDate){
        List<ED807Entity> ed807Entities = ed807EntityRepository.findAllByCreationDateBetween(startDate,endDate);
        return ed807Entities.stream()
                .map(this::convertDTOPreview)
                .collect(Collectors.toList());
    }

    public List<ED807DTO> getAllED807() {
        List<ED807Entity> ed807Entities = ed807EntityRepository.findAll();
        return ed807Entities.stream()
                .map(this::convertDTOPreview)
                .collect(Collectors.toList());
    }

    public ED807DTO getById(BigInteger id){
        Optional<ED807Entity> ed807Entity = ed807EntityRepository.findById(id);
        return ed807Entity.map(this::convertToDTO).orElse(null);
    }

    @Transactional
    public boolean deletByid(BigInteger id){
        Optional<ED807Entity> ed807EntityOptional = ed807EntityRepository.findById(id);
        if (ed807EntityOptional.isPresent()) {
            ED807Entity ed807Entity = ed807EntityOptional.get();
            try {
                Files.deleteIfExists(Paths.get(ed807Entity.getFilePath()));
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
            ed807EntityRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
    @Transactional
    public boolean deleteAll() {
        List<ED807Entity> ed807Entities = ed807EntityRepository.findAll();
        boolean allDeleted = true;

        try {
            ed807EntityRepository.deleteAll();
            for (ED807Entity ed807Entity : ed807Entities) {
                try {
                    Files.deleteIfExists(Paths.get(ed807Entity.getFilePath()));
                } catch (Exception e) {
                    e.printStackTrace();
                    allDeleted = false;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            allDeleted = false;
        }

        return allDeleted;
    }
    @Transactional
    public boolean deleteBicByBic(String bic, BigInteger EDID) {
        // Найдите ED807Entity по ID
        Optional<ED807Entity> ed807EntityOptional = ed807EntityRepository.findById(EDID);

        if (!ed807EntityOptional.isPresent()) {
            // Если ED807Entity не найден, верните false
            return false;
        }

        ED807Entity ed807Entity = ed807EntityOptional.get();
        Set<BICDirectoryEntry> bicDirectoryEntries = ed807Entity.getBicDirectoryEntries();

        // Найдите BICDirectoryEntry по BIC
        BICDirectoryEntry entryToDelete = null;
        for (BICDirectoryEntry entry : bicDirectoryEntries) {
            if (entry.getBIC().equals(bic)) {
                entryToDelete = entry;
                break;
            }
        }

        if (entryToDelete == null) {
            return false;
        }


        // Удалите запись BICDirectoryEntry из базы данных
        bicDirectoryEntries.remove(entryToDelete);

        return true;
    }
    @Transactional
    public ED807DTO updateED807(BigInteger id, ED807 ed807) {
        Optional<ED807Entity> ed807EntityOptional = ed807EntityRepository.findById(id);
        if (!ed807EntityOptional.isPresent()) {
            throw new RuntimeException("ED807 entity not found with id " + id);
        }

        ED807Entity ed807Entity = ed807EntityOptional.get();

        if (ed807.getEDNo() != null) {
            ed807Entity.setEdno(ed807.getEDNo());
        }
        if (ed807.getEDDate() != null) {
            ed807Entity.setEDDate(ed807.getEDDate().toGregorianCalendar().getTime());
        }
        if (ed807.getEDAuthor() != null) {
            ed807Entity.setEDAuthor(ed807.getEDAuthor());
        }
        if (ed807.getEDReceiver() != null) {
            ed807Entity.setEDReceiver(BigInteger.valueOf(Long.parseLong(ed807.getEDReceiver())));
        }

        ed807EntityRepository.save(ed807Entity);
        ED807DTO coverted = convertToDTO(ed807Entity);
        return coverted;
    }



    public ED807DTO convertDTOPreview(ED807Entity ed807Entity){
        ED807DTO dto = new ED807DTO();
        // Установка основных полей
        dto.setId(ed807Entity.getId());

        dto.setName(ed807Entity.getName());
        dto.setFilePath(ed807Entity.getFilePath());
        dto.setCreationDate(ed807Entity.getCreationDate());

        // Установка основных полей

        dto.setEdno(ed807Entity.getEdno());
        dto.setEDDate(ed807Entity.getEDDate());
        dto.setEDAuthor(ed807Entity.getEDAuthor());
        if(ed807Entity.getEDReceiver() != null){
            dto.setEDReceiver(ed807Entity.getEDReceiver());
        }else {
            dto.setEDReceiver(null);
        }

        dto.setCreationReason(ed807Entity.getCreationReason().getName());
        dto.setCreationDateTime(ed807Entity.getCreationDateTime());
        dto.setInfoTypeCode(ed807Entity.getInfoTypeCodeEntity().getName());
        dto.setBusinessDay(ed807Entity.getBusinessDay());

        if(ed807Entity.getDirectoryVersion() != null) {
            dto.setDirectoryVersion(ed807Entity.getDirectoryVersion());
        }else {
            dto.setDirectoryVersion(null);
        }
        if (ed807Entity.getPartInfoEntity() != null) {
            PartInfoEntity partInfoEntity= ed807Entity.getPartInfoEntity();
            PartInfoDTO partInfoDTO =new PartInfoDTO();

            partInfoDTO.setId(partInfoEntity.getId());
            partInfoDTO.setPartQuantity(partInfoEntity.getPartQuantity());
            partInfoDTO.setPartNo(partInfoEntity.getPartNo());
            partInfoDTO.setPartAggregateID(partInfoEntity.getPartAggregateID());
            dto.setPartInfoDTO(partInfoDTO);

        }
        else {
            dto.setPartInfoDTO(null);
        }
        if (ed807Entity.getInitialED() != null){
            InitialED initialED = ed807Entity.getInitialED();

            InitialEDDTO edRefID = new InitialEDDTO();

            edRefID.setID(initialED.getID());
            edRefID.setEDNo(initialED.getEDNo());
            edRefID.setEDDate(initialED.getEDDate());
            edRefID.setEDAuthor(initialED.getEDAuthor());

            dto.setInitialEDDTO(edRefID);
        }else {

        }

        return dto;
    }
    public ED807DTO convertToDTO(ED807Entity ed807Entity) {
        ED807DTO dto = new ED807DTO();
        // Установка основных полей
        dto.setId(ed807Entity.getId());

        dto.setName(ed807Entity.getName());
        dto.setCreationDate(ed807Entity.getCreationDate());
        dto.setFilePath(ed807Entity.getFilePath());


        dto.setEdno(ed807Entity.getEdno());
        dto.setEDDate(ed807Entity.getEDDate());
        dto.setEDAuthor(ed807Entity.getEDAuthor());
        if(ed807Entity.getEDReceiver() != null){
            dto.setEDReceiver(ed807Entity.getEDReceiver());
        }else {
            dto.setEDReceiver(null);
        }

        dto.setCreationReason(ed807Entity.getCreationReason().getName());
        dto.setCreationDateTime(ed807Entity.getCreationDateTime());
        dto.setInfoTypeCode(ed807Entity.getInfoTypeCodeEntity().getName());
        dto.setBusinessDay(ed807Entity.getBusinessDay());
        if(ed807Entity.getDirectoryVersion() != null) {
            dto.setDirectoryVersion(ed807Entity.getDirectoryVersion());
        }else {
            dto.setDirectoryVersion(null);
        }
        if (ed807Entity.getPartInfoEntity() != null) {
            PartInfoEntity partInfoEntity= ed807Entity.getPartInfoEntity();
            PartInfoDTO partInfoDTO =new PartInfoDTO();

            partInfoDTO.setId(partInfoEntity.getId());
            partInfoDTO.setPartQuantity(partInfoEntity.getPartQuantity());
            partInfoDTO.setPartNo(partInfoEntity.getPartNo());
            partInfoDTO.setPartAggregateID(partInfoEntity.getPartAggregateID());
            dto.setPartInfoDTO(partInfoDTO);
        }else {
            dto.setPartInfoDTO(null);
        }
        if (ed807Entity.getInitialED() != null) {
            InitialED initialED = ed807Entity.getInitialED();
            InitialEDDTO initialEDInfoDTO = new InitialEDDTO();

            initialEDInfoDTO.setID(initialED.getID());
            initialEDInfoDTO.setEDAuthor(initialED.getEDAuthor());
            initialEDInfoDTO.setEDDate(initialED.getEDDate());
            initialEDInfoDTO.setEDNo(initialED.getEDNo());


            dto.setInitialEDDTO(initialEDInfoDTO);
        }else {
            dto.setInitialEDDTO(null);
        }


        // Преобразование связанных сущностей
            Set<BicDirectoryDTO> bicDirectoryEntryDTOs = ed807Entity.getBicDirectoryEntries().stream()
                    .map(this::convertToDTO)
                    .collect(Collectors.toSet());
            dto.setBicDirectoryDTOS(bicDirectoryEntryDTOs);

        return dto;
    }

    public BicDirectoryDTO convertToDTO(BICDirectoryEntry bicDirectoryEntry) {
        BicDirectoryDTO dto = new BicDirectoryDTO();
        dto.setId(bicDirectoryEntry.getId());
        dto.setBIC(bicDirectoryEntry.getBIC());
        if (bicDirectoryEntry.getChangeType() != null) {
            dto.setChangeType(bicDirectoryEntry.getChangeType().getName());
        } else {
            dto.setChangeType(null);
        }

        // Преобразование связанных сущностей
        if (bicDirectoryEntry.getParticipantInfo() != null) {
            dto.setParticipantInfo(convertToDTO(bicDirectoryEntry.getParticipantInfo())); // Вызов метода для преобразования ParticipantInfoEntity
        }
        if(bicDirectoryEntry.getAccounts() != null){
            Set<AccountsDTO> accountsDTOS = bicDirectoryEntry.getAccounts().stream()
                    .map(this::convertToDTO)
                    .collect(Collectors.toSet());
            dto.setAccounts(accountsDTOS);
        }else {
            dto.setAccounts(null);
        }

        if(bicDirectoryEntry.getSwbics() != null){
            Set<SWBICSDTO> swbicLists = bicDirectoryEntry.getSwbics().stream()
                    .map((this::convertToDTO))
                    .collect(Collectors.toSet());
            dto.setSwbics(swbicLists);
        }else {
            dto.setSwbics(null);
        }

        return dto;
    }



    public ParticipantInfoDTO convertToDTO(ParticipantInfoEntity participantInfoEntity) {
        ParticipantInfoDTO dto = new ParticipantInfoDTO();
        dto.setId(participantInfoEntity.getId());
        dto.setNameP(participantInfoEntity.getNameP());
        dto.setEnglName(participantInfoEntity.getEnglName());
        dto.setRegN(participantInfoEntity.getRegN());
        dto.setCntrCd(participantInfoEntity.getCntrCd());
        dto.setRgn(participantInfoEntity.getRgn());
        dto.setInd(participantInfoEntity.getInd());
        dto.setTnp(participantInfoEntity.getTnp());
        dto.setNnp(participantInfoEntity.getNnp());
        dto.setAdr(participantInfoEntity.getAdr());
        dto.setPrntBIC(participantInfoEntity.getPrntBIC());
        dto.setDateIn(participantInfoEntity.getDateIn());
        dto.setDateOut(participantInfoEntity.getDateOut());
        dto.setPtType(participantInfoEntity.getPtTypeEntity().getName());
        dto.setSrvcs(participantInfoEntity.getSrvcsEntity().getName());
        dto.setXchType(Integer.valueOf(participantInfoEntity.getXchTypeEntity().getName()));
        dto.setUID(participantInfoEntity.getUID());
        dto.setParticipantStatus(participantInfoEntity.getParticipantStatus().getName());

        // Преобразование rstrListEntity в rstrListType
        if(participantInfoEntity.getRstrListEntity() != null) {
            Set<RstrListDTO> rstrList = participantInfoEntity.getRstrListEntity().stream()
                    .map(this::convertToDTO)
                    .collect(Collectors.toSet());
            dto.setRstrListEntity(rstrList);
        }else {
            dto.setRstrListEntity(null);
        }
        return dto;
    }

    public RstrListDTO convertToDTO(RstrListEntity entity) {
        if (entity == null) {
            return null;
        }
        RstrListDTO dto = new RstrListDTO();
        dto.setId(entity.getId());
        dto.setRstr(entity.getRstrEntity().getName());
        dto.setRstrDate(entity.getRstrDate());
        return dto;
    }

    public AccountsDTO convertToDTO(Accounts entity){
        if(entity == null){
            return null;
        }
        AccountsDTO dto = new AccountsDTO();
        dto.setId(entity.getId());
        dto.setAccount(entity.getAccount());
        dto.setRegulationAccountType(entity.getRegulationAccountType().getName());
        dto.setCk(entity.getCk());
        dto.setAccountCBRBIC(entity.getAccountCBRBIC());
        dto.setDateIn(entity.getDateIn());
        if(entity.getDateOut() != null){
            dto.setDateOut(entity.getDateOut());
        }else {
            dto.setDateOut(null);
        }
        if(entity.getAccountStatusEntity() != null){
            dto.setAccountStatus(entity.getAccountStatusEntity().getName());
        }else {
            dto.setAccountStatus(null);
        }

        if(entity.getAccRstrListEntity() != null){
            Set<AccRstrListDTO> accRstrListDTOList = entity.getAccRstrListEntity().stream()
                    .map(this::convertToDTO)
                    .collect(Collectors.toSet());
            dto.setAccRstrListDTOList(accRstrListDTOList);
        }
        return dto;
    }

    public AccRstrListDTO convertToDTO(AccRstrListEntity entity){
     if(entity == null){
         return null;
     }


     AccRstrListDTO dto = new AccRstrListDTO();
     dto.setId(entity.getId());
     dto.setAccRstr(entity.getAccRstrEntity().getName());
     dto.setAccRstrDate(entity.getAccRstrDate());
     if(entity.getSuccessorBIC() != null){
         dto.setSuccessorBIC(entity.getSuccessorBIC());
     }else {
         dto.setSuccessorBIC(null);
     }
     return dto;
    }
    public SWBICSDTO convertToDTO(SWBICSEntity entity){
        if(entity == null){
            return null;
        }
        SWBICSDTO dto = new SWBICSDTO();
        dto.setId(entity.getId());
        dto.setSWBIC(entity.getSWBIC());
        dto.setDefaultSWBIC(entity.isDefaultSWBIC());

        return dto;
    }
}


