package com.bank.Service;

import com.bank.DB.ED807Entity;
import com.bank.DB.PartInfoEntity;
import com.bank.DB.ParticipantInfoEntity;
import com.bank.DB.RstrListEntity;
import com.bank.DTO.Models.RstrListDTO;
import com.bank.DTO.ru.cbr.ed.v2.PartInfo;
import com.bank.DTO.ru.cbr.ed.v2.RstrListType;
import com.bank.Repository.PartInfoRepository;
import com.bank.Repository.ParticipantInfoRepository;
import com.bank.Repository.RstrListRepository;
import com.bank.Repository.RstrRepository;
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
    @Autowired
    private RstrRepository rstrRepository;

    @Transactional
    public RstrListEntity updateRstr(BigInteger id, RstrListDTO rstrListDTO){
        Optional<RstrListEntity> rstrListEntity = rstrListRepository.findById(id);
        if(rstrListEntity!=null){
            RstrListEntity rstrListEntity1 = rstrListEntity.get();
            if(rstrListDTO.getRstr() !=null) {
                rstrListEntity1.setRstrEntity(rstrRepository.findByName(rstrListDTO.getRstr()));
            }
            if(rstrListDTO.getRstrDate()!=null) {
                rstrListEntity1.setRstrDate(rstrListDTO.getRstrDate());
            }
            return rstrListRepository.save(rstrListEntity1);
        }else {
            return null;
        }
    }
    @Transactional
    public RstrListEntity createRstr(ParticipantInfoEntity participantInfoEntity, RstrListDTO rstrListDTO){
        RstrListEntity rstrListEntity = new RstrListEntity();
        if(rstrListDTO.getRstrDate()!= null){
            rstrListEntity.setRstrDate(rstrListDTO.getRstrDate());
        }
        if(rstrListDTO.getRstr()!= null){
            rstrListEntity.setRstrEntity(rstrRepository.findByName(rstrListDTO.getRstr()));
        }
        rstrListEntity.setParticipantInfoEntity(participantInfoEntity);
        participantInfoEntity.addRstrListEntity(rstrListEntity);

        participantInfoRepository.save(participantInfoEntity);
        rstrListRepository.save(rstrListEntity);
        return rstrListEntity;
    }
}
