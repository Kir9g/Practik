package com.bank.Service;

import com.bank.DB.BICDirectoryEntry;
import com.bank.DB.ParticipantInfoEntity;
import com.bank.DTO.Models.ParticipantInfoDTO;
import com.bank.Repository.*;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.Optional;
@Service
public class ParticipantInfoService {
    @Autowired
    private ParticipantInfoRepository participantInfoRepository;
    @Autowired
    private BICDirectoryEntity bicDirectoryEntity;
    @Autowired
    private PtTypeRepository ptTypeRepository;
    @Autowired
    private SrvcsRepository srvcsRepository;
    @Autowired
    private XchTypeRepository xchTypeRepository;
    @Autowired
    private ParticipantStatusRepository participantStatusRepository;

    @Transactional
    public ParticipantInfoEntity updateParticipant(BigInteger id, ParticipantInfoDTO updatedParticipantInfo) {
        Optional<ParticipantInfoEntity> participantInfoOptional = participantInfoRepository.findById(id);

        if (participantInfoOptional.isPresent()) {
            ParticipantInfoEntity existingParticipantInfo = participantInfoOptional.get();

            // Обновление полей сущности
            if (updatedParticipantInfo.getNameP() != null) {
                existingParticipantInfo.setNameP(updatedParticipantInfo.getNameP());
            }
            if (updatedParticipantInfo.getEnglName() != null) {
                existingParticipantInfo.setEnglName(updatedParticipantInfo.getEnglName());
            }
            if (updatedParticipantInfo.getRegN() != null) {
                existingParticipantInfo.setRegN(updatedParticipantInfo.getRegN());
            }
            if (updatedParticipantInfo.getCntrCd() != null) {
                existingParticipantInfo.setCntrCd(updatedParticipantInfo.getCntrCd());
            }
            if (updatedParticipantInfo.getRgn() != null) {
                existingParticipantInfo.setRgn(updatedParticipantInfo.getRgn());
            }
            if (updatedParticipantInfo.getInd() != null) {
                existingParticipantInfo.setInd(updatedParticipantInfo.getInd());
            }
            if (updatedParticipantInfo.getTnp() != null) {
                existingParticipantInfo.setTnp(updatedParticipantInfo.getTnp());
            }
            if (updatedParticipantInfo.getNnp() != null) {
                existingParticipantInfo.setNnp(updatedParticipantInfo.getNnp());
            }
            if (updatedParticipantInfo.getAdr() != null) {
                existingParticipantInfo.setAdr(updatedParticipantInfo.getAdr());
            }
            if (updatedParticipantInfo.getPrntBIC() != null) {
                existingParticipantInfo.setPrntBIC(updatedParticipantInfo.getPrntBIC());
            }
            if (updatedParticipantInfo.getDateIn() != null) {
                existingParticipantInfo.setDateIn(updatedParticipantInfo.getDateIn());
            }
            if (updatedParticipantInfo.getDateOut() != null) {
                existingParticipantInfo.setDateOut(updatedParticipantInfo.getDateOut());
            }
            if (updatedParticipantInfo.getPtType() != null) {
                existingParticipantInfo.setPtTypeEntity(ptTypeRepository.findByName(updatedParticipantInfo.getPtType()));
            }
            if (updatedParticipantInfo.getSrvcs() != null) {
                existingParticipantInfo.setSrvcsEntity(srvcsRepository.findByName(updatedParticipantInfo.getSrvcs()));
            }
            if (updatedParticipantInfo.getXchType() != null) {
                existingParticipantInfo.setXchTypeEntity(xchTypeRepository.findByName(updatedParticipantInfo.getXchType()));
            }
            if (updatedParticipantInfo.getUid() != null) {
                existingParticipantInfo.setUID(updatedParticipantInfo.getUid());
            }
            if (updatedParticipantInfo.getParticipantStatus() != null) {
                existingParticipantInfo.setParticipantStatus(participantStatusRepository.findByName(updatedParticipantInfo.getParticipantStatus()));
            }
            participantInfoRepository.save(existingParticipantInfo);
            return existingParticipantInfo;
        }
        return null;
    }
    @Transactional
    public void createPart(BICDirectoryEntry bicDirectoryEntry,
                                          ParticipantInfoDTO participantInfoType){
        ParticipantInfoEntity participantInfoEntity = new ParticipantInfoEntity();

        bicDirectoryEntry.setParticipantInfo(participantInfoEntity);

        participantInfoEntity.setNameP(participantInfoType.getNameP());
        if (participantInfoType.getEnglName() != null) {
            participantInfoEntity.setEnglName(participantInfoType.getEnglName());
        } else {
            participantInfoEntity.setEnglName(null);
        }
        if (participantInfoType.getRegN() != null) {
            participantInfoEntity.setRegN(participantInfoType.getRegN());
        } else {
            participantInfoEntity.setRegN(null);
        }
        if (participantInfoType.getCntrCd() != null) {
            participantInfoEntity.setCntrCd(participantInfoType.getCntrCd());
        } else {
            participantInfoEntity.setCntrCd(null);
        }

        participantInfoEntity.setRgn(participantInfoType.getRgn());

        if (participantInfoType.getInd() != null) {
            participantInfoEntity.setInd(participantInfoType.getInd());
        } else {
            participantInfoEntity.setInd(null);
        }

        if (participantInfoType.getTnp() != null) {
            participantInfoEntity.setTnp(participantInfoType.getTnp());
        } else {
            participantInfoEntity.setTnp(null);
        }

        if (participantInfoType.getNnp() != null) {
            participantInfoEntity.setNnp(participantInfoType.getNnp());
        } else {
            participantInfoEntity.setNnp(null);
        }

        if (participantInfoType.getAdr() != null) {
            participantInfoEntity.setAdr(participantInfoType.getAdr());
        } else {
            participantInfoEntity.setAdr(null);
        }
        if (participantInfoType.getPrntBIC() != null) {
            participantInfoEntity.setPrntBIC(participantInfoType.getPrntBIC());
        } else {
            participantInfoEntity.setPrntBIC(null);
        }
        participantInfoEntity.setDateIn(participantInfoType.getDateIn());
        if (participantInfoType.getDateOut() != null) {
            participantInfoEntity.setDateOut(participantInfoType.getDateOut());
        } else {
            participantInfoEntity.setDateOut(null);
        }
        participantInfoEntity.setPtTypeEntity(ptTypeRepository.findByName(participantInfoType.getPtType()));
        participantInfoEntity.setSrvcsEntity(srvcsRepository.findByName(participantInfoType.getSrvcs()));
        participantInfoEntity.setXchTypeEntity(xchTypeRepository.findByName(participantInfoType.getXchType()));
        if (participantInfoType.getUid() != null) {
            participantInfoEntity.setUID(participantInfoType.getUid());
        } else {
            participantInfoEntity.setUID(null);
        }
        if (participantInfoType.getParticipantStatus() != null) {
            participantInfoEntity.setParticipantStatus(participantStatusRepository.findByName(participantInfoType.getParticipantStatus()));
        } else {
            participantInfoEntity.setParticipantStatus(null);
        }
        bicDirectoryEntity.save(bicDirectoryEntry);
        participantInfoRepository.save(participantInfoEntity);

    }
}