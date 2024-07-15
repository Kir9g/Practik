package com.bank.Service;

import com.bank.DB.*;
import com.bank.DTO.ru.cbr.ed.leaftypes.v2.*;
import com.bank.DTO.ru.cbr.ed.v2.*;
import com.bank.Repository.*;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
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

    @Transactional
    public void saveED807(ED807 ed807){
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
        ed807Entity.setCreationReason(ed807.getCreationReason().toString());
        ed807Entity.setCreationDateTime(ed807.getCreationDateTime().toGregorianCalendar().getTime());
        ed807Entity.setInfoTypeCode(ed807.getInfoTypeCode().toString());
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
        }else {
            ed807Entity.setPartInfo(null);
        }

        if(ed807.getInitialED() != null) {
            InitialED initialED = new InitialED();
            initialED.setEDAuthor(ed807.getInitialED().getEDAuthor());
            initialED.setEDDate(ed807.getInitialED().getEDDate().toGregorianCalendar().getTime());
            initialED.setEDNo(ed807.getInitialED().getEDNo());

            initialEDRepository.save(initialED);
        }else {
            ed807Entity.setInitialED(null);
        }
        if( ed807.getBICDirectoryEntry() != null) {
            List<BICDirectoryEntryType> bicDirectoryEntryTypes = ed807.getBICDirectoryEntry();
            List<BICDirectoryEntry> bicDirectoryEntries = new ArrayList<>();
            for (BICDirectoryEntryType bicDirectoryEntryType: bicDirectoryEntryTypes){
                BICDirectoryEntry bicDirectoryEntry = new BICDirectoryEntry();
                bicDirectoryEntry.setEd807Entity(ed807Entity);
                bicDirectoryEntry.setBIC(bicDirectoryEntryType.getBIC());
                if (bicDirectoryEntryType.getChangeType() != null) {
                    bicDirectoryEntry.setChangeType(bicDirectoryEntryType.getChangeType().value());
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
                    participantInfoEntity.setPtType(bicDirectoryEntryType.getParticipantInfo().getPtType());
                    participantInfoEntity.setSrvcs(bicDirectoryEntryType.getParticipantInfo().getSrvcs());
                    participantInfoEntity.setXchType(bicDirectoryEntryType.getParticipantInfo().getXchType());
                    if (bicDirectoryEntryType.getParticipantInfo().getUID() != null) {
                        participantInfoEntity.setUID(bicDirectoryEntryType.getParticipantInfo().getUID());
                    } else {
                        participantInfoEntity.setUID(null);
                    }
                    if (bicDirectoryEntryType.getParticipantInfo().getParticipantStatus() != null) {
                        participantInfoEntity.setParticipantStatus(bicDirectoryEntryType.getParticipantInfo().getParticipantStatus().value());
                    } else {
                        participantInfoEntity.setParticipantStatus(null);
                    }


                    List<RstrListType> rstrList = bicDirectoryEntryType.getParticipantInfo().getRstrList();
                    if (rstrList != null) {
                        List<RstrListEntity> rstrListEntities = new ArrayList<>();
                        for (RstrListType rstr : rstrList) {

                            RstrListEntity rstrListEntity = new RstrListEntity();
                            rstrListEntity.setRstr(rstr.getRstr().toString());
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
                        List<SWBICSEntity> swbicsEntities = new ArrayList<>();
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
                        List<Accounts> accounts = new ArrayList<>();
                        for (AccountsType accountsType: accountsTypes){
                            Accounts accountsEntity = new Accounts();

                            accountsEntity.setAccount(accountsType.getAccount());
                            accountsEntity.setRegulationAccountType(accountsType.getRegulationAccountType().value());
                            if(accountsType.getAccount() != null) {
                                accountsEntity.setCk(accountsType.getCK());
                            }else {accountsEntity.setCk(null);}
                            accountsEntity.setAccountCBRBIC(accountsType.getAccountCBRBIC());
                            accountsEntity.setDateIn(accountsType.getDateIn().toGregorianCalendar().getTime());
                            if(accountsType.getDateOut() != null) {
                                accountsEntity.setDateOut(accountsType.getDateOut().toGregorianCalendar().getTime());
                            }else {accountsEntity.setDateOut(null);}
                            if(accountsType.getAccountStatus() != null){
                                accountsEntity.setAccountStatus(accountsType.getAccountStatus().value());
                            }else {accountsEntity.setAccountStatus(null);}
                            accountsEntity.setBicDirectoryEntry(bicDirectoryEntry);
                            if (accountsType.getAccRstrList()!= null){
                                List<AccRstrListType> accRstrListTypeList = accountsType.getAccRstrList();
                                List<AccRstrListEntity> accRstrListEntities = new ArrayList<>();
                                for (AccRstrListType accRstrListType: accRstrListTypeList){
                                    AccRstrListEntity accRstrListEntity = new AccRstrListEntity();
                                    accRstrListEntity.setAccounts(accountsEntity);
                                    accRstrListEntity.setAccRstr(accRstrListType.getAccRstr().value());
                                    accRstrListEntity.setAccRstrDate(accRstrListType.getAccRstrDate().toGregorianCalendar().getTime());
                                    if(accRstrListType.getSuccessorBIC()!=null){
                                        accRstrListEntity.setSuccessorBIC(accRstrListType.getSuccessorBIC());
                                    }else {accRstrListEntity.setSuccessorBIC(null);}
                                    accRstrListEntities.add(accRstrListEntity);
                                }
                                accountsEntity.setAccRstrListEntity(accRstrListEntities);
                            }
                            accounts.add(accountsEntity);
                        }
                        bicDirectoryEntry.setAccounts(accounts);
                    }
                }
                bicDirectoryEntry.setEd807Entity(ed807Entity);
                bicDirectoryEntries.add(bicDirectoryEntry);


                bicDirectoryEntity.save(bicDirectoryEntry);
                ed807Entity.setBicDirectoryEntries(bicDirectoryEntries);

                ed807EntityRepository.save(ed807Entity);
            }
        }

    }


    public List<ED807> getAllED807ByName(String name){
        List<ED807Entity> ed807Entities = ed807EntityRepository.findByName(name);
        return ed807Entities.stream()
                .map(this::convertDTOPreview)
                .collect(Collectors.toList());
    }

    public List<ED807> getAllBetwenDate(Date startDate, Date endDate){
        List<ED807Entity> ed807Entities = ed807EntityRepository.findAllByCreationDateBetween(startDate,endDate);
        return ed807Entities.stream()
                .map(this::convertDTOPreview)
                .collect(Collectors.toList());
    }

    public List<ED807> getAllED807() {
        List<ED807Entity> ed807Entities = ed807EntityRepository.findAll();
        return ed807Entities.stream()
                .map(this::convertDTOPreview)
                .collect(Collectors.toList());
    }

    public ED807 getById(BigInteger id){
        Optional<ED807Entity> ed807Entity = ed807EntityRepository.findById(id);
        return ed807Entity.map(this::convertToDTO).orElse(null);
    }


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

    public boolean deleteAll() {
        List<ED807Entity> ed807Entities = ed807EntityRepository.findAll();
        boolean allDeleted = true;

        for (ED807Entity ed807Entity : ed807Entities) {
            try {
                Files.deleteIfExists(Paths.get(ed807Entity.getFilePath()));
            } catch (Exception e) {
                e.printStackTrace();
                allDeleted = false;
            }
        }

        try {
            ed807EntityRepository.deleteAll();
        } catch (Exception e) {
            e.printStackTrace();
            allDeleted = false;
        }

        return allDeleted;
    }

    private ED807 convertDTOPreview(ED807Entity ed807Entity){
        ED807 dto = new ED807();
        // Установка основных полей

        dto.setName(ed807Entity.getName());
        dto.setFilePath(ed807Entity.getFilePath());
        dto.setCreationDate(ed807Entity.getCreationDate());

        // Установка основных полей

        dto.setEDNo(ed807Entity.getEdno());
        dto.setEDDate(toXMLGregorianCalendar(ed807Entity.getEDDate()));
        dto.setEDAuthor(ed807Entity.getEDAuthor());
        if(ed807Entity.getEDReceiver() != null){
            dto.setEDReceiver(ed807Entity.getEDReceiver().toString());
        }else {
            dto.setEDReceiver(null);
        }

        dto.setCreationReason(ReasonCodeType.fromValue(ed807Entity.getCreationReason()));
        dto.setCreationDateTime(toXMLGregorianCalendar(ed807Entity.getCreationDateTime()));
        dto.setInfoTypeCode(RequestCodeType.fromValue(ed807Entity.getInfoTypeCode()));
        dto.setBusinessDay(toXMLGregorianCalendar(ed807Entity.getBusinessDay()));
        if(ed807Entity.getDirectoryVersion() != null) {
            dto.setDirectoryVersion(ed807Entity.getDirectoryVersion());
        }else {
            dto.setDirectoryVersion(null);
        }
        if(ed807Entity.getPartInfo() != null){
            dto.getPartInfo().setPartAggregateID(ed807Entity.getPartInfo().getPartAggregateID());
            dto.getPartInfo().setPartNo(ed807Entity.getPartInfo().getPartNo());
            dto.getPartInfo().setPartQuantity(ed807Entity.getPartInfo().getPartQuantity());
        }else {
            dto.setPartInfo(null);
        }
        return dto;
    }
    private ED807 convertToDTO(ED807Entity ed807Entity) {
        ED807 dto = new ED807();
        // Установка основных полей

        dto.setEDNo(ed807Entity.getEdno());
        dto.setEDDate(toXMLGregorianCalendar(ed807Entity.getEDDate()));
        dto.setEDAuthor(ed807Entity.getEDAuthor());
        if(ed807Entity.getEDReceiver() != null){
            dto.setEDReceiver(ed807Entity.getEDReceiver().toString());
        }else {
            dto.setEDReceiver(null);
        }

        dto.setCreationReason(ReasonCodeType.fromValue(ed807Entity.getCreationReason()));
        dto.setCreationDateTime(toXMLGregorianCalendar(ed807Entity.getCreationDateTime()));
        dto.setInfoTypeCode(RequestCodeType.fromValue(ed807Entity.getInfoTypeCode()));
        dto.setBusinessDay(toXMLGregorianCalendar(ed807Entity.getBusinessDay()));
        if(ed807Entity.getDirectoryVersion() != null) {
            dto.setDirectoryVersion(ed807Entity.getDirectoryVersion());
        }else {
            dto.setDirectoryVersion(null);
        }
        if(ed807Entity.getPartInfo() != null){
            dto.getPartInfo().setPartAggregateID(ed807Entity.getPartInfo().getPartAggregateID());
            dto.getPartInfo().setPartNo(ed807Entity.getPartInfo().getPartNo());
            dto.getPartInfo().setPartQuantity(ed807Entity.getPartInfo().getPartQuantity());
        }else {
            dto.setPartInfo(null);
        }


        // Преобразование связанных сущностей
            List<BICDirectoryEntryType> bicDirectoryEntryDTOs = ed807Entity.getBicDirectoryEntries().stream()
                    .map(this::convertToDTO)
                    .collect(Collectors.toList());
            dto.getBICDirectoryEntry().addAll(bicDirectoryEntryDTOs);

        return dto;
    }

    private BICDirectoryEntryType convertToDTO(BICDirectoryEntry bicDirectoryEntry) {
        BICDirectoryEntryType dto = new BICDirectoryEntryType();
        dto.setBIC(bicDirectoryEntry.getBIC());
        if (bicDirectoryEntry.getChangeType() != null) {
            dto.setChangeType(ChangeType.valueOf(bicDirectoryEntry.getChangeType()));
        } else {
            dto.setChangeType(null);
        }

        // Преобразование связанных сущностей
        if (bicDirectoryEntry.getParticipantInfo() != null) {
            dto.setParticipantInfo(convertToDTO(bicDirectoryEntry.getParticipantInfo())); // Вызов метода для преобразования ParticipantInfoEntity
        }
        if(bicDirectoryEntry.getAccounts() != null){
            List<AccountsType> accountsTypes = bicDirectoryEntry.getAccounts().stream()
                    .map(this::convertToDTO)
                    .collect(Collectors.toList());
            dto.getAccounts().addAll(accountsTypes);
        }else {
            dto.getAccounts().isEmpty();
        }

        if(bicDirectoryEntry.getSwbics() != null){
            List<SWBICList> swbicLists = bicDirectoryEntry.getSwbics().stream()
                    .map((this::convertToDTO))
                    .collect(Collectors.toList());
            dto.getSWBICS().addAll(swbicLists);
        }else {
            dto.getSWBICS().isEmpty();
        }

        return dto;
    }



    private ParticipantInfoType convertToDTO(ParticipantInfoEntity participantInfoEntity) {
        ParticipantInfoType dto = new ParticipantInfoType();
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
        dto.setDateIn(toXMLGregorianCalendar(participantInfoEntity.getDateIn()));
        dto.setDateOut(toXMLGregorianCalendar(participantInfoEntity.getDateOut()));
        dto.setPtType(participantInfoEntity.getPtType());
        dto.setSrvcs(participantInfoEntity.getSrvcs());
        dto.setXchType(participantInfoEntity.getXchType());
        dto.setUID(participantInfoEntity.getUID());
        dto.setParticipantStatus(ParticipantStatusType.fromValue(participantInfoEntity.getParticipantStatus()));

        // Преобразование rstrListEntity в rstrListType
        if(participantInfoEntity.getRstrListEntity() != null) {
            List<RstrListType> rstrList = participantInfoEntity.getRstrListEntity().stream()
                    .map(this::convertToDTO)
                    .collect(Collectors.toList());
            dto.getRstrList().addAll(rstrList);
        }else {
            dto.getRstrList().isEmpty();
        }
        return dto;
    }

    private RstrListType convertToDTO(RstrListEntity entity) {
        if (entity == null) {
            return null;
        }
        RstrListType dto = new RstrListType();
        dto.setRstr(entity.getRstr());
        dto.setRstrDate(toXMLGregorianCalendar(entity.getRstrDate()));
        return dto;
    }

    private AccountsType convertToDTO(Accounts entity){
        if(entity == null){
            return null;
        }
        AccountsType dto = new AccountsType();
        dto.setAccount(entity.getAccount());
        dto.setRegulationAccountType(AccountType.fromValue(entity.getRegulationAccountType()));
        dto.setCK(entity.getCk());
        dto.setAccountCBRBIC(entity.getAccountCBRBIC());
        dto.setDateIn(toXMLGregorianCalendar(entity.getDateIn()));
        if(entity.getDateOut() != null){
            dto.setDateOut(toXMLGregorianCalendar(entity.getDateOut()));
        }else {
            dto.setDateOut(null);
        }
        if(entity.getAccountStatus() != null){
            dto.setAccountStatus(AccountStatusType.valueOf(entity.getAccountStatus()));
        }else {
            dto.setAccountStatus(null);
        }

        if(entity.getAccRstrListEntity() != null){
            List<AccRstrListType> accRstrListTypeList = entity.getAccRstrListEntity().stream()
                    .map(this::convertToDTO)
                    .collect(Collectors.toList());
            dto.getAccRstrList().addAll(accRstrListTypeList);
        }
        return dto;
    }

    private AccRstrListType convertToDTO(AccRstrListEntity entity){
     if(entity == null){
         return null;
     }
     AccRstrListType dto = new AccRstrListType();
     dto.setAccRstr(RstrType.fromValue(entity.getAccRstr()));
     dto.setAccRstrDate(toXMLGregorianCalendar(entity.getAccRstrDate()));
     if(entity.getSuccessorBIC() != null){
         dto.setSuccessorBIC(entity.getSuccessorBIC());
     }else {
         dto.setSuccessorBIC(null);
     }

     return dto;
    }
    private SWBICList convertToDTO(SWBICSEntity entity){
        if(entity == null){
            return null;
        }
        SWBICList dto = new SWBICList();
        dto.setSWBIC(entity.getSWBIC());
        dto.setDefaultSWBIC(entity.isDefaultSWBIC());

        return dto;
    }

    private XMLGregorianCalendar toXMLGregorianCalendar(Date date) {
        if (date == null) {
            return null;
        }
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        gregorianCalendar.setTime(date);
        try {
            return DatatypeFactory.newInstance().newXMLGregorianCalendar(gregorianCalendar);
        } catch (DatatypeConfigurationException e) {
            throw new RuntimeException("Error converting Date to XMLGregorianCalendar", e);
        }
    }
}


