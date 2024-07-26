package com.bank.Service;

import com.bank.DB.ED807Entity;
import com.bank.DB.InitialED;
import com.bank.DB.PartInfoEntity;
import com.bank.DTO.Models.ED807DTO;
import com.bank.DTO.ru.cbr.ed.v2.InitialEDInfo;
import com.bank.DTO.ru.cbr.ed.v2.PartInfo;
import com.bank.Repository.ED807EntityRepository;
import com.bank.Repository.PartInfoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.Optional;

@Service
public class PartInfoSerivce {
    @Autowired
    private PartInfoRepository partInfoRepository;
    @Autowired
    private ED807EntityRepository ed807EntityRepository;
    public ED807Entity updatePartInfo(ED807Entity ed807, PartInfo partInfo){
        PartInfoEntity partInfoEntity = ed807.getPartInfoEntity();
        if(partInfoEntity!=null){
            if(partInfo.getPartQuantity()!=null) {
                partInfoEntity.setPartQuantity(partInfo.getPartQuantity());
            }
            if(partInfo.getPartNo()!=null) {
                partInfoEntity.setPartNo(partInfo.getPartNo());
            }
            if(partInfo.getPartAggregateID()!=null) {
                partInfoEntity.setPartAggregateID(partInfo.getPartAggregateID());
            }
            partInfoRepository.save(partInfoEntity);
            return partInfoEntity.getEd807Entity();
        }else {
            return null;
        }
    }
    @Transactional
    public PartInfoEntity createPart(ED807Entity ed807Entity, PartInfo partInfo){
        PartInfoEntity partInfoEntity = new PartInfoEntity();
        partInfoEntity.setEd807Entity(ed807Entity);
        partInfoEntity.setPartNo(partInfo.getPartNo());
        partInfoEntity.setPartQuantity(partInfo.getPartQuantity());
        partInfoEntity.setPartAggregateID(partInfo.getPartAggregateID());

        partInfoRepository.save(partInfoEntity);
        ed807Entity.setPartInfoEntity(partInfoEntity);
        ed807EntityRepository.save(ed807Entity);
        return partInfoEntity;
    }
}
