package com.bank.Service;

import com.bank.DB.BICDirectoryEntry;
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
}