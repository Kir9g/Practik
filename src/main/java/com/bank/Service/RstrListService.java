package com.bank.Service;

import com.bank.DB.ED807Entity;
import com.bank.DB.PartInfoEntity;
import com.bank.DB.ParticipantInfoEntity;
import com.bank.DB.RstrListEntity;
import com.bank.DTO.ru.cbr.ed.v2.PartInfo;
import com.bank.DTO.ru.cbr.ed.v2.RstrListType;
import com.bank.Repository.PartInfoRepository;
import com.bank.Repository.ParticipantInfoRepository;
import com.bank.Repository.RstrListRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.Optional;
@Service
public class RstrListService {
    @Autowired
    private RstrListRepository rstrListRepository;
    @Autowired
    private ParticipantInfoRepository participantInfoRepository;

    @Transactional
    public RstrListEntity updateRstr(BigInteger id, RstrListType rstrListType){
        Optional<RstrListEntity> rstrListEntity = rstrListRepository.findById(id);
        if(rstrListEntity!=null){
            RstrListEntity rstrListEntity1 = rstrListEntity.get();
            if(rstrListType.getRstr() !=null) {
                rstrListEntity1.setRstr(rstrListType.getRstr().value());
            }
            if(rstrListType.getRstrDate()!=null) {
                rstrListEntity1.setRstrDate(rstrListType.getRstrDate().toGregorianCalendar().getTime());
            }
            return rstrListRepository.save(rstrListEntity1);
        }else {
            return null;
        }
    }
    @Transactional
    public RstrListEntity createRstr(ParticipantInfoEntity participantInfoEntity, RstrListType rstrListType){
        RstrListEntity rstrListEntity = new RstrListEntity();
        if(rstrListType.getRstrDate()!= null){
            rstrListEntity.setRstrDate(rstrListType.getRstrDate().toGregorianCalendar().getTime());
        }
        if(rstrListType.getRstr()!= null){
            rstrListEntity.setRstr(rstrListType.getRstr().value());
        }
        rstrListEntity.setParticipantInfoEntity(participantInfoEntity);
        participantInfoEntity.addRstrListEntity(rstrListEntity);

        participantInfoRepository.save(participantInfoEntity);
        rstrListRepository.save(rstrListEntity);
        return rstrListEntity;
    }
}
