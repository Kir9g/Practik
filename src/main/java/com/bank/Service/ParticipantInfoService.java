package com.bank.Service;

import com.bank.DB.BICDirectoryEntry;
import com.bank.DB.ED807Entity;
import com.bank.DB.ParticipantInfoEntity;
import com.bank.DTO.ru.cbr.ed.v2.BICDirectoryEntryType;
import com.bank.DTO.ru.cbr.ed.v2.ParticipantInfoType;
import com.bank.Repository.BICDirectoryEntity;
import com.bank.Repository.ParticipantInfoRepository;
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

    @Transactional
    public ParticipantInfoEntity updateParticipant(BigInteger id, ParticipantInfoType updatedParticipantInfo) {
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
                existingParticipantInfo.setDateIn(updatedParticipantInfo.getDateIn().toGregorianCalendar().getTime());
            }
            if (updatedParticipantInfo.getDateOut() != null) {
                existingParticipantInfo.setDateOut(updatedParticipantInfo.getDateOut().toGregorianCalendar().getTime());
            }
            if (updatedParticipantInfo.getPtType() != null) {
                existingParticipantInfo.setPtType(updatedParticipantInfo.getPtType());
            }
            if (updatedParticipantInfo.getSrvcs() != null) {
                existingParticipantInfo.setSrvcs(updatedParticipantInfo.getSrvcs());
            }
            if (updatedParticipantInfo.getXchType() != null) {
                existingParticipantInfo.setXchType(updatedParticipantInfo.getXchType());
            }
            if (updatedParticipantInfo.getUID() != null) {
                existingParticipantInfo.setUID(updatedParticipantInfo.getUID());
            }
            if (updatedParticipantInfo.getParticipantStatus() != null) {
                existingParticipantInfo.setParticipantStatus(updatedParticipantInfo.getParticipantStatus().value());
            }
            participantInfoRepository.save(existingParticipantInfo);
            return existingParticipantInfo;
        }
        return null;
    }
    @Transactional
    public ParticipantInfoType createPart(BICDirectoryEntry bicDirectoryEntry,
                                          ParticipantInfoType participantInfoType){
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
        participantInfoEntity.setDateIn(participantInfoType.getDateIn().toGregorianCalendar().getTime());
        if (participantInfoType.getDateOut() != null) {
            participantInfoEntity.setDateOut(participantInfoType.getDateOut().toGregorianCalendar().getTime());
        } else {
            participantInfoEntity.setDateOut(null);
        }
        participantInfoEntity.setPtType(participantInfoType.getPtType());
        participantInfoEntity.setSrvcs(participantInfoType.getSrvcs());
        participantInfoEntity.setXchType(participantInfoType.getXchType());
        if (participantInfoType.getUID() != null) {
            participantInfoEntity.setUID(participantInfoType.getUID());
        } else {
            participantInfoEntity.setUID(null);
        }
        if (participantInfoType.getParticipantStatus() != null) {
            participantInfoEntity.setParticipantStatus(participantInfoType.getParticipantStatus().value());
        } else {
            participantInfoEntity.setParticipantStatus(null);
        }
        bicDirectoryEntity.save(bicDirectoryEntry);
        participantInfoRepository.save(participantInfoEntity);
        return participantInfoType;
    }
}